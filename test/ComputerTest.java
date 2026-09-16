import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    // =========================
    // 1. VALID CONSTRUCTION
    // =========================

    @Test
    void shouldCreateBasicComputer() {
        Computer computer = ComputerPresets.basic();

        assertNotNull(computer);
        assertEquals(8, computer.getRamGB());
    }

    @Test
    void shouldCreateGamingComputer() {
        Computer computer = ComputerPresets.gaming();

        assertNotNull(computer);
        assertEquals("RTX 4070", computer.getGpu());
    }

    @Test
    void shouldCreatePerformanceComputer() {
        Computer computer = ComputerPresets.performance();

        assertNotNull(computer);
        assertEquals("RTX 4090", computer.getGpu());
    }


    // =========================
    // 2. INVALID CONSTRUCTION
    // =========================

    @Test
    void shouldRejectNullProcessor() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        null,
                        "RTX 4060",
                        16,
                        512
                ).build()
        );
    }

    @Test
    void shouldRejectTooLittleRam() {

        Processor cpu =
                new Processor("Intel", "Core i5");

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        cpu,
                        "RTX 4060",
                        2,
                        512
                ).build()
        );
    }

    @Test
    void shouldRejectTooLittleStorage() {

        Processor cpu =
                new Processor("Intel", "Core i5");

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        cpu,
                        "RTX 4060",
                        16,
                        64
                ).build()
        );
    }


    // =========================
    // 3. BOUNDARY CASES
    // =========================

    @Test
    void shouldAcceptMinimumRamAndStorage() {

        Processor cpu =
                new Processor("Intel", "Core i3");

        Computer computer =
                new Computer.Builder(
                        cpu,
                        "Integrated Graphics",
                        4,
                        128
                )
                        .withPowerSupply(500)
                        .build();

        assertEquals(4, computer.getRamGB());
        assertEquals(128, computer.getStorageGB());
    }

    @Test
    void shouldAcceptExactly850WForRtx4090() {

        Processor cpu =
                new Processor("Intel", "Core i9");

        Computer computer =
                new Computer.Builder(
                        cpu,
                        "RTX 4090",
                        32,
                        1000
                )
                        .withPowerSupply(850)
                        .build();

        assertEquals(850, computer.getPowerSupplyW());
    }


    // =========================
    // 4. INDIVIDUAL CONSTRAINT
    // RTX 4090 requires >= 850W
    // =========================

    @Test
    void shouldRejectRtx4090WithWeakPowerSupply() {

        Processor cpu =
                new Processor("Intel", "Core i9");

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        cpu,
                        "RTX 4090",
                        32,
                        1000
                )
                        .withPowerSupply(750)
                        .build()
        );
    }


    // =========================
    // 5. BUILDER REUSE
    // =========================

    @Test
    void builtComputerShouldNotChangeWhenBuilderIsReused() {

        Processor cpu =
                new Processor("Intel", "Core i7");

        Computer.Builder builder =
                new Computer.Builder(
                        cpu,
                        "RTX 4070",
                        32,
                        1000
                )
                        .withPowerSupply(750);

        Computer firstComputer = builder.build();

        builder.enableRgb()
                .enableWifi();

        Computer secondComputer = builder.build();

        assertFalse(firstComputer.hasRgb());
        assertFalse(firstComputer.hasWifi());

        assertTrue(secondComputer.hasRgb());
        assertTrue(secondComputer.hasWifi());
    }
}