package pl.com.bottega.homework.improved;

public class PolynomialFunction {

    private boolean solved;
    private double a;
    private double b;
    private double c;

    private double extremum;
    private double delta;

    public PolynomialFunction(double a, double b, double c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve(){
        delta = Math.pow(b, 2) - 4*a*c;
        extremum = -delta/(4*a);

        solved = true;
    }

    public double getExtremum() {
        if (!solved)
            solve();
        return extremum;
    }
}
