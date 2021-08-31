package mocking.searchFileClasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContentViewerTest {

    @InjectMocks
    private ContentViewer contentViewer;

    @Test
    void thisIsDirectory_True_IsResourcesDirectory() {
        //GIVEN
        File directory = new File("src/resources");

        //WHEN
        boolean thisIsDirectory = contentViewer.thisIsDirectory(directory);

        //THEN
        assertTrue(thisIsDirectory);
    }

    @Test
    void takeDirectoryContent_Exception_InputFileIsNotDirectory(){
        //GIVEN
        File directory = new File("src/resources");

        //THEN
        assertThrows(IllegalArgumentException.class, () -> contentViewer.takeDirectoryContent(directory));
    }

    @Test
    void takeDirectoryContent_True_InputCorrectDirectory(){
        //GIVEN
        File directory = new File("src/resources");
        List<File> expectedFileList = Arrays.asList(directory.listFiles());

        //WHEN
        List<File> actualFileList =contentViewer.takeDirectoryContent(directory);
        //THEN
        assertEquals(expectedFileList, actualFileList);
    }
}