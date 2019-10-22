package com.example.calculateapp;
import org.mariuszgromada.math.mxparser.Expression;

public class Calculator {
    //
    public static double calculate(String expr) {
        Expression expression = new Expression(expr);
        return expression.calculate();
    }
}

