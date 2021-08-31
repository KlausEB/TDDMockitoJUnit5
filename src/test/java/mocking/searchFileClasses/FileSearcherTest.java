package mocking.searchFileClasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FileSearcherTest {

    @InjectMocks
    private FileSearcher fileSearcher;

    @Test
    void searchFile_True_CorrectFileWasFoundInSubDirectory() {
        //GIVEN
        File rootDirectory = new File("src/resources");
        String desiredFileName = "ThirdPoem.txt";
        File expectedFile = new File("src/resources/oneMoreDirectory/ThirdPoem.txt");
        ContentViewer contentViewerMock = mock(ContentViewer.class);
        when(contentViewerMock.takeDirectoryContent(rootDirectory)).thenReturn(Arrays.asList(rootDirectory.listFiles()));
        when(contentViewerMock.takeDirectoryContent(any(File.class))).thenReturn(Arrays.asList(expectedFile));

        //WHEN
        File actualFile = fileSearcher.searchFile(rootDirectory, desiredFileName);

        //THEN
        assertEquals(expectedFile, actualFile);
    }

    @Test
    void searchFile_Exception_FileNotFound() {
        //GIVEN
        File rootDirectory = new File("src/resources");
        String desiredFileName = "FourthPoem.txt";
        ContentViewer contentViewerMock = mock(ContentViewer.class);
        when(contentViewerMock.takeDirectoryContent(any(File.class))).thenReturn(null);

        //THEN
        assertThrows(FileNotFoundException.class, () -> fileSearcher.searchFile(rootDirectory, desiredFileName));
    }
}