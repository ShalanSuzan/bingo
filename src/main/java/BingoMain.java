import org.jruby.util.log.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class BingoMain {

    public static void main(String [] args){
        File dir = FileMaker.createDirectory();
        FileMaker.createFileUnderDirectory(dir);
    }


}
