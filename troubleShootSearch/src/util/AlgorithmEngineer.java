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

    public List<String> productList = new ArrayList<String>();
    private ProductOne productOne = new ProductOne();
    private ProductTwo productTwo = new ProductTwo();
    private ProductThree productThree = new ProductThree();
    private ProductFour productFour = new ProductFour();

    private int exactMatchedKeywords = 0;

    public AlgorithmEngineer() { }

    public void matchExactly(String keyword, Product productType) {

        String[] tokens = tokenizeKeyword(keyword);

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
                    sb.append("Matched word: " + keyword);
                    sb.append(System.getProperty("line.separator"));
                    exactMatchedKeywords++;
                }
            }
        }
    }

    public void matchSemantically(String keyword) {

        String[] tokens = tokenizeKeyword(keyword);
/**
 * This for loop scans a particular product's ArrayList.
 */
        for (String line: productList) {
            String[] lineTokens = tokenizeWords(line);
/**
 * This for loop scans through the tokens obtained from the keywords passed by user.
 */
            for (String token: tokens) {
/**
 * This for loop scans through the tokens obtained from a line from the ArrayList.
 */
                for(String lineToken: lineTokens) {
/**
 * Now we check if a keyword matches a word from the ArrayList's words (lineTokens).
 */
                    if ((!token.equals("") && !lineToken.equals("")) && token.equals(lineToken)) {

                    }
                }
            }
        }
    }

    public void matchByNaiveStemming(String keyword) {

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
            lineTokens = line.split(" |:");
        }
        return lineTokens;
    }

    public boolean matchSynonym(String keyword) {

        if(!keyword.equals("")) {

        }
        return true;
    }

    public int getExactMatchedKeywords() {
        return exactMatchedKeywords;
    }

    public void setExactMatchedKeywords(int exactMatchedKeywordsIn) {
        exactMatchedKeywords = exactMatchedKeywordsIn;
    }
}
