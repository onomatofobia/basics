package pl.com.bottega.game.engine;

public interface Player {
    public Hand giveHand()throws IllegalInputException;
    public String getName();
}