public class DivisionExample {
    
    // Method that performs division and may throw ArithmeticException
    public static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }
    
    public static void main(String[] args) {
        try {
            // Code that might throw an exception
            System.out.println("Attempting to divide 10 by 0...");
            int result = divide(10, 0);
            System.out.println("Result: " + result); // This line won't be reached
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
            System.out.println("Exception details: " + e.getMessage());
        } finally {
            System.out.println("Cleanup operations - this always executes");
        }
        
        // Demonstrate successful division
        try {
            System.out.println("\nAttempting to divide 10 by 2...");
            int result = divide(10, 2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("Cleanup operations - this always executes");
        }
    }
}