package util;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {

    private Scanner scanner = null;

    FileProcessor() { }

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
    public static void write(String resultIn, String filePathIn) {

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
            ProductOne productOne = null;
            ProductTwo productTwo = null;
            ProductThree productThree = null;
            ProductFour productFour = null;

            dSeaGate product = new ProductOne();                  // The product object variable is initialized for ProductOne.

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
                        product = new ProductTwo();
                    } else if (product instanceof ProductTwo) {
                        product = new ProductThree();
                    } else if (product instanceof ProductThree) {
                        product = new ProductFour();
                    }
                }

                if (product instanceof ProductOne) {
                    ((ProductOne) product).getProductOneList().add(fileLine);
                } else if (product instanceof ProductTwo) {
                    ((ProductTwo) product).getProductTwoList().add(fileLine);
                } else if (product instanceof ProductThree) {
                    ((ProductThree) product).getProductThreeList().add(fileLine);
                } else if (product instanceof ProductFour) {
                    ((ProductFour) product).getProductFourList().add(fileLine);
                }
                count++;
            }
            scanner.close();
        } else if (fileType.equals(FileType.SYNONYM)){
            AlgorithmEngineer algorithmEngineer = new AlgorithmEngineer();
            // Read synonyms from the file.
            while(hasNextLine()) {
                String[] tokens = algorithmEngineer.tokenizeWords(getNextLine());
                String key = tokens[0];
                String value = tokens[1];
                AlgorithmEngineer.synonymsMap.put(key, value);
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
