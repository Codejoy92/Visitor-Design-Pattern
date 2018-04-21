package util;

import java.util.ArrayList;
import java.util.List;

public class ProductOne extends dSeaGate implements VisitorAcceptanceI {

    private static List<String> productOneList = new ArrayList<String>();

    public ProductOne() {
    	MyLogger.writeMessage("Inside ProductOne Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void accept(VisitorI visitorI) {
        visitorI.visit(this);
    }

    public List<String> getProductOneList() {
        return productOneList;
    }

    public void setProductOneList(List<String> productOneList) {
        this.productOneList = productOneList;
    }
}
