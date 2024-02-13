package de.bcxp.challenge;


import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {



    /**
     * This function is used to calculate the day with the lowest temperature spread
     * @param filePath Path to the target CSV
     * @return The day with the lowest temperature spread
     */
    public static String leastTempSpreadDay(String filePath) {
        Reader reader = new Reader(",", filePath);
        List<List<String>> data = reader.readCSV();


        float minTemperatureSpread = Float.MAX_VALUE;
        String minTemperatureDay = "-1";
        for (int i = 1; i < data.size(); i++) {
            float tempSpread = Reader.toFloat(data.get(i).get(1)) - Reader.toFloat(data.get(i).get(2));
            if (tempSpread<minTemperatureSpread) {
                minTemperatureSpread = tempSpread;
                minTemperatureDay = data.get(i).get(0);
            }
        }

        return minTemperatureDay;
    }

    /**
     * This function is used calculate the country with the highest population density
     * @param filePath Path to the target CSV
     * @return The country with the highest population density
     */
    public static String highestPopDensity(String filePath) {
        Reader reader = new Reader(";", filePath);
        List<List<String>> data = reader.readCSV();


        float maxPopDensity = 0;
        String maxDensityCountry = "";


        for (int i = 1; i < data.size(); i++) {
            float density = Reader.toFloat(data.get(i).get(3)) / Reader.toFloat(data.get(i).get(4));
            if (density>maxPopDensity) {
                maxPopDensity = density;
                maxDensityCountry = data.get(i).get(0);
            }
        }


        return maxDensityCountry;
    }

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        String dayWithSmallestTempSpread = leastTempSpreadDay("src\\main\\resources\\de\\bcxp\\challenge\\weather.csv");     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = highestPopDensity("src\\main\\resources\\de\\bcxp\\challenge\\countries.csv"); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
