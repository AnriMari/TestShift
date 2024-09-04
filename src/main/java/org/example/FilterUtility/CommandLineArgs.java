package org.example.FilterUtility;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommandLineArgs {

    private String outputPath = ".";
    private String prefix = "";
    private boolean appendMode = false;
    private boolean fullStats = false;
    private final List<String> inputFiles = new ArrayList<>();

    public static CommandLineArgs parse(String[] args) {
        CommandLineArgs parsedArgs = new CommandLineArgs();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    parsedArgs.outputPath = args[++i];
                    break;
                case "-p":
                    parsedArgs.prefix = args[++i];
                    break;
                case "-a":
                    parsedArgs.appendMode = true;
                    break;
                case "-s":
                    parsedArgs.fullStats = false;
                    break;
                case "-f":
                    parsedArgs.fullStats = true;
                    break;
                default:
                    parsedArgs.inputFiles.add(args[i]);
            }
        }
        return parsedArgs;
    }
}
