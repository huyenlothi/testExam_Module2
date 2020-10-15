package com.company;

import manager.PhoneBookManager;
import model.PhoneBook;
import storage.IOPhoneBook;

import java.util.Scanner;

public class Main {
public static void menu(){
    System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----");
    System.out.println("Chọn chức năng theo số (để tiếp tục");
    System.out.println("1. Xem danh sách");
    System.out.println("2. Thêm mới");
    System.out.println("3. Cập nhật");
    System.out.println("4. Xóa");
    System.out.println("5. Tìm kiếm");
    System.out.println("6. Đọc từ file");
    System.out.println("7. Ghi vào file");
    System.out.println("8. Thoat");

    int choose=0;
    boolean checkChoose= false;
    do{
        System.out.println("Chọn chức năng: ");
        try{
            choose = new Scanner(System.in).nextInt();
            if(choose==1 || choose==2|| choose==3 || choose==4|| choose ==5|| choose==6 ||choose==7 ||choose==8){
                checkChoose=true;
            }
        }catch (Exception e){
            System.out.println("mời nhập lại:");
        }
    }while (!checkChoose);
    switch (choose){
        case 1:
            PhoneBookManager.display();
            menu();
            break;
        case 2:
            PhoneBookManager.add();
            menu();
            break;
        case 3:
            PhoneBookManager.update();
            menu();
        case 4:
            PhoneBookManager.delete();
            menu();
            break;
        case 5:
            PhoneBookManager.search();
            menu();
            break;
        case 6:
            PhoneBookManager.phoneBookList = IOPhoneBook.read();
            menu();
            break;
        case 7:
            IOPhoneBook.save(PhoneBookManager.phoneBookList);
            menu();
            break;
        case 8:
            System.exit(-1);
        default:
            menu();
    }
}
    public static void main(String[] args) {
menu();
    }
}
