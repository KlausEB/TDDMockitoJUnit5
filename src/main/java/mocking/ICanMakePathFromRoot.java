package mocking;

import java.io.File;

public interface ICanMakePathFromRoot{
    String takePathFromRoot(File rootDirectory, String fileName);
}
