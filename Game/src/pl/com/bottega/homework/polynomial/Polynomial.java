package pl.com.bottega.homework.polynomial;

import java.util.Scanner;

public class Polynomial {

    private double a;
    private double b;
    private double c;


    public void getValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj trzy parametry wielomianu ax2 + bx + c = 0: ");
        System.out.print("a: ");
        this.getA(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("b: ");
        this.getB(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("c: ");
        this.getC(scanner.nextDouble());
        scanner.nextLine();
    }

    private void getA(double value){
        this.a = value;
    }

    private void getB(double value){
        this.b = value;
    }

    private void getC(double value){
        this.c = value;
    }

    public String show(){
        String equation;
        String signb = "+";
        String signc = "+";

        if (b<0)
            signb = "";
        if (c<0)
            signc = "";

        equation = (a + "x^2" + signb + b + "x" + signc + c + " = 0");
        return equation;
    }

    public double delta(){
        double del = b*b - 4*a*c;
        return del;
    }

    public String zero(){

        if (a == 0) {
            System.out.println("Funkcja nie jest kwadratowa!");
            return null;
        }
        double delta = this.delta();
        double xz1 = (-b + (double) Math.sqrt(delta)) / (2 * a);
        double xz2 = (-b - (double) Math.sqrt(delta)) / (2 * a);
        double xz = -b / (2 * a);;
        String wynik;

        if (delta>0){
            wynik = ("Miejsca zerowe to: x1= " + xz1 + " | x2= " + xz2);;
        }
        else if (delta == 0) {
            wynik = ("x = " + xz);
        }
        else
            wynik = ("Delta mniejsza od zera!");
        return wynik;
    }

    public String extreme(){
        if (a == 0) {
            System.out.println("Funkcja nie ma ekstremum!");
            return null;
        }
        double delta = this.delta();
        String extreme;
        double xe = -b/(2*a);
        double ye = -delta/(4*a);

        extreme = ("Współrzędne punktu ekstremum: ( " + xe + ", " + ye + " )");
        return extreme;
    }
}