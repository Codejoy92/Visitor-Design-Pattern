package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

    public static Map<String, String> synonymsMap = new HashMap<String, String>();
    public static List<String> keywordList = new ArrayList<String>();

    public Utility() {}
    /**
     * This method is used to validate the command line arguments and handle any errors related to it.
     *
     * @param argsIn Program arguments are passed to validate method for error handling purposes.
     * @return files;String array of input and delete file paths.
     */
	public void validate(String[] argsIn) {

		if (argsIn.length < 4 || argsIn[0].equals("${arg0}") || argsIn[1].equals("${arg1}")
				|| argsIn[2].equals("${arg2}") || argsIn[3].equals("${arg3}") || null == argsIn) {
			System.err
					.println("Arguments passed were either less/more than expected!\nThe program accepts 4 arguments.");
			System.exit(0);
		}
		buildInput(argsIn);
		if (argsIn.length == 5) {
			int debugValue = 0;
			try {
				debugValue = Integer.parseInt(argsIn[3]);
				MyLogger.setDebugValue(debugValue);

			} catch (NumberFormatException e) {
				System.out.println("Error while parsing debug level value");
				e.printStackTrace();
				System.exit(0);
			}
		}

	}
    
    public void buildInput(String[] args) {

        FileProcessor fileProcessorKeywords = new FileProcessor(args[0]);
        fileProcessorKeywords.fillLists(FileType.KEYWORD);
        FileProcessor fileProcessorInputTxt = new FileProcessor(args[1]);   //args[1] is input1.txt
        fileProcessorInputTxt.fillLists(FileType.INPUT);
        FileProcessor fileProcessorSynonyms = new FileProcessor(args[2]);
        fileProcessorSynonyms.fillLists(FileType.SYNONYM);
    }
    
	/**
	 * This method is used to split the keyword
	 *
	 * @param keyword
	 * @return tokens
	 */
    public static String[] tokenizeKeyword(String keyword) {

        String[] tokens = new String[0];
        if(!keyword.equals("") && !keyword.equals(" ")) {
            tokens = keyword.split(" ");
        }
        return tokens;
    }
	/**
	 * This method is used to split the line
	 *
	 * @param line
	 * @return lineTokens
	 */
    public static String[] tokenizeWords(String line) {

        String[] lineTokens = new String[0];
        if (!line.equals("") && !line.equals(" ")) {
            lineTokens = line.split(":| :|: | : ");
        }
        return lineTokens;
    }
}
