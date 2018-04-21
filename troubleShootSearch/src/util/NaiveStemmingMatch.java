package util;

public class NaiveStemmingMatch implements VisitorI {


    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public NaiveStemmingMatch() {}

    @Override
    public void visit(ProductOne productOne) {
        algorithmEngineer.matchByNaiveStemming("detect error", Product.ONE);
    }

    @Override
    public void visit(ProductTwo productTwo) {
        algorithmEngineer.matchByNaiveStemming("detect error", Product.TWO);
    }

    @Override
    public void visit(ProductThree productThree) {
        algorithmEngineer.matchByNaiveStemming("detect error", Product.THREE);
    }

    @Override
    public void visit(ProductFour productFour) {
        algorithmEngineer.matchByNaiveStemming("detect error", Product.FOUR);
    }

    @Override
    public String toString() {
        return "NaiveStemmingMatch{}";
    }
}
