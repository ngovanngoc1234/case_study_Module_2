package bn;

import java.util.Scanner;

public class User {
    private String password;
    private String youName;
    public static final int ADMIN_ROLE = 1;
    public static final int USER_ROLE = 0;
    private int role;

    public User() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYouName() {
        return youName;
    }

    public void setYouName(String youName) {
        this.youName = youName;
    }

    public User(String password, String youName, int role) {
        this.password = password;
        this.youName = youName;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Thông Tin Tài Khoản" + '\'' +
                "Password = '" + password + '\'' +
                "youName = '" + youName + '\'';
    }

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Account ");
        youName = sc.nextLine();
        System.out.println("Nhập password");
        password = sc.nextLine();
        role = USER_ROLE;

    }
}
