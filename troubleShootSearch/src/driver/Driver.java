package driver;

import util.DSeaGate;
import util.ExactMatchVisitor;
import util.FileProcessor;
import util.FileType;
import util.MyLogger;
import util.NaiveStemmingMatchVisitor;
import util.Results;
import util.SemanticMatchVisitor;

public class Driver {

    /**
     * Main method:
     * Validates arguments
     * Process visitor pattern for the given keywords.
     * Results are written to the output files.
     * <p>
     * Since no other classes are going to create Driver's instances, all methods in the Driver are made static
     * to handle non static methods being called in a static method (main method).
     *
     * @param args Program arguments
     */
    public static void main(String[] args) {
    	if(args.length == 4) {
			int debugValue = 0; 
			 try {
				 debugValue = Integer.parseInt(args[3]);
				 MyLogger.setDebugValue(debugValue);

			  } catch (NumberFormatException e) {
			     System.out.println("Error while parsing debug level value");
			     e.printStackTrace();
			     System.exit(0);
			  }
    	} 
    	
        //if (validate(args)) {
            buildInput(args);
            DSeaGate dSeaGateProducts = new DSeaGate();

            ExactMatchVisitor exactMatch = new ExactMatchVisitor();
            SemanticMatchVisitor semanticMatch = new SemanticMatchVisitor();
            NaiveStemmingMatchVisitor naiveStemmingMatch = new NaiveStemmingMatchVisitor();

            dSeaGateProducts.accept(exactMatch);
            dSeaGateProducts.accept(semanticMatch);
            dSeaGateProducts.accept(naiveStemmingMatch);

            System.out.println(Results.sb);
        //}
    }

    private static void buildInput(String[] args) {

        FileProcessor fileProcessorKeywords = new FileProcessor(args[0]);
        fileProcessorKeywords.fillLists(FileType.KEYWORD);
        FileProcessor fileProcessorInputTxt = new FileProcessor(args[1]);   //args[1] is input1.txt
        fileProcessorInputTxt.fillLists(FileType.INPUT);
        FileProcessor fileProcessorSynonyms = new FileProcessor(args[2]);
        fileProcessorSynonyms.fillLists(FileType.SYNONYM);
    }

    /**
     * This method is used to validate the command line arguments and handle any errors related to it.
     *
     * @param argsIn Program arguments are passed to validate method for error handling purposes.
     * @return files;String array of input and delete file paths.
     */
    private static boolean validate(String[] argsIn) {

        try {
            if (argsIn.length != 2 || argsIn[0].equals("${arg0}") || argsIn[1].equals("${arg1}")) {

                System.err.println("Arguments passed were either less/more than expected!\nThe program accepts 2 arguments.");
                return false;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Arguments passed were either less/more than expected!");
        } finally { }
        return true;
    }
}
