import org.junit.Test;

import java.io.File;

public class BingoMainTest {

    @Test
    public void testCreateDirectory() {
        FileMaker fileMaker = new FileMaker("counter", "test.txt");
        File directory = fileMaker.createDirectory();
        assert directory.exists();
        assert directory.isDirectory();
        assertReadWriteAccess(directory);
    }

    @Test
    public void testCreateFile() {
        FileMaker fileMaker = new FileMaker("counters", "test2.txt");
        fileMaker.createDirectory();
        File file = fileMaker.createFileUnderDirectory();
        assert file.exists();
        assert file.isFile();
        assertReadWriteAccess(file);
    }

    private void assertReadWriteAccess(File directory) {
        assert directory.canWrite();
        assert directory.canRead();
    }
}