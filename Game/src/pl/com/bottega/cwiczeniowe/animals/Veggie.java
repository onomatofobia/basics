package pl.com.bottega.cwiczeniowe.animals;

public class Veggie implements EatStrategy {
    @Override
    public void eat() {
        System.out.println("Jestem roślinożerny.");
    }
}
