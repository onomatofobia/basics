package pl.com.bottega.game.engine;

import java.util.Random;
import java.util.jar.Attributes;

public class ComputerPlayer extends NamedPlayer {

    private Random random = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    public Hand giveHand() {
        int r = random.nextInt(Hand.values().length);
        return Hand.values()[r];
    }

}