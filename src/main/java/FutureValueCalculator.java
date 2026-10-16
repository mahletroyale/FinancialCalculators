import java.util.Scanner;

public class FutureValueCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter annual interest rate: ");
        double interestRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        double futureValue = calculateFutureValue(principal, interestRate, years);
        double totalInterest = futureValue - principal;

        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);
    }

    public static double calculateFutureValue(double principal,
                                              double interestRate,
                                              int years) {

        double rate = interestRate / 100;

        int daysPerYear = 365;

        int totalDays = daysPerYear * years;

        return principal *
                Math.pow(1 + (rate / daysPerYear), totalDays);
    }
}
