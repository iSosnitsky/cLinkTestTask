package com.iKurbanov.equation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SolveSquareEquation {


    public static void main(String[] args) {


        int rightPart = 7;

        System.out.println("Решение уравнения формата ax^2 + bx + c = 7");
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Введите a");
            int a = reader.nextInt();
            System.out.println("Введите b");
            int b = reader.nextInt();
            System.out.println("Введите c");
            int c = reader.nextInt();

            //ax^2+bx+c = 7
            //a-b-c are passed as double, because precision in calculation matters in this case
            SquareEquation equation = new SquareEquation((double) a, (double) b, (double) c, rightPart);
            equation.solve();
        } catch (InputMismatchException e) {
            System.out.println("Введено не число, попробуйте заново");
        }



    }


}
