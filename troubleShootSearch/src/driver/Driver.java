package driver;

import util.*;

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

        //if (validate(args)) {
            buildInput(args);
            dSeaGate dSeaGateProducts = new dSeaGate();

            ExactMatch exactMatch = new ExactMatch();
            SemanticMatch semanticMatch = new SemanticMatch();
            NaiveStemmingMatch naiveStemmingMatch = new NaiveStemmingMatch();

            dSeaGateProducts.initializeChildren();
            dSeaGateProducts.accept(exactMatch);
            dSeaGateProducts.accept(semanticMatch);
            dSeaGateProducts.accept(naiveStemmingMatch);

            System.out.println(AlgorithmEngineer.sb);
        //}
    }

    private static void buildInput(String[] args) {

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
