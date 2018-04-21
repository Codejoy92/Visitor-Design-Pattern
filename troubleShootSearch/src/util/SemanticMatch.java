package util;

public class SemanticMatch implements VisitorI {

    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public SemanticMatch() {}

    @Override
    public void visit(ProductOne productOne) {
        algorithmEngineer.matchSemantically("compatible CPU", Product.ONE);
    }

    @Override
    public void visit(ProductTwo productTwo) {
        algorithmEngineer.matchSemantically("compatible CPU", Product.TWO);
    }

    @Override
    public void visit(ProductThree productThree) {
        algorithmEngineer.matchSemantically("compatible CPU", Product.THREE);
    }

    @Override
    public void visit(ProductFour productFour) {
        algorithmEngineer.matchSemantically("compatible CPU", Product.FOUR);
    }

    @Override
    public String toString() {
        return "SemanticMatch{}";
    }
}
