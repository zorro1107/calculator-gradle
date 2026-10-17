package com.example.calculator;

public final class Calculator {
    public double add(double left, double right) {
        return left + right;
    }

    public double subtract(double left, double right) {
        return left - right;
    }

    public double multiply(double left, double right) {
        return left * right;
    }

    public double divide(double left, double right) {
        if (right == 0.0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return left / right;
    }

    public double calculate(double left, String operator, double right) {
        return switch (operator) {
            case "+", "add" -> add(left, right);
            case "-", "subtract" -> subtract(left, right);
            case "*", "multiply" -> multiply(left, right);
            case "/", "divide" -> divide(left, right);
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        };
    }
}
