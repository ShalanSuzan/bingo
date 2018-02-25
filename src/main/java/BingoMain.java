import com.beust.jcommander.internal.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class BingoMain implements Runnable {

    public static void main(String[] args) {
        new BingoMain().run();
    }

    @Override
    public void run() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        log.debug("Welcome to Bingo game!");
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println(String.format("Hi %s, welcome to Bingo game!", name));
        final int numberOfPlayers = howManyWillPlay(scanner);
        final List <String> players = whoWillPlay(scanner, numberOfPlayers);

        try {
            generatePullingNumbers();
            generatePlayersNumbers(players);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("We are done. Bye bye!");
        }

    private void generatePlayersNumbers(List<String> players) throws IOException {
        int NumberOfContersPerPlayer = 100 / players.size();
        FileMaker fileMaker = new FileMaker("counters", "Bingo_players_counters.txt");
        fileMaker.createDirectory();
        FileWriter fileWriter = new FileWriter(fileMaker.createFileUnderDirectory());
        List<Integer> allocatedNumbers= Lists.newArrayList();
        fileWriter.generateCounters(players, NumberOfContersPerPlayer, allocatedNumbers);
    }

    private void generatePullingNumbers() {
        FileMaker fileMaker = new FileMaker("counters", "Bingo_counters.txt");
        fileMaker.createDirectory();
        FileWriter fileWriter = new FileWriter(fileMaker.createFileUnderDirectory());
        fileWriter.generateCounters();
    }

    private int howManyWillPlay(Scanner scanner) {
        System.out.println("Give the number of the players. " +
                "Please separate your answer with a single space");
        return Integer.valueOf(scanner.next());
    }

    private List<String> whoWillPlay(Scanner scanner, int numberOfPlayers) {
        System.out.println("Give the name of the players. " +
                "Please separate your answer with a single space");
        List <String> players = Lists.newArrayList();
        for(int i = 0; i<numberOfPlayers; i++){
            players.add(scanner.next());
        }
        return players;
    }
}
