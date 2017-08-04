package pl.com.bottega.fraction;


public class FractionTest {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(1, 3);
        Fraction sum = f1.add(f2);
        Fraction subtract = f1.subtract(f2);
        Fraction multiply = f1.multiply(f2);
        Fraction divide = f1.divide(f2);

        System.out.println(divide.toDecimalForm());

        String[][] tab = divide.initFractionTab();
        for (int i = 0; i < tab.length; i++) {
            for (int k = 0; k < tab[i].length; k++) {
                System.out.print(tab[i][k]);
            }
            System.out.println();
        }

    }

}
