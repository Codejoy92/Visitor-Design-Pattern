package util;

public class ExactMatch implements VisitorI {

    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public ExactMatch() { 
    	MyLogger.writeMessage("Inside ExactMatch Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void visit(ProductOne productOne) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchExactly(keyword, Product.ONE);
        }
    }

    @Override
    public void visit(ProductTwo productTwo) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchExactly(keyword, Product.TWO);
        }
    }

    @Override
    public void visit(ProductThree productThree) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchExactly(keyword, Product.THREE);
        }
    }

    @Override
    public void visit(ProductFour productFour) {

        for (String keyword: AlgorithmEngineer.keywordList) {
            algorithmEngineer.matchExactly(keyword, Product.FOUR);
        }
    }

    @Override
    public String toString() {
        return "ExactMatch{}";
    }
}
