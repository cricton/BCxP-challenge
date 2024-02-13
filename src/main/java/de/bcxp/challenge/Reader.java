package de.bcxp.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {

    private String delimiter;
    private String filePath;

    Reader(){

    }
    
    Reader(String delimiter){
        this.delimiter = delimiter;
    }

    Reader(String delimiter, String filePath){
        this.delimiter = delimiter;
        this.filePath = filePath;
    }

    /**
     * This function reads a target CSV and converts it to a list of lists
     * @return List of lists containing the CSV data
     */
    public List<List<String>> readCSV(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(this.delimiter);  
                records.add(Arrays.asList(values));
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File "+ this.filePath + " not found.");
        } catch (IOException e){
            System.err.println("IO error.");
        }

        return records;
    }

    /**
     * This function expects a string that can be converted to a float
     * @param cell String represantation of a float
     * @return The converted float
     */
    public static float toFloat(String cell){

        //If the cell is in format 123.456,78 convert it to 123456.78
        if (cell.indexOf('.') != -1 && cell.indexOf(',') != -1) {
            cell = cell.replace(".", "");
            cell = cell.replace(",", ".");
        }


        try {
            return Float.parseFloat(cell);
        } catch (IllegalArgumentException e) {
            System.err.println("Illegal argument in cell: "+cell);
            return 0;
        }

    }


    /**
     * Setter for the delimiter variable
     * @param delimiter The new delimiter value to set
     */
    public void setDelimiter(String delimiter){
        this.delimiter = delimiter;
    }


    /**
     * Getter for the delimiter variable
     * @return The current delimiter value
     */
    public String getDelimiter(){
        return this.delimiter;
    }


    /**
     * Setter for the filepath variable
     * @param delimiter The new filepath value to set
     */
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    /**
     * Getter for the filepath variable
     * @return The current filepath value
     */
    public String getFilePath(){
        return this.filePath;
    }

}
