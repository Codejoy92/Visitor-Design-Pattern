package util;

public class SemanticMatch implements VisitorI {

    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public SemanticMatch() {
    	MyLogger.writeMessage("Inside SemanticMatch Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void visit(ProductOne productOne) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchSemantically(keyword , Product.ONE);
        }
    }

    @Override
    public void visit(ProductTwo productTwo) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchSemantically(keyword, Product.TWO);
        }
    }

    @Override
    public void visit(ProductThree productThree) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchSemantically(keyword, Product.THREE);
        }
    }

    @Override
    public void visit(ProductFour productFour) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchSemantically(keyword, Product.FOUR);
        }
    }

    @Override
    public String toString() {
        return "SemanticMatch{}";
    }
}
