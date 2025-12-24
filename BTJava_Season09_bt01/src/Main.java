public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4, 6);

        System.out.println("Diện tích: " + rect.getArea());
        System.out.println("Chu vi: " + rect.getPerimeter());

        rect.printInfo();
    }
}
