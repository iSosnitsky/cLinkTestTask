package com.iKurbanov.equation;

class SquareEquation {
    private final Double a;
    private final Double b;
    private final Double c;

    SquareEquation(Double a, Double b, Double c, Integer rightPart) {
        this.a = a;
        this.b = b;

        //If right part isn't 0, it could be moved right away.
        this.c = c-rightPart;
    }

    void solve(){
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
