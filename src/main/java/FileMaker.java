import org.jruby.util.log.LoggerFactory;

import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileMaker {

    static File createFileUnderDirectory(File dir) {
        String fileName = "Bingo_counters.txt";
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.warn("Unable to create a file with name{}", fileName);
        }

        return file;
    }

    static File createDirectory() {
        File dir = new File("counters");
        dir.mkdirs();
        return dir;
    }
}
