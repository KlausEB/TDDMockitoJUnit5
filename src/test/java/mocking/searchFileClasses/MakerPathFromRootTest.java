package mocking.searchFileClasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MakerPathFromRootTest {

    @InjectMocks
    private MakerPathFromRoot makerPathFromRoot;

    @Test
    void takePathFromRoot_True_CorrectPathWillReturn() {
        //GIVEN
        String fileName = "ThirdPoem.txt";
        String correctPathFromRoot = "resources/oneMoreDirectory/ThirdPoem.txt";
        File rootDirectory = new File("src/resources");
        File correctFile = new File("src/" + correctPathFromRoot);
        FileSearcher fileSearcher = mock(FileSearcher.class);
        when(fileSearcher.searchFile(rootDirectory, fileName)).thenReturn(correctFile);

        //WHEN
        String actualPath = makerPathFromRoot.takePathFromRoot(rootDirectory, fileName);

        //THEN
        assertEquals(correctPathFromRoot, actualPath);
    }
}