package pl.com.bottega.homework.fraction;

public class FractionTest {

    public static void main (String[] args){
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(1,4);
        Fraction sum = f1.add(f2);
        Fraction subs = f1.substract(f2);
        Fraction multi = f1.multiply(f2);
        Fraction inv = f1.inverse();
        Fraction div = f1.divide(f2);
        long getin = f1.getIntegerPart();

        System.out.println("Pierwszy ułamek to: " + f1.getNumerator() + "/" + f1.getDenominator());
        System.out.println("Drugi ułamek to: " + f2.getNumerator() + "/" + f2.getDenominator());
        System.out.println("Suma wynosi: " + sum.getNumerator() + "/" + sum.getDenominator());
        System.out.println("Różnica wynosi: " + subs.getNumerator() + "/" + subs.getDenominator());
        System.out.println("Iloczyn wynosi: " + multi.getNumerator() + "/" + multi.getDenominator());
        System.out.println("Odwrócony pierwszy ułamek wynosi: " + inv.getNumerator() + "/" + inv.getDenominator());
        System.out.println("Wynik dzielenia wynosi: " + div.getNumerator() + "/" + div.getDenominator());
        System.out.println("Część całkowita ułamka wynosi : " + getin);
    }
}