package util;

/**
 * Results class just holds the StringBuilder in which strings are appended throughout the process of the program.
 */
public class Results {

    public static StringBuilder sb = new StringBuilder();

    public void writeOutput(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.write(Results.sb.toString(), args[3]);
    }
}
