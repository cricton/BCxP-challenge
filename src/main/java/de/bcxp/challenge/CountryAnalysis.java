package de.bcxp.challenge;

import java.util.List;

public class CountryAnalysis {
    
    /**
     * This function is used calculate the country with the highest population density
     * @param filePath Path to the target CSV
     * @return The country with the highest population density
     */
    public static String highestPopDensity(String filePath) {
        Reader reader = new Reader(";", filePath);
        List<List<String>> data = reader.readCSV();
        
        if (data.size()==0) {
            return "No data to be processed.";
        }

        int areaIndex = 4;
        int popIndex = 3;

        float maxPopDensity = 0;
        String maxDensityCountry = "";
        for (int i = 1; i < data.size(); i++) {
            float density;
            if (Reader.toFloat(data.get(i).get(areaIndex)) == 0) {
                density = 0;
            } else {
                density = Reader.toFloat(data.get(i).get(popIndex)) / Reader.toFloat(data.get(i).get(areaIndex));
            }
            
            if (density>maxPopDensity) {
                maxPopDensity = density;
                maxDensityCountry = data.get(i).get(0);
            }
        }


        return maxDensityCountry;
    }
    
}
