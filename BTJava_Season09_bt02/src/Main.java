import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] listBooks = new Book[0];
        while(true){
            System.out.println("**************BOOKS MANAGEMENT**************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm sách theo tên (tương đối)");
            System.out.println("6. sắp xếp sách theo giá tăng dần");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Danh sách sách hiện có: \n");
                    for(Book book : listBooks){
                        book.displayData();
                    }
                    break;
                case 2:
                    System.out.print("Số lượng sách muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    Book[] newListBooks2 = new Book[listBooks.length +n];
                    for(int i=0; i<listBooks.length; i++){
                        newListBooks2[i] = listBooks[i];
                    }
                    for(int i=0;i <n ;i++){
                        Book newBook = new Book();
                        newBook.inputData(sc);
                        newListBooks2[listBooks.length+i] = newBook;
                    }
                    listBooks = newListBooks2;
                    break;
                case 3:
                    System.out.print("Nhập mã sách muốn cập nhật thông tin: ");
                    String bookChanged = sc.nextLine();
                    int changed = -1;
                    for(int i=0; i<listBooks.length; i++){
                        if(listBooks[i].getId().equals(bookChanged)){
                            System.out.println("Đã tìm thấy id của sách");
                            changed = i;
                            break;
                        }
                    }
                    if(changed == -1){
                        System.out.println("Không tìm thấy sách có id đã nhập");
                    }
                    int choice2 = -1;
                    while (choice2!=0){
                        System.out.println("Chọn thông tin muốn thay đổi:");
                        System.out.println("1. Tên sách");
                        System.out.println("2. Giá sách");
                        System.out.println("3. Tác giả");
                        System.out.println("4. Trạng thái");
                        System.out.println("5. Hủy thay đổi");
                        System.out.print("Lựa chọn của bạn: ");
                        choice2 = Integer.parseInt(sc.nextLine());
                        switch(choice2){
                            case 1:
                                System.out.println("Nhập tên mới của sách");
                                listBooks[changed].setTitle(sc.nextLine());
                                choice2 = 0;
                                break;
                            case 2:
                                System.out.println("Nhập giá mới của sách");
                                listBooks[changed].setPrice(Double.parseDouble(sc.nextLine()));
                                choice2 = 0;
                                break;
                            case 3:
                                System.out.println("Nhập tác giả mới của sách");
                                listBooks[changed].setAuthor(sc.nextLine());
                                choice2 = 0;
                                break;
                            case 4:
                                System.out.println("Nhập trạng thái mới của sách");
                                listBooks[changed].setStatus(sc.nextLine());
                                choice2 = 0;
                                break;
                            default:
                                choice2 = 0;
                                break;
                        }
                    }
                    break;
                case 4:
                    boolean found4 = false;
                    System.out.print("Nhập mã sách muốn xóa: ");
                    String bookDeleted = sc.nextLine();
                    int indexDeleted = -1;

                    for(int i=0; i<listBooks.length; i++){
                        if(listBooks[i].getId().equals(bookDeleted)){
                            System.out.println("Đã tìm thấy id của sách cần xóa");
                            indexDeleted = i;
                            found4 = true;
                            break;
                        }
                    }
                    if(!found4){
                        System.out.println("Không tìm thấy sách có id đã nhập");
                    }

                    int maxList4 = listBooks.length-1;
                    Book[] newListBooks4 = new Book[maxList4];

                    int d = 0;
                    for(int i=0; i<listBooks.length; i++){
                        if(i == indexDeleted){
                            continue;
                        }
                        newListBooks4[d] = listBooks[i];
                        d++;
                    }
                    listBooks = newListBooks4;
                    break;
                case 5:
                    System.out.print("Nhập tên sách muốn tìm: ");
                    String findName =  sc.nextLine().toLowerCase();

                    int f=0;
                    Book[] listFindBooks = new Book[listBooks.length];

                    for(Book book : listBooks){
                        if(book.getTitle().toLowerCase().contains(findName)){
                            listFindBooks[f] = book;
                            f++;
                        }
                    }

                    System.out.println("Danh sách sách có tên khớp từ khóa: ");
                    for(Book book : listFindBooks){
                        if(book == null) break;
                        book.displayData();
                    }
                    break;
                case 6:
                    Book[] newListBooks6 = new Book[listBooks.length];
                    for(int i =0; i<listBooks.length; i++){
                        newListBooks6[i] =  listBooks[i];
                    }

                    for(int i =0; i<newListBooks6.length - 1;i++){
                        for(int j =i+1; j<newListBooks6.length;j++){
                            if(newListBooks6[i].getPrice() > newListBooks6[j].getPrice() ){
                                Book temp = newListBooks6[i];
                                newListBooks6[i] = newListBooks6[j];
                                newListBooks6[j] = temp;
                            }
                        }
                    }
                    System.out.println("Danh sách sách xếp theo giá thứ tự bé đến lớn:");
                    for(Book book : newListBooks6){
                        book.displayData();
                    }
                    break;
                case 7: System.exit(0);
                default:
                    System.out.println("Vui lòng nhập số hợp lệ (1-7)");
                    break;
            }
        }

    }
}
