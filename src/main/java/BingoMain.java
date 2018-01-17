import org.jruby.util.log.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class BingoMain {
    private static org.jruby.util.log.Logger LOGGER = LoggerFactory.getLogger(BingoMain.class);

    public static void main(String [] args){
        File dir = createDirectory();
        createFileUnderDirectory(dir);
    }

    static File createFileUnderDirectory(File dir) {
        String fileName = "Bingo_counters.txt";
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOGGER.warn("Unable to create a file with name{}", fileName);
        }

        return file;
    }

    static File createDirectory() {
        File dir = new File("counters");
        dir.mkdirs();
        return dir;
    }
}
