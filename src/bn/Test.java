package bn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fullName = {"ngo van ngoc","nguyen kim bao","nguyen gia bao","ngo van thuan"};
        boolean check = false;
        do {
            System.out.println("Nhập tên");
            String input = sc.nextLine();
            String regex1 = "^[a-zA-Z]+[\\s]+[a-zA-Z]";
            Pattern  pattern = Pattern.compile(regex1);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                check = true;
                System.out.println("ok");
            } else {
                System.out.println("nhập lại");
            }
        } while (!check);
        boolean check1 = false;
        do {
            System.out.println("Nhập Ngáy Tháng" + "\n" + " dd/mm/yyyy");
            String inputs = sc.nextLine();
            String regex = "^[0-9][0-9]+[/]+[0-9]+[/]+[0-9][0-9][0-9][0-9]$";
            Pattern  pattern1 = Pattern.compile(regex);
            Matcher matcher1 = pattern1.matcher(inputs);
            if (matcher1.find()) {
                check1 = true;
                System.out.println("ok");
            } else {
                System.out.println("nhập lại");
            }
        }while (!check1);


    }
}
