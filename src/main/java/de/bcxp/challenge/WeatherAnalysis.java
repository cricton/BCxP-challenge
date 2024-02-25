package de.bcxp.challenge;



import java.util.List;

public class WeatherAnalysis {
    

    /**
     * This function is used to calculate the day with the lowest temperature spread
     * @param filePath Path to the target CSV
     * @return The day with the lowest temperature spread
     */
    public static String leastTempSpread(String filePath) {
        Reader reader = new Reader(",", filePath);
        List<List<String>> data = reader.readCSV();
        
        if (data.size()==0) {
            return "No data to be processed.";
        }

        int minTemptIndex = 2;
        int maxTempIndex = 1;

        float minTemperatureSpread = Float.MAX_VALUE;
        String minTemperatureDay = "-1";
        for (int i = 1; i < data.size(); i++) {
            float tempSpread = Reader.toFloat(data.get(i).get(maxTempIndex)) - Reader.toFloat(data.get(i).get(minTemptIndex));
            if (tempSpread<minTemperatureSpread) {
                minTemperatureSpread = tempSpread;
                minTemperatureDay = data.get(i).get(0);
            }
        }

        return minTemperatureDay;
    }
}
