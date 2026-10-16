import java.util.Scanner;

public class mortgagecalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter loan principal: ");
        double principal = input.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = input.nextDouble();

        System.out.print("Enter loan length in years: ");
        int years = input.nextInt();

        double monthlyPayment = calculateMonthlyPayment(
                principal,
                annualRate,
                years
        );

        double totalInterest = calculateTotalInterest(
                principal,
                monthlyPayment,
                years
        );

        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);
    }


    public static double calculateMonthlyPayment(
            double principal,
            double annualRate,
            int years) {

        double rateDecimal = annualRate / 100;

        double monthlyRate = rateDecimal / 12;

        int numberOfPayments = years * 12;

        double monthlyPayment =
                principal *
                        (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                        /
                        (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        return monthlyPayment;
    }


    public static double calculateTotalInterest(
            double principal,
            double monthlyPayment,
            int years) {

        int numberOfPayments = years * 12;

        double totalInterest =
                (monthlyPayment * numberOfPayments) - principal;

        return totalInterest;
    }


    }


