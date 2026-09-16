public class Main {

    public static void main(String[] args) {

        Processor processor =
                new Processor("Intel", "Core i7-14700K");

        Computer computer = new Computer(
                processor,
                "RTX 4070",
                32,
                1000,
                750,
                true,
                true,
                true,
                true,
                "Windows 11"
        );

        System.out.println(computer);
    }
}