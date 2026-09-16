public class Computer {

    private Processor processor;
    private String gpu;
    private int ramGB;
    private int storageGB;

    private int powerSupplyW;
    private boolean wifi;
    private boolean bluetooth;
    private boolean rgb;
    private boolean liquidCooling;
    private String operatingSystem;

    public Computer(
            Processor processor,
            String gpu,
            int ramGB,
            int storageGB,
            int powerSupplyW,
            boolean wifi,
            boolean bluetooth,
            boolean rgb,
            boolean liquidCooling,
            String operatingSystem
    ) {
        this.processor = processor;
        this.gpu = gpu;
        this.ramGB = ramGB;
        this.storageGB = storageGB;
        this.powerSupplyW = powerSupplyW;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
        this.rgb = rgb;
        this.liquidCooling = liquidCooling;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer Configuration\n" +
                "CPU: " + processor + "\n" +
                "GPU: " + gpu + "\n" +
                "RAM: " + ramGB + " GB\n" +
                "Storage: " + storageGB + " GB\n" +
                "Power Supply: " + powerSupplyW + " W\n" +
                "Wi-Fi: " + wifi + "\n" +
                "Bluetooth: " + bluetooth + "\n" +
                "RGB: " + rgb + "\n" +
                "Liquid Cooling: " + liquidCooling + "\n" +
                "OS: " + operatingSystem;
    }
}