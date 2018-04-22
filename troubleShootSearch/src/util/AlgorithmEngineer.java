package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Core pattern matching class.
 *  Each algorithm mechanism is accessed when needed, and the result is returned.
 *  Pattern matching is done in this class for all 3 algorithms.
 */
public class AlgorithmEngineer {

    public static StringBuilder sb = new StringBuilder();
    public static Map<String, String> synonymsMap = new HashMap<String, String>();
    public static List<String> keywordList = new ArrayList<String>();

    public List<String> productList = new ArrayList<String>();
    private ProductOne productOne = new ProductOne();
    private ProductTwo productTwo = new ProductTwo();
    private ProductThree productThree = new ProductThree();
    private ProductFour productFour = new ProductFour();

    public static int exactMatchedKeywords = 0;
    public static int naiveStemmingMatches = 0;
    public static int semanticMatches = 0;

    public AlgorithmEngineer() { }

    public void matchExactly(String keyword, Product productType) {

        //String[] tokens = tokenizeKeyword(keyword);

        if (productType.equals(Product.ONE)) productList = productOne.getProductOneList();
        if (productType.equals(Product.TWO)) productList = productTwo.getProductTwoList();
        if (productType.equals(Product.THREE)) productList = productThree.getProductThreeList();
        if (productType.equals(Product.FOUR)) productList = productFour.getProductFourList();

        if(!productList.isEmpty()) {
            for (String line: productList) {
                if (line.contains(keyword)) {
                    // There's an exact match for the given keyword in the line.
                    sb.append("Exact Match: ");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Line: "+ line + " Matched word: " + keyword);
                    sb.append(System.getProperty("line.separator"));
                    exactMatchedKeywords++;
                    
                }
            }
        }
    }

    public void matchSemantically(String keyword, Product productType) {

        String[] tokens = tokenizeKeyword(keyword);
        String lastToken = tokens[tokens.length - 1];
        String synonym = "";
        if (AlgorithmEngineer.synonymsMap.containsKey(lastToken)) {
            synonym = AlgorithmEngineer.synonymsMap.get(lastToken);
        }

        if (productType.equals(Product.ONE)) productList = productOne.getProductOneList();
        if (productType.equals(Product.TWO)) productList = productTwo.getProductTwoList();
        if (productType.equals(Product.THREE)) productList = productThree.getProductThreeList();
        if (productType.equals(Product.FOUR)) productList = productFour.getProductFourList();

        if (!productList.isEmpty()) {
            for (String line : productList) {
                if (line.matches("(.*)" + synonym + "(.*)") && !synonym.equals("")) {
                    sb.append("Semantic Match: ");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Line: " + line + " Matched word: " + keyword);
                    sb.append(System.getProperty("line.separator"));
                    semanticMatches++;
                    MyLogger.writeMessage("Semantic Match", MyLogger.DebugLevel.SEMANTIC_FOUND);
                }
            }
        }
    }

    public void matchByNaiveStemming(String keyword, Product productType) {

        String[] tokens = tokenizeKeyword(keyword);

        if (productType.equals(Product.ONE)) productList = productOne.getProductOneList();
        if (productType.equals(Product.TWO)) productList = productTwo.getProductTwoList();
        if (productType.equals(Product.THREE)) productList = productThree.getProductThreeList();
        if (productType.equals(Product.FOUR)) productList = productFour.getProductFourList();

        for (String token: tokens) {
            if(!productList.isEmpty()) {
                for (String line: productList) {
                    if (line.matches("(.*)"+ token +"(.*)") && !token.equals("")) {
                        sb.append("Naive Stemming Match: ");
                        sb.append(System.getProperty("line.separator"));
                        sb.append("Line: "+ line + " Matched word: " + keyword);
                        sb.append(System.getProperty("line.separator"));
                        naiveStemmingMatches++;
                    }
                }
            }
        }
    }

    public String[] tokenizeKeyword(String keyword) {

        String[] tokens = new String[0];
        if(!keyword.equals("") && !keyword.equals(" ")) {
            tokens = keyword.split(" ");
        }
        return tokens;
    }

    public String[] tokenizeWords(String line) {

        String[] lineTokens = new String[0];
        if (!line.equals("") && !line.equals(" ")) {
            lineTokens = line.split(":| :|: | : ");
        }
        return lineTokens;
    }


    public int getExactMatchedKeywords() {
        return exactMatchedKeywords;
    }

    public void setExactMatchedKeywords(int exactMatchedKeywordsIn) {
        exactMatchedKeywords = exactMatchedKeywordsIn;
    }

    public int getNaiveStemmingMatches() {
        return naiveStemmingMatches;
    }

    public void setNaiveStemmingMatches(int naiveStemmingMatches) {
        this.naiveStemmingMatches = naiveStemmingMatches;
    }

    public int getSemanticMatches() {
        return semanticMatches;
    }

    public void setSemanticMatches(int semanticMatches) {
        this.semanticMatches = semanticMatches;
    }
}
