package pl.com.bottega.game.application;


import pl.com.bottega.game.engine.*;

import java.util.Scanner;

public class GameAppOO {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) {

        try {
            short gamesCount = readGamesCount();
            initializePlayers();

            System.out.println("Dzisiaj gra " + player1 + " vs " + player2);

            //HumanPlayer human = new HumanPlayer("Andrzej");

            Arbiter arbiter = new Arbiter(gamesCount, player1, player2);
            SoundDevice soundDevice = chosenDevice();
            ScoreBoard primaryScoreBoard = new ScoreBoard(gamesCount, player1.getName(), player2.getName(), soundDevice);

            Arbiter.GameResult result = null;
            do {
                result = arbiter.playRound();
                primaryScoreBoard.refresh(result);
            } while (result != Arbiter.GameResult.GAME_OVER);

            System.out.println("Raport z gry.");
            System.out.println(arbiter.generateReport());
        }
        catch (Exception ex){
            System.out.println("Nieoczekiwany błąd: " + ex.getMessage());
            ex.printStackTrace();
    }

    }

    private static Player initializePlayers(){
        System.out.println("Wybierz rodzaj gry.");
        System.out.println("1. Komputer vs komputer");
        System.out.println("2. Gracz vs gracz");
        System.out.println("3. Gracz vs komputer");
        byte gameType = scanner.nextByte();    //TODO zrobić catch'a na wpisanie innego znaku niż byte
        scanner.nextLine();

        switch (gameType) {
            case 1:
                player1 = new ComputerPlayer("HAL");
                player2 = new SmartComputerPlayer("IBM");
                break;
            case 2:
                System.out.print("Imię pierwszego gracza: ");
                String name1 = scanner.nextLine();
                System.out.print("Imię drugiego gracza: ");
                String name2 = scanner.nextLine();
                player1 = new HumanPlayer(name1);
                player2 = new HumanPlayer(name2);
                break;
            case 3:
                System.out.print("Imię gracza:");
                String name = scanner.nextLine();
                player1 = new HumanPlayer(name);
                player2 = new ComputerPlayer("HAL");
                break;
        }
        return null;
    }

    private static SoundDevice chosenDevice() {
        System.out.println("Wybierz urządzenie: 1. Sony 2. Bosse 3. Manta");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1)
            return new SonyDevice();
        else if (choice == 2)
            return new BosseDevice();
        else if (choice == 3)
            return new MantaDevice();
        else
            return null; //
    }

    private static short readGamesCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ilosc gier: ");
        short count = scanner.nextShort();
        scanner.nextLine();
        return count;
    }
}