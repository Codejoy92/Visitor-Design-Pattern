package util;

public class ExactMatch implements VisitorI {

    AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();

    public ExactMatch() { }

    @Override
    public void visit(ProductOne productOne) {
        algorithmEngineer.matchExactly("problem detecting", Product.ONE);
    }

    @Override
    public void visit(ProductTwo productTwo) {
        algorithmEngineer.matchExactly("problem detecting", Product.TWO);
    }

    @Override
    public void visit(ProductThree productThree) {
        algorithmEngineer.matchExactly("problem detecting", Product.THREE);
    }

    @Override
    public void visit(ProductFour productFour) {
        algorithmEngineer.matchExactly("problem detecting", Product.FOUR);
    }

    @Override
    public String toString() {
        return "ExactMatch{}";
    }
}
