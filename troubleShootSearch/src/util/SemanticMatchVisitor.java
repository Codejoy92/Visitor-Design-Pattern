package util;

import java.util.List;

public class SemanticMatchVisitor implements VisitorI {

    public SemanticMatchVisitor() {}

    @Override
    public void visit(ProductOne productOne) {

        for (String keyword: Utility.keywordList) {
            matchSemantically(keyword, productOne);
        }
    }

    @Override
    public void visit(ProductTwo productTwo) {

        for (String keyword: Utility.keywordList) {
            matchSemantically(keyword, productTwo);
        }
    }

    @Override
    public void visit(ProductThree productThree) {

        for (String keyword: Utility.keywordList) {
            matchSemantically(keyword, productThree);
        }
    }

    @Override
    public void visit(ProductFour productFour) {

        for (String keyword: Utility.keywordList) {
            matchSemantically(keyword, productFour);
        }
    }

    /**
     * Semantic pattern matching algorithm logic.
     * @param keyword
     * @param product
     */
    private void matchSemantically(String keyword, DSeaGate product) {

        String[] tokens = Utility.tokenizeKeyword(keyword);
        String lastToken = tokens[tokens.length - 1];
        String synonym = "";
        if (Utility.synonymsMap.containsKey(lastToken)) {
            synonym = Utility.synonymsMap.get(lastToken);
        }

        List<String> productList = product.getProductList();

        if (!productList.isEmpty()) {
            for (String line : productList) {
                if (line.matches("(.*)" + synonym + "(.*)") && !synonym.equals("")) {
                    Results.sb.append("Semantic Match: ");
                    Results.sb.append(System.getProperty("line.separator"));
                    Results.sb.append("Line: " + line + " Matched word: " + keyword);
                    Results.sb.append(System.getProperty("line.separator"));
                    MyLogger.writeMessage("semantic Match for keyword:  -> " + keyword, MyLogger.DebugLevel.SEMANTIC_FOUND);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SemanticMatchVisitor{}";
    }
}
