package mocking;

import java.io.File;
import java.util.List;

public interface ICanViewContent {
    List<File> takeDirectoryContent(File directory);

    boolean thisIsDirectory(File directory);
}
