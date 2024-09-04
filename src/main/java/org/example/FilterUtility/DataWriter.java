package org.example.FilterUtility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataWriter implements AutoCloseable {

    private final String outputPath;
    private final String prefix;
    private final boolean appendMode;
    private final Map<DataType, FileWriter> writers = new HashMap<>();

    public DataWriter(String outputPath, String prefix, boolean appendMode) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.appendMode = appendMode;
    }

    public void write(String line, DataType dataType) throws IOException {
        FileWriter writer = getWriter(dataType);
        writer.write(line + System.lineSeparator());
    }

    private FileWriter getWriter(DataType dataType) throws IOException {
        if (!writers.containsKey(dataType)) {
            String fileName = prefix + dataType.toString().toLowerCase() + "s.txt";
            writers.put(dataType, new FileWriter(outputPath + "/" + fileName, appendMode));
        }
        return writers.get(dataType);
    }

    @Override
    public void close() throws IOException {
        for (FileWriter writer : writers.values()) {
            writer.close();
        }
    }
}
