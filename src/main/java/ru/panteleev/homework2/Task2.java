package ru.panteleev.homework2;

public class Task2 {
    public static void main(String[] args) {
        try {
            int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
