package com.iKurbanov;

public class SquareEquation {

    public static void main(String[] args) {
        //ax^2+bx+c = 7
        int rightPart = 7;
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.valueOf(args[2])-rightPart;

        double d = (b * b) - (4 * a * c);

        if (d<0) {
            System.out.println("D="+d+", вещественных корней не существует");
        } else if(a==0 && b==0){
            System.out.println("a=0 и b=0, это не квадратное уравнение");
        }else if(a==0){
            double x = (c/b);
            System.out.println("x="+x);
        } else {
            System.out.println("D="+d);

            double x1 = (Math.sqrt(d)-b) /(2*a);
            double x2 = (-Math.sqrt(d)-b) /(2*a);

            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }



    }



}
