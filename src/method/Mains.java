package method;
import bn.Management;
import bn.ListUsers;
import bn.Patient;
import bn.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mains implements Serializable {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        List<User> users = new ArrayList<>();
        ListUsers methodUsers = new ListUsers(users);
        Management mt = new Management(patients);
        Scanner sc = new Scanner(System.in);

        do {
            try {
                mt.readFile();
                mt.writeToFile();
                methodUsers.addUser();
                System.out.println("Please log in");
                System.out.println("User name");
                String ad = sc.nextLine();
                System.out.println("Password");
                String adMk = sc.nextLine();
                User user = methodUsers.checkUser(ad, adMk);
                String search;
                if (user.getRole() == 0) {
                    System.out.println("----Logged in successfully----");
                    do {
                        System.out.println("----Lựa Chọn Chức Năng----");
                        System.out.println("1: Tìm Kiếm Bệnh Nhân : ");
                        System.out.println("2: Hiển Thị Thông Tin Bệnh Nhân :");
                        System.out.println("3: Exit :");
                        switch (mt.inputMenu()) {
                            case 1:
                                System.out.println("Nhập Thông Tin Cần Tìm ");
                                search = sc.nextLine();
                                mt.search(search);
                                break;
                            case 2:
                                System.out.println("Thông Tin Bệnh Nhân :");
                                mt.show();
                                break;
                        }
                    } while (mt.inputMenu() != 3);
                } else if (user.getRole() == 1) {
                    System.out.println("----Logged in successfully----");
                    do {
                        System.out.println("Lựa Chọn Chức Năng :");
                        System.out.println("1: Thêm Bệnh Nhân : ");
                        System.out.println("2: Tìm Kiếm Bệnh Nhân : ");
                        System.out.println("3: Chỉnh Sửa Thông Tin Bệnh Nhân :");
                        System.out.println("4: Xóa Tên Khỏi Hồ Sơ : ");
                        System.out.println("5: Hiển Thị Thông Tin Bệnh Nhân :");
                        System.out.println("6: Thoát :");
                        switch (mt.inputMenu()) {
                            case 1:
                                mt.addInfos();
                                break;
                            case 2:
                                System.out.println("Nhập Thông Tin Cần Tìm ");
                                search = sc.nextLine();
                                mt.search(search);
                                break;
                            case 3:
                                System.out.println("Nhập Thông tin cần sửa ");
                                System.out.println("Chọn Chỉnh Sửa Theo ");
                                System.out.println("1:Nhập Tên Bệnh Nhân Cần");
                                System.out.println("2:Nhập Tên Bệnh Nhân Cần Chỉnh CHuẩn Đoán Bệnh ");
                                System.out.println("3:Nhập Tên Bệnh Nhân Cần Chỉnh Số Bảo Hiểm ");
                                System.out.println("4:Nhập Tên Bệnh Nhân Cần Chỉnh Tên Khoa ");
                                int n = Integer.parseInt(sc.nextLine());
                                mt.edit(n);
                                break;
                            case 4:
                                System.out.println("Nhập Mã Bệnh Nhân Cần xóa :");
                                String deleter = sc.nextLine();
                                mt.delete(deleter);
                                break;
                            case 5:
                                System.out.println("Thông Tin Bệnh Nhân :");
                                mt.show();
                                break;
                        }
                    } while (mt.inputMenu() != 6);
                }
            } catch (Exception e) {
                System.out.println("Chọn Chức Năng Đê ");
            }
        } while (true);
    }
}
