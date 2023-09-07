package ru.panteleev.homework2;

import java.util.Objects;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Введите : ");
            String result = in.nextLine();
            if(Objects.equals(result, "")){
                throw new EmptyLineException("Вводить пустые строки нельзя!!!");
            }
            System.out.println("Введена не пустая строка");
        } catch (EmptyLineException e) {
            System.out.println("Перехваченное исключение." + e);
        }
    }
}
