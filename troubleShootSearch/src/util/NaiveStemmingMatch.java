package util;

public class NaiveStemmingMatch implements VisitorI {


    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public NaiveStemmingMatch() {
    	MyLogger.writeMessage("Inside NaiveStemmingMatch Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void visit(ProductOne productOne) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchByNaiveStemming(keyword, Product.ONE);
        }
    }

    @Override
    public void visit(ProductTwo productTwo) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchByNaiveStemming(keyword, Product.TWO);
        }
    }

    @Override
    public void visit(ProductThree productThree) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchByNaiveStemming(keyword, Product.THREE);
        }
    }

    @Override
    public void visit(ProductFour productFour) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchByNaiveStemming(keyword, Product.FOUR);
        }
    }

    @Override
    public String toString() {
        return "NaiveStemmingMatch{}";
    }
}
