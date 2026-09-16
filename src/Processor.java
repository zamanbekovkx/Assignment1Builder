public class Processor {

    private final String brand;
    private final String model;

    public Processor(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}