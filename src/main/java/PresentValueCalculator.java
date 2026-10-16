import java.util.Scanner;

public class PresentValueCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter monthly payout: ");
        double monthlyPayout = input.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        double presentValue = calculatePresentValue(
                monthlyPayout,
                annualRate,
                years
        );

        System.out.printf("Present Value: $%.2f%n", presentValue);
    }


    public static double calculatePresentValue(
            double monthlyPayout,
            double annualRate,
            int years) {

        double rateDecimal = annualRate / 100;

        double monthlyRate = rateDecimal / 12;

        int numberOfPayments = years * 12;

        double presentValue =
                monthlyPayout *
                        (1 - Math.pow(1 + monthlyRate, -numberOfPayments))
                        / monthlyRate;

        return presentValue;
    }
}
