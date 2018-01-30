import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class FileMaker {
    private final String dirName;
    private final String fileName;

    File createFileUnderDirectory() {
        File file = new File(dirName, fileName);
        try {
            file.createNewFile();
            log.debug("Created a new file {} under directory {}.", fileName, dirName);
        } catch (IOException e) {
            log.warn("Unable to create a file with name{}", fileName);
        }

        return file;
    }

    File createDirectory() {
        File dir = new File(String.valueOf(dirName));
        dir.mkdirs();
        log.debug("Created a new directory {} under file system", dir.getName());
        return dir;
    }
}
