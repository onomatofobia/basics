package pl.com.bottega.cwiczeniowe.animals;

public class Animal {

    String name;
    EatStrategy eatStrategy;
    MoveStrategy moveStrategy;

    public Animal(String name, MoveStrategy moveStrategy, EatStrategy eatStrategy){
        this.name = name;
        this.eatStrategy = eatStrategy;
        this.moveStrategy = moveStrategy;
    }

    public void presentYourself(){
        System.out.println("Cześć, to ja " + name);
        eatStrategy.eat();
        moveStrategy.move();
    }
}
