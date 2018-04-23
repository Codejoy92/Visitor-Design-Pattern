package util;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {

    private Scanner scanner = null;

    public FileProcessor() { 
    	MyLogger.writeMessage("Fileprocessor construcotr:  -> ", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Constructor for FileProcessor; takes in the file path and initializes the scanner with it.
     *
     * @param filePathIn input.txt/delete.txt path is passed for Scanner.
     */
    public FileProcessor(String filePathIn) {

        File file = null;
        if (!filePathIn.isEmpty() || !filePathIn.equals("")) {
            file = new File(filePathIn);
        }
        try {
            if (file != null) this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NullPointerException npe) {
            System.out.println("Seems like a file was missing while passing the arguments to the program.");
        } finally { }
    }

    /**
     * This method is called from Results class. It writes to the three output files.
     *
     * @param resultIn   The result to be written to the file.
     * @param filePathIn The file to write the result in.
     */
    public void write(String resultIn, String filePathIn) {

        File file;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(filePathIn);
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(resultIn);
        } catch (IOException ioe) {
            System.out.println("One or more output files were not found!");
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException e) {
                System.out.println();
            }
        }
    }

    public void fillLists(FileType fileType) {

        if (fileType.equals(FileType.INPUT)) {

            DSeaGate productOne = new ProductOne();
            DSeaGate productTwo = new ProductTwo();
            DSeaGate productThree = new ProductThree();
            DSeaGate productFour = new ProductFour();

            // The product object variable is initialized for ProductOne.
            DSeaGate product = productOne;

            String fileLine = "";
            int count = 0;
            while (hasNextLine()) {
                fileLine = getNextLine();

                /**
                 * The if-else conditions below change the 'product' object to the next one if the count is increased.
                 * The count is increased when 6 lines are added for product 1, then 6 more for product 2 and so on.
                 */
                if (count != 0 && (count % 6 == 0)) {
                    if (product instanceof ProductOne) {
                        DSeaGate.addChild(product);
                        product = productTwo;
                    } else if (product instanceof ProductTwo) {
                        DSeaGate.addChild(product);
                        product = productThree;
                    } else if (product instanceof ProductThree) {
                        DSeaGate.addChild(product);
                        product = productFour;
                    }
                }

                product.getProductList().add(fileLine);
                /*
                if (product instanceof ProductOne) {
                    ((ProductOne) product).getProductOneList().add(fileLine);
                } else if (product instanceof ProductTwo) {
                    ((ProductTwo) product).getProductTwoList().add(fileLine);
                } else if (product instanceof ProductThree) {
                    ((ProductThree) product).getProductThreeList().add(fileLine);
                } else if (product instanceof ProductFour) {
                    ((ProductFour) product).getProductFourList().add(fileLine);
                }
                */
                count++;
            }
            if (product instanceof ProductFour) {

                DSeaGate.addChild(product);
            }

            scanner.close();
        } else if (fileType.equals(FileType.SYNONYM)) {

            // Read synonyms from the file.
            while(hasNextLine()) {
                String[] tokens = Utility.tokenizeWords(getNextLine());
                String key = tokens[0].trim();
                String value = tokens[1].trim();
                Utility.synonymsMap.put(key, value);
            }
            scanner.close();
        } else if (fileType.equals(FileType.KEYWORD)) {
            while(hasNextLine()) {
                Utility.keywordList.add(getNextLine());
            }
            scanner.close();
        }
    }

    /**
     * Gets a single line from a file.
     *
     * @return returns a single file line.
     */
    public String getNextLine() {

        String fileLine;
        try {
            fileLine = scanner.nextLine();
        } finally {
            if (scanner == null) {
                System.out.println("The file could not be found!");
            }
        }
        return fileLine;
    }

    /**
     * Used while iterating over input.txt and delete.txt
     *
     * @return returns true if there is another line in the input.
     */
    public boolean hasNextLine() {

        return this.scanner.hasNextLine();
    }

    @Override
    public String toString() {
        return "FileProcessor{}";
    }
}
