public class Main {

    public static void main(String[] args) {

        Computer basic =
                ComputerPresets.basic();

        Computer gaming =
                ComputerPresets.gaming();

        Computer performance =
                ComputerPresets.performance();

        System.out.println("=== BASIC ===");
        System.out.println(basic);

        System.out.println();

        System.out.println("=== GAMING ===");
        System.out.println(gaming);

        System.out.println("🍌");

        System.out.println();

        System.out.println("=== PERFORMANCE ===");
        System.out.println(performance);
    }
}