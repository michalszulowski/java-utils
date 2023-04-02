package io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextFileToDictionaryReaderTest {
    private static TextFileToDictionaryReader dictionaryReader;
    private static Path file;
    private final static String TEST_RESOURCES_DIR = "src/test/resources";
    private static Map<String, String> resultDict;

    @BeforeAll
    public static void initReader() {
        dictionaryReader = new TextFileToDictionaryReader();
    }

    @Test
    public void testReadingDictFromFile() {
        givenFile(Path.of(TEST_RESOURCES_DIR, "values-dict.txt"));
        whenReading();
        Map<String, String> expectedDict = new HashMap<>();
        expectedDict.put("a", "b");
        expectedDict.put("c", "d");
        expectedDict.put("10", "12");
        thenDictionaryShouldBe(expectedDict);
    }

    private void givenFile(Path ofPath) {
        file = ofPath;
    }

    private void whenReading() {
        resultDict = dictionaryReader.read(file);
    }

    private void thenDictionaryShouldBe(Map<String, String> expected) {
        assertEquals(expected, resultDict);
    }
}