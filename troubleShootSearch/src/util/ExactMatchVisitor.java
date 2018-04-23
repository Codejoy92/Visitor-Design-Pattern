package util;

import java.util.List;

public class ExactMatchVisitor implements VisitorI {

    public ExactMatchVisitor() { }

    @Override
    public void visit(ProductOne productOne) {

        for (String keyword: Utility.keywordList) {
            matchExactly(keyword, productOne);
        }
    }

    @Override
    public void visit(ProductTwo productTwo) {

        for (String keyword: Utility.keywordList) {
            matchExactly(keyword, productTwo);
        }
    }

    @Override
    public void visit(ProductThree productThree) {

        for (String keyword: Utility.keywordList) {
            matchExactly(keyword, productThree);
        }
    }

    @Override
    public void visit(ProductFour productFour) {

        for (String keyword: Utility.keywordList) {
            matchExactly(keyword, productFour);
        }
    }

    private void matchExactly(String keyword, DSeaGate product) {

        List<String> productList = product.getProductList();
        if(!productList.isEmpty()) {
            for (String line: productList) {
                if (line.contains(keyword)) {
                    // There's an exact match for the given keyword in the line.
                    Results.sb.append("Exact Match: ");
                    Results.sb.append(System.getProperty("line.separator"));
                    Results.sb.append("Line: "+ line + " Matched word: " + keyword);
                    Results.sb.append(System.getProperty("line.separator"));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ExactMatchVisitor{}";
    }
}
