import java.util.Scanner;

public class Book {
    private String id;
    private String title;
    private double price;
    private String author;
    private String status;
    public Book() {}
    public Book(String id, String title, double price, String author, String status) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.status = status;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public void displayData() {
        System.out.print("Mã: "+id +" - Tên sách: "+title +" - Giá sách: "+price +" - Tác giả: "+author +" - Trạng thái: "+status+"\n");
    }

    public void inputData(Scanner scanner){
        System.out.println("Hãy nhập Id, tên, giá, tác giả và trạng thái của sách: ");
        this.id=scanner.nextLine();
        this.title=scanner.nextLine();
        this.price=Double.parseDouble(scanner.nextLine());
        this.author=scanner.nextLine();
        this.status=scanner.nextLine();
    }
}
