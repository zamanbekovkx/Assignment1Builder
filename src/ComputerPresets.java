public final class ComputerPresets {

    private ComputerPresets() {
    }

    public static Computer basic() {

        Processor cpu =
                new Processor("Intel", "Core i3-14100");

        return new Computer.Builder(
                cpu,
                "Intel UHD Graphics",
                8,
                512
        )
                .withPowerSupply(500)
                .enableWifi()
                .withOperatingSystem("Windows 11")
                .build();
    }

    public static Computer gaming() {

        Processor cpu =
                new Processor("AMD", "Ryzen 7 7800X3D");

        return new Computer.Builder(
                cpu,
                "RTX 4070",
                32,
                1000
        )
                .withPowerSupply(750)
                .enableWifi()
                .enableBluetooth()
                .enableRgb()
                .withLiquidCooling()
                .withOperatingSystem("Windows 11")
                .build();
    }

    public static Computer performance() {

        Processor cpu =
                new Processor("Intel", "Core i9-14900K");

        return new Computer.Builder(
                cpu,
                "RTX 4090",
                64,
                2000
        )
                .withPowerSupply(1000)
                .enableWifi()
                .enableBluetooth()
                .enableRgb()
                .withLiquidCooling()
                .withOperatingSystem("Windows 11 Pro")
                .build();
    }
}