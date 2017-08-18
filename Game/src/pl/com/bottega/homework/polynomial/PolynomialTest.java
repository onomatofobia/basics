package pl.com.bottega.homework.polynomial;

public class PolynomialTest {

    public static void main (String[] args){
        Polynomial p1 = new Polynomial();
        p1.getValue();
        String p = p1.show();
        String z = p1.zero();
        String e = p1.extreme();

        System.out.println("Wielomian to: " + p);
        System.out.println(z);
        System.out.println(e);
    }
}
