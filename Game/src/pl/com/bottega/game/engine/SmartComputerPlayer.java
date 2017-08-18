package pl.com.bottega.game.engine;

public class SmartComputerPlayer extends ComputerPlayer {

    private static final int CONSCIENCE_RATIO = 3;
    private Hand opponentHand;
    private int counter;

    public SmartComputerPlayer(String name) {
        super(name);
    }

    public void cheat(Hand opponentHand){

        this.opponentHand = opponentHand;
    }

    @Override
    public Hand giveHand(){
        counter++;
        if (counter % CONSCIENCE_RATIO == 0){
            return strongerHand();
        }
        return super.giveHand();
    }

    private Hand strongerHand() {
        for(Hand hand : Hand.values()){
            if (hand.betterThan(opponentHand))
                return hand;
        }
        return null;
    }
}
