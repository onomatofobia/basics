package pl.com.bottega.homework.algorythms;

public class Algorythm {

    public static void main(String[] args) {

        System.out.println(smallestDigit(-159343));

        String[] s = {"horse", "monkey", "distortion"};

        System.out.println(shortestStringInArray(s));

        System.out.println(checkIfItsPalindrom("abba"));

    }

    public static int smallestDigit(int number){
        number = Math.abs(number);
        int smallestDigit = 9;
        if (number == 0)
            smallestDigit = 0;

        while(number > 0){
            int modulo = number % 10;
            if (modulo < smallestDigit)
                smallestDigit = modulo;
            number /=10;
        }
        return smallestDigit;
    }

    public static int shortestStringInArray(String[] s){
        if (s.length == 0)
            return 0;
        String shortest = s[0];
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].length() > s[i + 1].length())
                shortest = s[i + 1];
        }
        int shortestLenght = shortest.length();
        return shortestLenght;
    }

    public static boolean checkIfItsPalindrom(String s) {
        if (s.length() == 0)
            return false;
        int lenght = s.length();
        for (int i = 0; i < lenght - 1; i++) {
            if (s.codePointAt(i) != s.codePointAt(lenght - 1 - i))
                return false;
        }
        return true;
    }
}
