package io;

import java.nio.file.Path;
import java.util.Map;

public interface ToDictionaryReader {
    Map<String, String> read(Path from);
}
