import java.util.Scanner;

public class AQICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Air Quality Index (AQI) Calculator");
            System.out.println("----------------------------------");
            
            System.out.print("Enter total pollutant level: ");
            int totalPollutants = scanner.nextInt();
            
            System.out.print("Enter number of days: ");
            int numberOfDays = scanner.nextInt();
            
            calculateAndDisplayAverage(totalPollutants, numberOfDays);
            performAQIAnalysis(totalPollutants, numberOfDays);
            
        } catch (ArithmeticException e) {
            System.out.println("Error calculating average: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input: Please enter numeric values");
        } finally {
            scanner.close();
            System.out.println("\nThank you for using the AQI Calculator");
        }
    }
    
    private static void calculateAndDisplayAverage(int totalPollutants, int numberOfDays) {
        if (numberOfDays <= 0) {
            throw new ArithmeticException("Number of days must be positive");
        }
        
        double average = (double) totalPollutants / numberOfDays;
        System.out.printf("\nAverage AQI: %.2f%n", average);
        interpretAQILevel(average);
    }
    
    private static void interpretAQILevel(double aqi) {
        System.out.print("Air Quality: ");
        if (aqi <= 50) System.out.println("Good");
        else if (aqi <= 100) System.out.println("Moderate");
        else if (aqi <= 150) System.out.println("Unhealthy for Sensitive Groups");
        else if (aqi <= 200) System.out.println("Unhealthy");
        else if (aqi <= 300) System.out.println("Very Unhealthy");
        else System.out.println("Hazardous");
    }
    
    private static void performAQIAnalysis(int totalPollutants, int numberOfDays) {
        if (numberOfDays > 0) {
            double dailyEquivalent = (double) totalPollutants / numberOfDays;
            System.out.printf("Daily equivalent pollution level: %.2f%n", dailyEquivalent);
            if (dailyEquivalent > 200) {
                System.out.println("Warning: Hazardous pollution levels detected!");
            }
        }
    }
}
