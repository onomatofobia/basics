package pl.com.bottega.cwiczeniowe.others;

import java.util.Scanner;

public class SumDigits {

    public static void main(String[] args) {

        System.out.print("Suma cyfr Twojej liczby to: " + sumDigits());
    }

    public static int sumDigits() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą: ");
        int digit = scanner.nextInt();
        int result = 0;
        digit = Math.abs(digit);

        while (digit>0) {
           result += digit % 10;
           digit = digit / 10;
        }
        return result;
    }
}
