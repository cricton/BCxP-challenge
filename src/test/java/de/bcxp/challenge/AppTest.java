package de.bcxp.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    @Test
    void testLeastTempSpread() {

        String filepath = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
        String dayWithSmallestTempSpread = WeatherAnalysis.leastTempSpread(filepath);     // Your day analysis function call …


        assertEquals("14", dayWithSmallestTempSpread, "Wrong day selected: Day" +dayWithSmallestTempSpread);
    }

    @Test
    void testHighestPopDensity() {
        String filepath = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";
        String maxPopDensity = CountryAnalysis.highestPopDensity(filepath); // Your population density analysis function call …


        assertEquals("Malta", maxPopDensity, "Wrong country selected: " + maxPopDensity);
    }


}

