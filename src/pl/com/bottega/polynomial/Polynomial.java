package pl.com.bottega.polynomial;


import java.math.BigDecimal;

public class Polynomial {

    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;
    private BigDecimal delta;
    private BigDecimal x1;
    private BigDecimal x2;
    private BigDecimal extremumX;
    private BigDecimal extremumY;

    public Polynomial(BigDecimal a, BigDecimal b, BigDecimal c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String showFunction() {
        String signA = a.compareTo(BigDecimal.ZERO) == 1 ? "" : "- ";
        String signB = b.compareTo(BigDecimal.ZERO) == 1 ? "+ " : "- ";
        String signC = c.compareTo(BigDecimal.ZERO) == 1 ? "+ " : "- ";
        return "f(x) = " + signA + a.abs() + "x^2 " + signB + b.abs() + "x " + signC + c.abs();
    }

    public int solveFunction() {
        delta = b.pow(2).subtract((BigDecimal.valueOf(4).multiply(a).multiply(c)));
        int index = delta.compareTo(BigDecimal.ZERO);
        if (index == 1){
            x1 = b.negate().add(BigDecimal.valueOf(Math.sqrt(delta.doubleValue())))
                    .divide((BigDecimal.valueOf(2)).multiply(a), 2, 5);
            x2 = b.negate().subtract(BigDecimal.valueOf(Math.sqrt(delta.doubleValue())))
                    .divide((BigDecimal.valueOf(2)).multiply(a), 2, 5);
        }else if (index == 0)
            x1 = b.negate().divide((BigDecimal.valueOf(2)).multiply(a), 2, 5);
        extremumY = delta.negate().divide(a.multiply(BigDecimal.valueOf(4)), 2, 5);
        extremumX = b.negate().divide(a.multiply(BigDecimal.valueOf(2)), 2, 5);
        return index;
    }


    public void showResult(int index) {
        if (index > 0)
            System.out.println("miejsca zerowe x1: "+x1+", x2: "+x2);
        else if(index == 0)
            System.out.println("miejsce zerowe: "+x1);
        else System.out.println("brak miejsc zerowych");
        System.out.println("extremum X: "+extremumX);
        System.out.println("extremum Y: "+extremumY);
    }
}
