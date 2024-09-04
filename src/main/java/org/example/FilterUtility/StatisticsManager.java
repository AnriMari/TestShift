package org.example.FilterUtility;

import java.util.EnumMap;
import java.util.Map;

public class StatisticsManager {

    private final Map<DataType, Statistics> statisticsMap = new EnumMap<>(DataType.class);

    public StatisticsManager() {
        for (DataType dataType : DataType.values()) {
            statisticsMap.put(dataType, new Statistics());
        }
    }

    public void updateStatistics(String line, DataType dataType) {
        Statistics stats = statisticsMap.get(dataType);
        switch (dataType) {
            case INTEGER:
                stats.update(Integer.parseInt(line));
                break;
            case FLOAT:
                stats.update(Double.parseDouble(line));
                break;
            case STRING:
                stats.update(line);
                break;
        }
    }

    public void printStatistics(boolean fullStats) {
        for (DataType dataType : DataType.values()) {
            String summary = statisticsMap.get(dataType).getSummary(fullStats);
            System.out.println(dataType.toString() + ": " + summary);
        }
    }
}
