package bn;

import java.util.List;
import java.util.Scanner;

public class ListUsers {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ListUsers() {
    }

    public ListUsers(List<User> users) {
        userList = users;
    }

    public void addUser() throws NullPointerException, NumberFormatException {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Select Information----");
        System.out.println("1: Already have an Account");
        System.out.println("2: Add New Account");
        int number = Integer.parseInt(sc.nextLine());
        User user = new User("admin", "ngoc", User.ADMIN_ROLE);
        User users = new User("user", "ngovanngoc", User.USER_ROLE);
        userList.add(user);
        userList.add(users);
        switch (number) {
            case 1:
                break;
            case 2:
                User users1 = new User();
                System.out.println("Mời Nhập Thông Tin ");
                users1.createAccount();
                if (users1.getYouName() != null && users1.getPassword() != null) {
                    int index = 0;
                    for (User value : userList) {
                        if (users1.getYouName().equals(value.getYouName())) {
                            index++;
                        }
                    }
                    if (index == 0) {
                        userList.add(users1);
                    } else {
                        System.out.println("Account already exists");
                    }
                } else {
                    System.out.println("No Account or Password Enter yet");
                }
                break;
        }
    }

    public User checkUser(String ad, String adMk) {
        if (ad != null && adMk != null) {
            User user = new User();
            int index = 0;
            for (User user5 : userList) {
                if (ad.equals(user5.getYouName()) && adMk.equals(user5.getPassword())) {
                    user = user5;
                    index++;
                }
            }
            if (index <= 0) {
                return null;
            }
            return user;
        } else {
            return null;
        }

    }

}
