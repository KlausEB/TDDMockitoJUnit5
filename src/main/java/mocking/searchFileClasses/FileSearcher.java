package mocking.searchFileClasses;

import mocking.ICanSearchFile;

import java.io.File;

public class FileSearcher implements ICanSearchFile {
    @Override
    public File searchFile(File rootDirectory, String fileName) {
        return null;
    }
}
