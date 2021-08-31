package mocking.searchFileClasses;

import mocking.ICanMakePathFromRoot;

import java.io.File;

public class MakerPathFromRoot implements ICanMakePathFromRoot {
    @Override
    public String takePathFromRoot(File rootDirectory, String fileName) {
        return null;
    }
}
