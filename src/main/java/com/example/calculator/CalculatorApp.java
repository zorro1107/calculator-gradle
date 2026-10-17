package com.example.calculator;

public final class CalculatorApp {
    private CalculatorApp() {
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            printUsage();
            return;
        }

        try {
            double left = Double.parseDouble(args[0]);
            String operator = args[1];
            double right = Double.parseDouble(args[2]);
            double result = new Calculator().calculate(left, operator, right);
            System.out.printf("%s %s %s = %s%n", args[0], operator, args[2], format(result));
        } catch (NumberFormatException exception) {
            System.err.println("Both operands must be valid numbers.");
            printUsage();
            System.exit(2);
        } catch (IllegalArgumentException exception) {
            System.err.println("Error: " + exception.getMessage());
            System.exit(2);
        }
    }

    private static String format(double value) {
        if (value == Math.rint(value)) {
            return Long.toString((long) value);
        }
        return Double.toString(value);
    }

    private static void printUsage() {
        System.out.println("Gradle Calculator");
        System.out.println("Usage: java -jar calculator-gradle-1.0.0.jar <number> <operator> <number>");
        System.out.println("Operators: +, -, *, / (or add, subtract, multiply, divide)");
        System.out.println("Example: java -jar calculator-gradle-1.0.0.jar 12 multiply 4");
    }
}
