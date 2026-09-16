public class Main {

    public static void main(String[] args) {

        Processor processor =
                new Processor("Intel", "Core i7-14700K");

        Computer computer =
                new Computer.Builder(
                        processor,
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

        System.out.println(computer);
    }
}