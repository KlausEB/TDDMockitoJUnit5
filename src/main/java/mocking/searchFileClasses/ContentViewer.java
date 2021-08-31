package mocking.searchFileClasses;

import mocking.ICanViewContent;

import java.io.File;
import java.util.List;

public class ContentViewer implements ICanViewContent {
    @Override
    public List<File> takeDirectoryContent(File directory) {
        return null;
    }

    @Override
    public boolean thisIsDirectory(File directory) {
        return false;
    }
}
