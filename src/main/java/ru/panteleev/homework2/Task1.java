package ru.panteleev.homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static float inputFloat() {
        while (true){
            try{
                Scanner in = new Scanner(System.in);
                System.out.print("Введите дробное число: ");
                float result = in.nextFloat();
                in.close();
                return result;
            }catch (InputMismatchException e){
                System.out.println("Введено число которое не сожет быть преобразовано в тип float!!!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(inputFloat());
    }
}