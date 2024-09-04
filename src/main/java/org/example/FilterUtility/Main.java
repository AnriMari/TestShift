package org.example.FilterUtility;

public class Main {
    public static void main(String[] args) {
        try {
            DataProcessor processor = new DataProcessor(args);
            processor.processFiles();
            processor.displayStatistics();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
