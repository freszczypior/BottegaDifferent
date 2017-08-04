package pl.com.bottega.fraction;

import java.math.BigDecimal;

class Fraction {

    private long nominator;
    private long denominator;
    private long newNominator;
    private long newDenominator;

    Fraction(long nominator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("dzielenie przez 0? odważnie!");
        }
        this.nominator = nominator;
        this.denominator = denominator;
    }

    Fraction add(Fraction f2) {
        String sign = "+";
        newDenominator = createNewDenominator(this, f2);
        newNominator = createNewNominator(this, f2, sign);
        return new Fraction(newNominator, newDenominator);
    }

    Fraction subtract(Fraction f2) {
        String sign = "-";
        newDenominator = createNewDenominator(this, f2);
        newNominator = createNewNominator(this, f2, sign);
        return new Fraction(newNominator, newDenominator);
    }

    Fraction multiply(Fraction f2) {
        return new Fraction(this.nominator * f2.nominator, this.denominator * f2.denominator);
    }

    Fraction divide(Fraction f2) {
        return this.multiply(invers(f2));
    }

    BigDecimal toDecimalForm() {
        return (BigDecimal.valueOf(this.getNominator())).divide(BigDecimal.valueOf(this.getDenominator()), 2);
    }

    String[][] initFractionTab() {
        String integerPart = String.valueOf(this.getIntegerPart());
        String nominator = String.valueOf(this.getNominator() - this.getIntegerPart() * this.getDenominator());
        String denominator = String.valueOf(this.getDenominator());
        int tabL = nominator.length() > denominator.length() ? nominator.length() : denominator.length();

        StringBuilder stringBuilder = new StringBuilder();

        String[][] tab = new String[3][5];

        for (int i = 0; i < tab.length; i++) {
            for (int k = 0; k < tab[i].length; k++) {
                tab[i][k] = " ";
            }
        }
        for (int i = 0; i < tabL; i++) {
            stringBuilder.append("-");
        }

        tab[1][0] = this.getIntegerPart() > 0 ? integerPart : " ";
        tab[1][1] = " ";
        tab[1][2] = "-";
        tab[1][4] = "-";
        tab[0][3] = nominator;
        tab[1][3] = stringBuilder.toString();
        tab[2][3] = denominator;

        return tab;
    }

    private long createNewDenominator(Fraction f1, Fraction f2) {
        return f2.denominator * f2.denominator / lowestCommonDivisor(f1.denominator, f2.denominator);
    }

    private long createNewNominator(Fraction f1, Fraction f2, String sign) {
        switch (sign) {
            case "+":
                if (newDenominator == f1.denominator) {
                    return (f1.denominator / f2.denominator) * f2.nominator + f1.nominator;
                } else if (newDenominator == f2.denominator) {
                    return (f2.denominator / f1.denominator) * f1.nominator + f2.nominator;
                } else
                    return f1.nominator * f2.denominator + f1.denominator * f2.nominator;
            case "-":
                if (newDenominator == f1.denominator) {
                    return (f1.denominator / f2.denominator) * f2.nominator - f1.nominator;
                } else if (newDenominator == f2.denominator)
                    return (f2.denominator / f1.denominator) * f1.nominator - f2.nominator;
                else
                    return f1.nominator * f2.denominator - f1.denominator * f2.nominator;
        }
        return 0;
    }

    private Fraction invers(Fraction f) {
        return new Fraction(f.denominator, f.nominator);
    }

    private long getNominator() {
        return nominator;
    }

    private long getDenominator() {
        return denominator;
    }

    private long getIntegerPart() {
        return this.nominator / this.denominator;
    }

    private long lowestCommonDivisor(long x, long y) {
        while (x != y) {
            if (x > y) x -= y;
            else y -= x;
        }
        return x;
    }
}
