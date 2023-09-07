package ru.panteleev.homework3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void start() {
        String[] str;

        System.out.println("Введите \"фамилию\", \"имя\", \"отчество\", \"дату рождения\", \"номер телефона\", \"пол\" в одну строку разделенные пробелами.");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine().split(" ");
        scanner.close();

        if (str.length != 6) {
            throw new RuntimeException("Введено не верное количество данных");
        }

        checkData(str);
        writeInFile(str);
    }

    public static void checkData(String[] str) {
        try {

            for (int i = 0; i < str[0].length(); i++) {
                char c = str[0].charAt(i);
                if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c >= 'А' && c <= 'Я') && !(c >= 'а' && c <= 'я')) {
                    throw new RuntimeException("Введена неверная \"фамилия\"");
                }
            }

            for (int i = 0; i < str[1].length(); i++) {
                char c = str[1].charAt(i);
                if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c >= 'А' && c <= 'Я') && !(c >= 'а' && c <= 'я')) {
                    throw new RuntimeException("Введено неверное \"имя\"");
                }
            }

            for (int i = 0; i < str[2].length(); i++) {
                char c = str[2].charAt(i);
                if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c >= 'А' && c <= 'Я') && !(c >= 'а' && c <= 'я')) {
                    throw new RuntimeException("Введено неверное \"отчество\"");
                }
            }

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            format.parse(str[3]);

            Integer.parseInt(str[4]);

            if (str[5].length() > 1 || (str[5].toCharArray()[0] != 'f' && str[5].toCharArray()[0] != 'm')) {
                throw new RuntimeException("Введен неверный \"пол\"");
            }
        } catch (NumberFormatException e) {
            System.err.println("Введен неверный \"номер телефона\"");
        } catch (ParseException e) {
            System.err.println("Введена неверная \"дата рождения\"");
        }
    }

    public static void writeInFile(String[] str) {
        File file = new File(str[0]);
        try (FileWriter fileWriter = new FileWriter(file, true)) {

            fileWriter.write("<");
            fileWriter.write(String.join("><", str));
            fileWriter.write(">\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
    }
}
