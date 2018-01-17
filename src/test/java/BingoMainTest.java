import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class BingoMainTest {

    @Test
    public void testCreateDirectory() {
        File directory = FileMaker.createDirectory();
        assert directory.exists();
        assert directory.isDirectory();
        assertReadWriteAccess(directory);
    }

    @Test
    public void testCreateFile() {
        File file = FileMaker.createFileUnderDirectory(FileMaker.createDirectory());
        assert file.exists();
        assert file.isFile();
        assertReadWriteAccess(file);
    }

    private void assertReadWriteAccess(File directory) {
        assert directory.canWrite();
        assert directory.canRead();
    }
}