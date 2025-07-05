import java.util.Arrays;
import java.util.Random;

public class AirQualityDashboard {
    public static void main(String[] args) {
        // i) Generate 30 random AQI readings between 1 and 300
        int[] aqiReadings = generateAQIReadings(30);
        System.out.println("Generated AQI Readings:");
        System.out.println(Arrays.toString(aqiReadings));
        
        // ii) Compute and display the median AQI value
        double median = calculateMedian(aqiReadings);
        System.out.printf("\nMedian AQI: %.1f\n", median);
        
        // iii) Identify and count hazardous days (AQI > 200)
        int hazardousDays = countHazardousDays(aqiReadings);
        System.out.println("Number of hazardous days (AQI > 200): " + hazardousDays);
    }
    
    // Generate random AQI readings
    public static int[] generateAQIReadings(int days) {
        int[] readings = new int[days];
        Random rand = new Random();
        for (int i = 0; i < days; i++) {
            readings[i] = rand.nextInt(300) + 1; // 1-300 inclusive
        }
        return readings;
    }
    
    // Calculate median AQI
    public static double calculateMedian(int[] readings) {
        int[] sorted = Arrays.copyOf(readings, readings.length);
        Arrays.sort(sorted);
        
        if (sorted.length % 2 == 0) {
            // Even number of elements - average middle two
            return (sorted[sorted.length/2 - 1] + sorted[sorted.length/2]) / 2.0;
        } else {
            // Odd number - return middle element
            return sorted[sorted.length/2];
        }
    }
    
    // Count hazardous days
    public static int countHazardousDays(int[] readings) {
        int count = 0;
        for (int aqi : readings) {
            if (aqi > 200) {
                count++;
            }
        }
        return count;
    }
}
