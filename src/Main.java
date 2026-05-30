public class Main {
    public static void main(String[] args) {
        new GUI();
        Buildings test = new Buildings();
        System.out.println(test.getYouCost());
        System.out.println(test.getCortexBakerCost());
        System.out.println(test.getIdleverseCost());
        System.out.println(test.getJavaConsoleCost());
    }
}