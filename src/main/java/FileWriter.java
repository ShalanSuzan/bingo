import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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

    public List<Integer> generateCounters(List <String> players, int numberOfContersPerPlayer, List<Integer> allocatedCounters) throws IOException {
        if (file.isFile() && file.exists()) {
            file.setWritable(true);
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file.getName()));
                for(String player : players) {
                    writer.write(player);
                    writer.newLine();
                    for (int i = 1; i <= numberOfContersPerPlayer; i++) {
                        Random random = new Random();
                        addARandomNumber(random, allocatedCounters, writer, i);

                    }
                    writer.newLine();
                    writer.newLine();
                }
                log.debug("Added counters to file {}.", file.getName());
                writer.close();
            }catch (IOException e) {
                log.warn("Unable to access file {}", file.getName());
            }

        }
        return allocatedCounters;
    }

    private void addARandomNumber(Random random, List<Integer> allocatedCounters, BufferedWriter writer, int iterator) throws IOException {
        int randomNumber = random.nextInt(100) + 1;
        if (!allocatedCounters.contains(randomNumber)) {
            allocatedCounters.add(randomNumber);
            writer.write(randomNumber <= 10 ? randomNumber + EXTRA_TABB : randomNumber + TABB);
            if (iterator % 10 == 0) {
                writer.newLine();
            }
        } else {
            addARandomNumber(random, allocatedCounters, writer, iterator);
        }
    }
}