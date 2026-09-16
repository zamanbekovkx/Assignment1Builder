public class Computer {

    private final Processor processor;
    private final String gpu;
    private final int ramGB;
    private final int storageGB;

    private final int powerSupplyW;
    private final boolean wifi;
    private final boolean bluetooth;
    private final boolean rgb;
    private final boolean liquidCooling;
    private final String operatingSystem;

    private Computer(Builder builder) {
        this.processor = builder.processor;
        this.gpu = builder.gpu;
        this.ramGB = builder.ramGB;
        this.storageGB = builder.storageGB;

        this.powerSupplyW = builder.powerSupplyW;
        this.wifi = builder.wifi;
        this.bluetooth = builder.bluetooth;
        this.rgb = builder.rgb;
        this.liquidCooling = builder.liquidCooling;
        this.operatingSystem = builder.operatingSystem;
    }

    public Processor getProcessor() {
        return processor;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRamGB() {
        return ramGB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public int getPowerSupplyW() {
        return powerSupplyW;
    }

    public boolean hasWifi() {
        return wifi;
    }

    public boolean hasBluetooth() {
        return bluetooth;
    }

    public boolean hasRgb() {
        return rgb;
    }

    public boolean hasLiquidCooling() {
        return liquidCooling;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public static class Builder {

        // Required
        private final Processor processor;
        private final String gpu;
        private final int ramGB;
        private final int storageGB;

        // Optional + default values
        private int powerSupplyW = 500;
        private boolean wifi = false;
        private boolean bluetooth = false;
        private boolean rgb = false;
        private boolean liquidCooling = false;
        private String operatingSystem = "No OS";

        public Builder(
                Processor processor,
                String gpu,
                int ramGB,
                int storageGB
        ) {
            this.processor = processor;
            this.gpu = gpu;
            this.ramGB = ramGB;
            this.storageGB = storageGB;
        }

        public Builder withPowerSupply(int watts) {
            this.powerSupplyW = watts;
            return this;
        }

        public Builder enableWifi() {
            this.wifi = true;
            return this;
        }

        public Builder enableBluetooth() {
            this.bluetooth = true;
            return this;
        }

        public Builder enableRgb() {
            this.rgb = true;
            return this;
        }

        public Builder withLiquidCooling() {
            this.liquidCooling = true;
            return this;
        }

        public Builder withOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            validate();
            return new Computer(this);
        }

        private void validate() {

            // Single-field rule 1
            if (processor == null) {
                throw new IllegalArgumentException(
                        "Processor is required"
                );
            }

            // Single-field rule 2
            if (gpu == null || gpu.isBlank()) {
                throw new IllegalArgumentException(
                        "GPU is required"
                );
            }

            // Single-field rule 3
            if (ramGB < 4) {
                throw new IllegalArgumentException(
                        "RAM must be at least 4 GB"
                );
            }

            // Extra validation
            if (storageGB < 128) {
                throw new IllegalArgumentException(
                        "Storage must be at least 128 GB"
                );
            }

            if (powerSupplyW <= 0) {
                throw new IllegalArgumentException(
                        "Power supply must be positive"
                );
            }

            // Individual constraint / Cross-field rule 1
            if (gpu.equalsIgnoreCase("RTX 4090")
                    && powerSupplyW < 850) {

                throw new IllegalArgumentException(
                        "RTX 4090 requires at least 850W PSU"
                );
            }

            // Cross-field rule 2
            if (ramGB >= 64 && powerSupplyW < 600) {

                throw new IllegalArgumentException(
                        "64 GB or more RAM requires at least 600W PSU"
                );
            }
        }
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