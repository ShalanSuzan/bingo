import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BingoMain implements Runnable{

    public static void main(String [] args){
       new BingoMain().run();
    }

    @Override
    public void run() {
        log.debug("Welcome to Bingo game!");
        FileMaker fileMaker = new FileMaker("counters","Bingo_counters.txt");
        fileMaker.createDirectory();
        FileWriter fileWriter = new FileWriter(fileMaker.createFileUnderDirectory());
        fileWriter.generateCounters();
        log.debug("We are done. Bye bye!");
    }
}
