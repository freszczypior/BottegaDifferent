package pl.com.bottega.fractionBatoart;

import java.util.Arrays;

import static java.lang.String.valueOf;

/**
 * Created by Artur_2 on 2017-06-27.
 */
public class Fraction implements Comparable<Fraction>{
    private final long numerator;
    private final long denominator;


    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    /**
     * constructor is protected to assure proper use of objects of this class.
     * There is a public static method construct to which returns proper objects
     * it checks if denominator is not 0 and represents fractions in irreducible form.
     *
     */

    protected Fraction(){
        this.numerator=1;
        this.denominator=1;
    }

    protected Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction create(long numerator, long denominator){
        if (denominator==0)
            throw new IllegalArgumentException("denominator can not be 0");
        long gcd=greatestCommonDivisor(Math.abs(numerator),Math.abs(denominator));
        if (denominator<0){
            denominator=-denominator;
            numerator=-numerator;
        }
        return new Fraction(numerator/gcd, denominator/gcd);
    }

    public Fraction add(Fraction addend) {
        return Fraction.create(this.numerator * addend.denominator + this.denominator * addend.numerator,
                this.denominator * addend.denominator);
    }

    public Fraction subtract(Fraction subtrahend) {
        return Fraction.create(this.numerator * subtrahend.denominator - this.denominator * subtrahend.numerator,
                this.denominator * subtrahend.denominator);
    }

    public Fraction multiply(Fraction multiplier) {
        return Fraction.create(this.numerator * multiplier.numerator,
                this.denominator * multiplier.denominator);
    }

    public Fraction divide(Fraction divisor) {
        if (divisor.numerator==0) {
            throw new IllegalArgumentException("can not divide by zero");
        }
        return Fraction.create(numerator*divisor.denominator, denominator*divisor.numerator);
    }

    public Fraction inverse() {
        if (numerator == 0)
            throw new IllegalArgumentException("there is no inverse for 0");
        return Fraction.create(denominator, numerator);
    }

    /**
     * @return returns the greatest integer which is not greater than the fraction.
     */

    public long floor() {
        if (numerator < 0 && !(numerator % denominator == 0))
            return numerator / denominator - 1;
        else
            return numerator / denominator;
    }

    public long getIntegerPart(){
        return numerator/denominator;
    }

    public Boolean equals (Fraction f) {
        return ((numerator * f.denominator - denominator * f.numerator)==0);
    }

    public String toString(){

        if (numerator==0)
            return "0";

        char sign=(numerator >0)?' ':'-';

        if (denominator==1)
            return sign+" "+Math.abs(numerator);

        int denominatorLength = valueOf(denominator).length();
        long remainderNumerator=(Math.abs(numerator)-denominator*Math.abs(this.getIntegerPart()));

        String integerPart=(this.getIntegerPart()==0)?"":valueOf(Math.abs(this.getIntegerPart()));
        String middleLine = sign+" "+integerPart+" "+replicateSign('-',denominatorLength+2);

        int skipLength=middleLine.length()-denominatorLength-1;
        String bottomLine = replicateSign(' ',skipLength)+denominator;

        skipLength+=(denominatorLength+1-valueOf(remainderNumerator).length())/2;

        String topLine =replicateSign(' ', skipLength)+remainderNumerator;
        return topLine+"\n"+middleLine+"\n"+bottomLine;
    }

    @Override
    public int compareTo(Fraction o) {
        return (int) (numerator*o.denominator-o.numerator*denominator);
    }

    private Fraction reduceFraction(){
        long gcd=greatestCommonDivisor(numerator, denominator);
        return Fraction.create(numerator/gcd,denominator/gcd);
    }

    protected static String replicateSign(char c, int times){
        char[] charArray = new char[times];
        Arrays.fill(charArray, c);
        return new String(charArray);
    }

    private static long greatestCommonDivisor(long a, long b) { return b==0 ? a : greatestCommonDivisor(b,a%b); }
}