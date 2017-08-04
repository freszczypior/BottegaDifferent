package pl.com.bottega.polynomial;


import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PolynomialApp {

    private static BigDecimal a;
    private static BigDecimal b;
    private static BigDecimal c;

    public static void main(String[] args) {

        while (true) {
            try {
                a = readParam("a");
                if (a.equals(BigDecimal.ZERO))
                    continue;
                b = readParam("b");
                c = readParam("c");
            }catch (InputMismatchException exc) {
                System.out.println("nie wprowadzono liczby");
            continue;
            }
            Polynomial poly = new Polynomial(a, b, c);

            System.out.println(poly.showFunction());

            poly.showResult(poly.solveFunction());

        }
    }

    private static BigDecimal readParam(String param) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj parametr " + param + ": ");
        return scanner.nextBigDecimal();
    }
}
