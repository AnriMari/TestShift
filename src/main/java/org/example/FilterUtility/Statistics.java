package org.example.FilterUtility;

public class Statistics {

    private int count = 0;
    private double sum = 0;
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private int shortestStringLength = Integer.MAX_VALUE;
    private int longestStringLength = Integer.MIN_VALUE;

    public void update(int value) {
        count++;
        sum += value;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public void update(double value) {
        count++;
        sum += value;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public void update(String value) {
        count++;
        int length = value.length();
        shortestStringLength = Math.min(shortestStringLength, length);
        longestStringLength = Math.max(longestStringLength, length);
    }

    public String getSummary(boolean fullStats) {
        if (count == 0) return "No data";
        StringBuilder summary = new StringBuilder();
        summary.append("Count: ").append(count);
        if (fullStats) {
            if (shortestStringLength != Integer.MAX_VALUE) {
                summary.append(", Shortest: ").append(shortestStringLength);
                summary.append(", Longest: ").append(longestStringLength);
            } else {
                summary.append(", Min: ").append(min);
                summary.append(", Max: ").append(max);
                summary.append(", Sum: ").append(sum);
                summary.append(", Average: ").append(sum / count);
            }
        }
        return summary.toString();
    }
}

