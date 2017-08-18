package pl.com.bottega.cwiczeniowe.numbersystems;

public class StringToBinary {

    private String s;
    private int k, number;

    public static void main(String[] args) {

        System.out.println(convertToDecimal("40", 2));
    }

    public static int convertToDecimal(String digits, int k) {

        int result = 0;
        int power = 1;
        char[] charDigits = digits.toCharArray();
        for (int i = 0; i < charDigits.length; i++) {
            char digit = charDigits[charDigits.length - i - 1];

            int digitDecimal = toDecimal(digit, k);
            result += digitDecimal * power;
            power *= k;
        }
        return result;
    }

    private static int toDecimal(char digit, int k) {

        int decimalDigit;

        if (digit >= '0' && digit <= '9')
            decimalDigit = digit - '0';   //odejmuje wartość zera w tablicy ASCII (48)
        else if (digit >= 'A' && digit <= 'Z')
            decimalDigit = digit - 'A' + 10;
        else
            throw new IllegalArgumentException();
        if (decimalDigit >= k)
            throw new IllegalArgumentException();
        return decimalDigit;
    }
}


