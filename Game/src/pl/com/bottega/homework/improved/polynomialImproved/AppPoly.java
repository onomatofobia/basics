package pl.com.bottega.homework.improved.polynomialImproved;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppPoly {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Wprowadź współczynniki równania");
            System.out.print("A= ");
            BigDecimal a = scanner.nextBigDecimal();
            if (a.equals(BigDecimal.ZERO))
                System.out.println("To nie jest równanie kwadratowe");
            else {
                System.out.print("B= ");
                BigDecimal b = scanner.nextBigDecimal();
                System.out.print("C= ");
                BigDecimal c = scanner.nextBigDecimal();

                FunkcjaKwadratowa f = new FunkcjaKwadratowa(a,b,c);

                System.out.println("Ilość rozwiązań równania: " + f.iloscMiejscZerowych());
                if (f.iloscMiejscZerowych() == 0)
                    System.out.println("Nie ma rozwiązań");
                else if (f.iloscMiejscZerowych() == 1)
                    System.out.println("Jest jedno rozwiązanie: " + f.x0());
                else {
                    System.out.println("Są dwa rozwiązania: ");
                    System.out.println("x1= " + f.x1());
                    System.out.println("x2= " + f.x2());
                }

                System.out.println("Ekstremum= " + f.esktremum());

            }
        }
    }
}
