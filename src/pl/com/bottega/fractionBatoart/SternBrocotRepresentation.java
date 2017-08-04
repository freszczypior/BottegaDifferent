package pl.com.bottega.fractionBatoart;

import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * Created by Artur_2 on 2017-07-07.
 * This class allows usage of Stern-Brocot representation of positive fractions
 * more about this mathematical concept may be found in here
 * https://en.wikipedia.org/wiki/Stern-Brocot_tree
 * (in polish) https://pl.wikipedia.org/wiki/Drzewo_Sterna-Brocota
 * Representation is a route to the desired fraction from the origin
 * L - means we are going to the left
 * R - we are going to the right
 */

public class SternBrocotRepresentation extends Fraction {
    //  private String shortSBRepresentation;
    private String longSBRepresentation;

    /*
    public String getLongSBRepresentation() {
        return longSBRepresentation;
    }
    public String getShortSBRepresentation() {
        return shortSBRepresentation;
    }
*/
    private static String convertSBRepsShortToLong(String input){
        StringBuilder longRep=new StringBuilder();
        int i=0;
        while (i<input.length()){
            if (input.charAt(i)=='R'||input.charAt(i)=='L'){
                longRep.append(input.charAt(i));
                i++;
            }
            else {
                int n = howManyDigits(i,input);
                int repetitionsCount=Integer.parseInt(input.substring(i,i+n));//zamienić substringa zaczynającego się od miejsca 'i', kończącego na 'i+n-1'
                longRep.append(replicateSign(input.charAt(i-1),repetitionsCount-1));//wkleić znaczek stojący na miejscu 'i-1' 'repetitions Count -1' razy (bo raz już jest wklejony jako literka)
                i+=n;
            }
        }
        return longRep.toString();
    }

    public static String getLongSBRep(Fraction f){
        long numerator=f.getNumerator();
        long denominator=f.getDenominator();
        if (numerator<=0)
            throw new IllegalArgumentException("fraction must be positive");

        StringBuilder representation=new StringBuilder();
        if (numerator==denominator)
            representation.append('1');
        while (!(numerator==denominator)) {
            if (numerator<denominator){
                representation.append('L');
                denominator=denominator-numerator;
            }
            else{
                representation.append('R');
                numerator=numerator-denominator;
            }
        }
        return representation.toString();
    }
    public static SternBrocotRepresentation createFraction (String input){
        if (!isProperRepresentation(input))
            throw new IllegalArgumentException("not a proper Stern-Brocot representation");
        if (!isLongSBRepresentation(input))
            input=convertSBRepsShortToLong(input.toUpperCase());
        long[][] matrix =new long[][]{{1, 0},{0,1}};
        for (int i = 0; i < input.length(); i++) {
            if (input.toUpperCase().charAt(i)=='R') {
                matrix[0][0] = matrix[0][1] + matrix[0][0];
                matrix[1][0] = matrix[1][0] + matrix[1][1];
            } else {
                matrix[0][1] = matrix[0][1] + matrix[0][0];
                matrix[1][1] = matrix[1][0] + matrix[1][1];
            }
        }
        long numerator = matrix[1][0]+matrix[1][1];
        long denominator = matrix[0][0]+matrix[0][1];
        return new SternBrocotRepresentation(numerator,denominator,input);
    }

    public static String convertSBRepsLongToShort(String representation){
        if(!isProperRepresentation(representation))
            throw new IllegalArgumentException("this is not a proper Stern-Brocot fraction representation");
        if(!isLongSBRepresentation(representation))
            throw new IllegalArgumentException("this is not a proper Stern-Brocot fraction representation");

        StringBuilder shortRepresentation=new StringBuilder();
        shortRepresentation.append(representation.charAt(0));
        int counter;
        int i=0;
        while (i<representation.length()) {
            counter=1;
            while ((i+counter<representation.length()) && (representation.charAt(i+counter-1) == representation.charAt(i+counter)) ) {
                counter++;
            }
            i=i+counter;
            if (counter>1)
                shortRepresentation.append(counter);
            if (i< representation.length())
                shortRepresentation.append(representation.charAt(i));
        }
        return shortRepresentation.toString();
    }

    private static boolean isProperRepresentation(String input){
        String regex="[LR]+[LR\\d]*";
        return Pattern.matches(regex, input.toUpperCase());
    }

    private static boolean isLongSBRepresentation(String input){
        String regex="[LR]+";
        return Pattern.matches(regex, input.toUpperCase());
    }

    private SternBrocotRepresentation(long numerator, long denominator, String longSBRepresentation){
        super(numerator,denominator);
        this.longSBRepresentation =longSBRepresentation;
    }

    private static int howManyDigits(int start, String string) {
        int counter=0;
        if (isDigit(string.charAt(start+counter)))
            counter++;
        return counter;
    }
}