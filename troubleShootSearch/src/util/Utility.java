package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

    public static Map<String, String> synonymsMap = new HashMap<String, String>();
    public static List<String> keywordList = new ArrayList<String>();

    public Utility() {}

    public static String[] tokenizeKeyword(String keyword) {

        String[] tokens = new String[0];
        if(!keyword.equals("") && !keyword.equals(" ")) {
            tokens = keyword.split(" ");
        }
        return tokens;
    }

    public static String[] tokenizeWords(String line) {

        String[] lineTokens = new String[0];
        if (!line.equals("") && !line.equals(" ")) {
            lineTokens = line.split(":| :|: | : ");
        }
        return lineTokens;
    }
}
