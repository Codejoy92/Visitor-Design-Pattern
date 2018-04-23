package util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class DSeaGate implements VisitorAcceptanceI{

    private static List<VisitorAcceptanceI> dSeaGateProducts = new ArrayList<VisitorAcceptanceI>();

    /**
     * Adds a child instance to the static list of VisitorAcceptanceI interface containing the accept method.
     * @param productIn
     */
    public static void addChild(DSeaGate productIn) {

        dSeaGateProducts.add(productIn);
    }

    @Override
    public void accept(VisitorI visitorI) {

        for (VisitorAcceptanceI product: dSeaGateProducts) {
            product.accept(visitorI);
        }
    }

    public List<String> getProductList() {

        throw new NotImplementedException();
    }
}
