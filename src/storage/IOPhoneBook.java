package storage;

import model.PhoneBook;

import java.io.*;
import java.util.List;

public class IOPhoneBook  implements Serializable{
    public static void save(List<PhoneBook> phoneBookList) {
        try {
            File file = new File("data.csv");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(phoneBookList);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Saved successfully! ");
        } catch (Exception e) {
            System.out.println("-----");
        }
    }

    public static List<PhoneBook> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("data.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<PhoneBook> phoneBookList = (List<PhoneBook>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return phoneBookList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
