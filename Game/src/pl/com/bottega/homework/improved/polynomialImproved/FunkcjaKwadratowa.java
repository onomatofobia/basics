package pl.com.bottega.homework.improved.polynomialImproved;

import java.math.BigDecimal;

public class FunkcjaKwadratowa {

    private BigDecimal a,b,c;
    private int iloscMiejscZerowych;
    private BigDecimal x0;
    private BigDecimal x1;
    private BigDecimal x2;
    private BigDecimal ekstremum;


    public FunkcjaKwadratowa(BigDecimal a,BigDecimal b,BigDecimal c){
        this.a = a;
        this.b = b;
        this.c = c;
        rozwiazRownanie();
        obliczEkstremum();
    }

    private void obliczEkstremum() {
        ekstremum = BigDecimal.ZERO;  // TODO
    }

    private void rozwiazRownanie() {

        BigDecimal delta = b.pow(2).subtract(a.multiply(c).multiply(new BigDecimal(4)));
        int porownanie = delta.compareTo(BigDecimal.ZERO);
        if (porownanie == 0) {
            iloscMiejscZerowych = 1;
            x0 = b.negate().divide(a.multiply(new BigDecimal(2)));
        }
        else if (porownanie < 0)
                iloscMiejscZerowych = 0;
        else {
                BigDecimal sqrt = new BigDecimal(Math.sqrt(delta.doubleValue()));
                BigDecimal a2 = a.multiply(new BigDecimal(2));
                x1 = b.negate().subtract(sqrt).divide(a2);
                x2 = b.negate().add(sqrt).divide(a2);
                iloscMiejscZerowych = 2;
            }
    }


    public int iloscMiejscZerowych() {
        return iloscMiejscZerowych();
    }

    public BigDecimal x0() {
        return x0;
    }

    public BigDecimal x1() {
        return x1;
    }

    public BigDecimal x2() {
        return x2;
    }

    public BigDecimal esktremum() {
        return ekstremum;
    }


}
