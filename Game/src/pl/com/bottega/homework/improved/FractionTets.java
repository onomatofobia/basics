package pl.com.bottega.homework.improved;

public class FractionTets {

    public static void main(String[] args) {

        Fraction f1 = Fraction.create(1, 2);
        Fraction f2 = Fraction.create(1, 4);

        Fraction sum = f1.add(f2);      //obiekty niemodyfikowalne
        Fraction inversed = f1.inverse();
        Fraction result = f1.divide(f2);

        // Probability p1 = Probability.fromPercentage(80)
        // Probability p1 = Probability.fromFraction(80)  - przekazanie do konstrukatora, wewnątrz metody działania
        // Probability pr = p1.and(p2)

    }
}
