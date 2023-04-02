package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextFileToDictionaryReader implements ToDictionaryReader {
    private final String delimiter;

    public TextFileToDictionaryReader(String delimiter) {
        this.delimiter = delimiter;
    }

    public TextFileToDictionaryReader() {
        this("=");
    }

    @Override
    public Map<String, String> read(Path from) {
        try (BufferedReader reader = new BufferedReader(new FileReader(from.toFile()))) {
            return readToDictionary(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Map<String, String> readToDictionary(BufferedReader reader) {
        Map<String, String> dictionary = new HashMap<>();
        reader.lines().forEach(line -> putLineToDict(line, dictionary));
        return dictionary;
    }

    private void putLineToDict(String line, Map<String, String> dict) {
        String[] tokens = line.split(delimiter);
        dict.put(tokens[0], tokens[1]);
    }
}
