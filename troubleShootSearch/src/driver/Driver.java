package driver;

import util.DSeaGate;
import util.ExactMatchVisitor;
import util.FileProcessor;
import util.FileType;
import util.MyLogger;
import util.NaiveStemmingMatchVisitor;
import util.Results;
import util.SemanticMatchVisitor;
import util.Utility;

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
    	
     		Utility util = new Utility();
            DSeaGate dSeaGateProducts = new DSeaGate();
            ExactMatchVisitor exactMatch = new ExactMatchVisitor();
            SemanticMatchVisitor semanticMatch = new SemanticMatchVisitor();
            NaiveStemmingMatchVisitor naiveStemmingMatch = new NaiveStemmingMatchVisitor();
            FileProcessor processor = new FileProcessor();
        	util.validate(args);
            dSeaGateProducts.accept(exactMatch);
            dSeaGateProducts.accept(semanticMatch);
            dSeaGateProducts.accept(naiveStemmingMatch);
            processor.write(Results.sb.toString(), args[3]);
    }
}
