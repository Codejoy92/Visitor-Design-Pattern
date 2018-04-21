package util;

public class dSeaGate implements VisitorAcceptanceI{

    private VisitorAcceptanceI[] dSeaGateProducts;

    public void initializeChildren() {
        dSeaGateProducts = new VisitorAcceptanceI[] {new ProductOne(), new ProductTwo(), new ProductThree(), new ProductFour()};
    }

    @Override
    public void accept(VisitorI visitorI) {

        for(int i = 0; i < dSeaGateProducts.length; i++) {
            dSeaGateProducts[i].accept(visitorI);
        }
    }
}
