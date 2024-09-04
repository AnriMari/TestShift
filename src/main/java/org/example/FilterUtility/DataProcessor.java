package org.example.FilterUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private final List<String> inputFiles = new ArrayList<>();
    private final String outputPath;
    private final String prefix;
    private final boolean appendMode;
    private final boolean fullStats;

    private final StatisticsManager statsManager = new StatisticsManager();

    public DataProcessor(String[] args) {
        CommandLineArgs parsedArgs = CommandLineArgs.parse(args);
        this.outputPath = parsedArgs.getOutputPath();
        this.prefix = parsedArgs.getPrefix();
        this.appendMode = parsedArgs.isAppendMode();
        this.fullStats = parsedArgs.isFullStats();
        this.inputFiles.addAll(parsedArgs.getInputFiles());
    }

    public void processFiles() throws IOException {
        DataWriter writer = new DataWriter(outputPath, prefix, appendMode);
        for (String inputFile : inputFiles) {
            processFile(inputFile, writer);
        }
        writer.close();
    }

    private void processFile(String inputFile, DataWriter writer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, writer);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFile);
        }
    }

    private void processLine(String line, DataWriter writer) throws IOException {
        DataType dataType = Utils.identifyDataType(line);
        if (dataType != null) {
            writer.write(line, dataType);
            statsManager.updateStatistics(line, dataType);
        }
    }

    public void displayStatistics() {
        statsManager.printStatistics(fullStats);
    }
}


