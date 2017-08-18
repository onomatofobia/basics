package pl.com.bottega.game.engine;

import java.util.Scanner;

public class HumanPlayer extends NamedPlayer{

    private static final byte MAX_ERRORS_COUNT = 3;
    private Scanner scanner = new Scanner(System.in);
    private int globalFailsCounter = 0;

    public HumanPlayer(String name) {
        super(name);                  // super constructor (dziedziczy po nadklasie (NamedPlayer))
    }

    public Hand giveHand() throws IllegalInputException {
        System.out.println("Wybierz: kamien, papier, nozyce");
        Hand hand = null;
        byte counter = 0;

        do {
            System.out.println("Zła wartość, wpisz ponownie.");
            String handStr = scanner.nextLine();
            hand = Hand.fromPolishWords(handStr);
            counter += 1;
        } while(wrongInput(hand) && doesNotExceedTries(counter));

        if (hand == null)
            throw new IllegalInputException("user exceeded " + MAX_ERRORS_COUNT + " attempts");

        return hand;
    }

    private boolean doesNotExceedTries(byte counter) {
        return counter < MAX_ERRORS_COUNT;
    }

    private boolean wrongInput(Hand hand) {
        return hand == null;
    }



    private void globalFailsCounter(int fails){
        globalFailsCounter = globalFailsCounter + fails;
    }
}

