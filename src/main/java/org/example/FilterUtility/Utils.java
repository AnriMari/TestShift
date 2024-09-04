package org.example.FilterUtility;

import java.util.regex.Pattern;

public class Utils {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern FLOAT_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static DataType identifyDataType(String str) {
        if (isInteger(str)) return DataType.INTEGER;
        if (isFloat(str)) return DataType.FLOAT;
        return DataType.STRING;
    }

    private static boolean isInteger(String str) {
        return INTEGER_PATTERN.matcher(str).matches();
    }

    private static boolean isFloat(String str) {
        return FLOAT_PATTERN.matcher(str).matches() && !isInteger(str);
    }
}


