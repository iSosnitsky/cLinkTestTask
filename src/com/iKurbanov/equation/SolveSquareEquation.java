package com.iKurbanov.equation;

public class SolveSquareEquation {




    public static void main(String[] args) {
        //ax^2+bx+c = 7
        int rightPart = 7;
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.valueOf(args[2])-rightPart;

        SquareEquation equation = new SquareEquation(a,b,c,rightPart);
        equation.solve();

    }







}
