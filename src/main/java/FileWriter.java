import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class FileWriter {
    private static final String TABB = "    ";
    private static final String EXTRA_TABB = "     ";
    private final File file;

    void generateCounters() {
        if (file.isFile() && file.exists()) {
            file.setWritable(true);
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file.getName()));
                for (int i = 1; i <= 100; i++) {
                    writer.write(i <= 10 ? i + EXTRA_TABB : i + TABB);
                    if (i % 10 == 0) {
                        writer.newLine();
                    }
                }
                log.debug("Added counters to file {}.", file.getName());
                writer.close();
            } catch (IOException e) {
                log.warn("Unable to access file {}", file.getName());
            }

        }
    }
}