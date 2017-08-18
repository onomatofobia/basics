package pl.com.bottega.cwiczeniowe.animals;

public class Meat implements EatStrategy {

    @Override
    public void eat() {
        System.out.println("Jestem mięsożerny.");

    }
}
