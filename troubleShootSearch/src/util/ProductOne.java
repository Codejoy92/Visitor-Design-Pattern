package util;

import java.util.ArrayList;
import java.util.List;

public class ProductOne extends DSeaGate implements VisitorAcceptanceI {

    private static List<String> productOneList = new ArrayList<String>();

    public ProductOne() {}

    @Override
    public void accept(VisitorI visitorI) {
        visitorI.visit(this);
    }

    @Override
    public List<String> getProductList() {
        return productOneList;
    }

    public List<String> getProductOneList() {
        return productOneList;
    }

    public void setProductOneList(List<String> productOneList) {
        this.productOneList = productOneList;
    }
}
