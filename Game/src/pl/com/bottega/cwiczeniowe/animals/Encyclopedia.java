package pl.com.bottega.cwiczeniowe.animals;

import pl.com.bottega.cwiczeniowe.animals.*;

import java.util.Scanner;

public class Encyclopedia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animals = new  Animal[6];
        animals[0] = new Animal("Lew", new Land(), new Meat());
        animals[1] = new Animal("Koń", new Land(), new Veggie());
        animals[2] = new Animal("Mewa", new Air(), new Meat());
        animals[3] = new Animal("Sokół", new Air(), new Meat());
        animals[4] = new Animal("Wieloryb", new Water(), new Veggie());
        animals[5] = new Animal("Rekin", new Water(), new Meat());


        while(true){
            System.out.print("Zwierzęta: 1: Lew 2: Koń 3: Mewa 4: Sokół 5: Wieloryb 6: Rekin \n" +
                    "Wybierz zwierzę: ");
            int number = scanner.nextInt();
            if (number < 1 || number > animals.length)
                System.out.println("Nieprawidłowy numer");
            else
                animals[number - 1].presentYourself();
        }
    }
}
