package pl.com.bottega.cwiczeniowe.others;

import java.util.Scanner;

public class CapitalCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj napis: ");
            String text = scanner.nextLine();
            CharsCount charsCount = countChars(text);
            System.out.println("Lower case: " + charsCount.lowerCaseCount());
            System.out.println("Upper case: " + charsCount.upperCaseCount());
        }
    }

    public static CharsCount countChars(String text){
        int lowerCaseCounter = 0;
        int upperCaseCounter = 0;

        for (int i = 0; i < text.length() ; i++){
            char c = text.charAt(i);
            if (Character.isLetter(c))
                if (Character.isUpperCase(c))
                    upperCaseCounter++;
                else
                    lowerCaseCounter++;

    }
    return new CharsCount(lowerCaseCounter,upperCaseCounter);

    }
}


