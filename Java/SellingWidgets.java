package Java;

import java.util.Scanner;

public class SellingWidgets {

    private static double calculateCost(int widgetQuantity) {
        // Find the mod of 3 and multiply that by 0.65
        // Then find the divisible by three and add that.
       double result = ((widgetQuantity % 3) * 0.65) + ((widgetQuantity/3) * 1);
       return result;



    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of widgets to buy: ");
        int widgetQuantity;
        try {
            widgetQuantity = Integer.parseInt(scanner.nextLine().trim());
            if (widgetQuantity <= 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("That isn’t a valid number.");
            return;
        }

        double result = calculateCost(widgetQuantity);        
        
        // 4️⃣ Output the final result
        System.out.println("Total cost " + result);

        // Clean up
        scanner.close();
    }
}
