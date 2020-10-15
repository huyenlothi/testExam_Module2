package manager;

import com.company.Main;
import model.PhoneBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookManager implements Serializable {
    public static List<PhoneBook> phoneBookList = new ArrayList<>();
    public static void display(){
        for (PhoneBook phoneBook:phoneBookList
             ) {
            System.out.println(phoneBook.toString());
        }
    }
    private static boolean checkValidate(String regex) {
        Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    private static boolean checkValidateEmail(String regex) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean checkValidatePhone(String regex) {
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static void add(){
        Scanner scanner = new Scanner(System.in);
        String phone;
        boolean checkPhone= false;
        do {
            System.out.println("Enter phone:");
            phone = scanner.nextLine();
            checkPhone = checkValidatePhone(phone);
        }while (!checkPhone);
        System.out.println("Enter  group:");
        String group = scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter sex:");
        String sex = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        String birthday;
        boolean checkDate= false;
        do {
            System.out.println("Enter birthday (dd/mm/yyyy):");
            birthday = scanner.nextLine();
            checkDate = checkValidate(birthday);
        }while (!checkDate);

        String email;
        boolean checkEmail= false;
        do {
            System.out.println("Enter email:");
            email = scanner.nextLine();
            checkEmail = checkValidateEmail(email);
        }while (!checkEmail);
        PhoneBook phoneBook = new PhoneBook(phone,group,name,sex,address,birthday,email);
        phoneBookList.add(phoneBook);
        System.out.println("Add successfully !");
    }
    public static void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a phone you want edit:");
        String phone = scanner.nextLine();
        PhoneBook phoneBookEdit=null;
        for (PhoneBook phoneBook:phoneBookList
             ) {
            if(phoneBook.getPhone().equals(phone)){
                phoneBookEdit= phoneBook;
            }
        }
        if(phoneBookEdit==null){
            System.out.println("re enter");
            update();
        }
        int i=1;
        while (i<6) {
            System.out.println("1. edit group");
            System.out.println("2. edit name");
            System.out.println("3. edit sex");
            System.out.println("4. edit address");
            System.out.println("5. edit birth Day");
            System.out.println("6. edit email");
            System.out.println("7. exit");
            System.out.println("enter your choose:");
            int choose = 0;
            try {
                choose = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("re enter your choose:");
            }
            switch (choose) {
                case 1:
                    System.out.println("enter new group:");
                    String newGroup = scanner.nextLine();
                    phoneBookEdit.setGroup(newGroup);
                    i = 1;
                    break;
                case 2:
                    System.out.println("enter new name:");
                    String newName = scanner.nextLine();
                    phoneBookEdit.setName(newName);
                    i = 2;
                    break;
                case 3:
                    System.out.println("enter new sex:");
                    String newSex = scanner.nextLine();
                    phoneBookEdit.setSex(newSex);
                    i = 3;
                    break;
                case 4:
                    System.out.println("enter new address:");
                    String newAddress = scanner.nextLine();
                    phoneBookEdit.setAddress(newAddress);
                    i = 4;
                    break;
                case 5:
                    String newBirthDay;
                    boolean checkbd=false;
                    do{
                        System.out.println("enter new birthday:");
                     newBirthDay = scanner.nextLine();
                     checkbd = checkValidate(newBirthDay);
                    }while (!checkbd);

                    phoneBookEdit.setBirthday(newBirthDay);
                    i = 5;
                    break;
                case 6:
                    String newEmail;
                    boolean checkemail= false;
                     do {
                         System.out.println("enter new email:");
                          newEmail = scanner.nextLine();
                          checkemail = checkValidateEmail(newEmail);
                     }while (!checkemail);
                    phoneBookEdit.setEmail(newEmail);
                    i = 5;
                    break;
                case 7:
                    Main.menu();
                default:
                    System.out.println("re enter your choose:");
                    i = 5;
            }
        }
    }
    public static  void  search(){
        System.out.println("enter your phone you want search:");
        String phone = new Scanner(System.in).nextLine();
        for (PhoneBook phoneBook:phoneBookList
             ) {
            if(phoneBook.getPhone().contains(phone)){
                System.out.println(phoneBook.toString());
            }
        }
    }
    public static void delete(){
        PhoneBook phoneBookDelete=null;
        System.out.println("nhập số điện thoại muốn xóa:");
        String phone = new Scanner(System.in).nextLine();
        for (PhoneBook phoneBook: phoneBookList){

            if(phoneBook.getPhone().equals(phone)){
                phoneBookDelete= phoneBook;
            }
        }
        phoneBookList.remove(phoneBookDelete);
    }
}
