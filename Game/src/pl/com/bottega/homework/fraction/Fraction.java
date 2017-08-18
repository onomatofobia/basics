package pl.com.bottega.homework.fraction;

public class Fraction {

    private final long numerator;
    private final long denominator;

    public long getNumerator(){
        return numerator;
    }

    public long getDenominator(){
        return denominator;
    }

    public Fraction(long numerator, long denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator is zero.");
        }
        if (denominator < 0){
            numerator = -1 * numerator;
            denominator = -1 * denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long common(Fraction d1, Fraction d2){
        long a = d1.getDenominator();
        long b = d2.getDenominator();
        long c = a*b;
        long d;

        if (a%b == 0)
            d = a;
        else if (b%a == 0)
            d = b;
        else
            d = c;

        return d;
    }

    public Fraction add(Fraction fraction){
        long common = this.common(fraction, this);
        return new Fraction(
                (common/this.getDenominator()) * this.getNumerator() + (common/fraction.getDenominator()) * fraction.getNumerator(),
                common
        );
    }

    public Fraction substract(Fraction fraction){
        long common = this.common(fraction, this);
        return new Fraction(
                (common/this.getDenominator()) * this.getNumerator() - (common/fraction.getDenominator()) * fraction.getNumerator(),
                common
        );
    }

    public Fraction multiply(Fraction multiplicand){
        return new Fraction(
                this.getNumerator() * multiplicand.getNumerator(), this.getDenominator() * multiplicand.getDenominator()
        );
    }

    public Fraction inverse(){
        return new Fraction(denominator, numerator);
    }

    public Fraction divide(Fraction divisor){
        Fraction divider = divisor.inverse();
        return this.multiply(divider);
    }

    public long getIntegerPart(){
        long integ = this.getNumerator()/this.getDenominator();
        return integ;
    }
}