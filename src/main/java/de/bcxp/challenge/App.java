package de.bcxp.challenge;


import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {



    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        String filepath = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
        String dayWithSmallestTempSpread = WeatherAnalysis.leastTempSpread(filepath);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        filepath = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";
        String maxPopDensity = CountryAnalysis.highestPopDensity(filepath); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", maxPopDensity);
    }
}
