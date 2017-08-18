package pl.com.bottega.cwiczeniowe.numbersystems;

public class NumberSystems {

    private static int n, k;

    public static void main(String[] args) {

        System.out.println(systemConversion(40, 2));
        System.out.println(systemConversion(40, 10));
        System.out.println(systemConversion(40, 16));
        System.out.println(systemConversion(4000, 16));
    }

    public static String systemConversion(int n, int k) {

        int modulo;
        StringBuilder sb = new StringBuilder();

        if (n == 0 || k == 0)
            return "0";
        if (k > 36 || n < 0 || k < 0)
            throw new IllegalArgumentException();

        if (k == 1)
            for (int i = 0; i < n; i++)
                sb.append(1);

        while (n != 0) {
            // char x = 'A' + 1;   wynik będzie 'B'
            modulo = n % k;
            String tempReversed;
            if (modulo < 10)
                tempReversed = String.valueOf(modulo);
            else
                tempReversed = String.valueOf((char)('A' + modulo - 10));
                // lub: tempReversed = Integer.toString(modulo);
            sb.insert(0, tempReversed);
            n /= k;
        }
        return sb.toString();
    }
}

