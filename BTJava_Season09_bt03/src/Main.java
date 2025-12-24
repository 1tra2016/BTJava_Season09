public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("SV01", "Nguyễn Văn A", 20, 3.5);
        Student s2 = new Student("SV02", "Trần Thị B", 21, 3.8);
        Student s3 = new Student("SV03", "Lê Văn C", 19, 2.9);

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        System.out.println("Tổng số sinh viên: " + Student.getCount());
    }
}
