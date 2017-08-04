package pl.com.bottega.fractionBatoart;



/**
 * Created by Artur_2 on 2017-06-27.
 */
public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = Fraction.create(-50, 12);
        Fraction f2 = Fraction.create(17, 74);
        Fraction sum = f1.add(f2);
        Fraction difference = f1.subtract(f2);
        Fraction multiplication = f1.multiply(f2);
        Fraction division = f1.divide(f2);
        Fraction inverse = f2.inverse();


        show(f1);

        showSternBrocot(f2);

        show(sum);

        show(difference);

        show(multiplication);

        show(division);

        showSternBrocot(inverse);

        System.out.println("test metody equals na ułamkach:\n"+f1+" i\n"+ f2+" wynik działania: "+f1.equals(f2));
        System.out.println("test metody compare na tych samych ułamkach to: "+(f1.compareTo(f2)));


        Fraction f= SternBrocotRepresentation.createFraction("L3R5L7R13");
        showSternBrocot (f);


    }


    public static void show(Fraction fraction){
        System.out.println("Ten ułamek to: "+fraction.getNumerator()+"/"+fraction.getDenominator()+".");
        System.out.println("Część całkowita tego ułamka to: "+fraction.floor()+".");
        System.out.println(fraction);
    }

    public static void showSternBrocot (Fraction fraction){
        System.out.println("Ten ułamek to: "+fraction.getNumerator()+"/"+fraction.getDenominator()+".");
        System.out.println("Część całkowita tego ułamka to: "+fraction.floor()+".");
        System.out.println(fraction);
        System.out.println("Reprezentacja tego ułamka na drzewie Sterna-Brocota to:");
        System.out.println(" w formie długiej: "+SternBrocotRepresentation.getLongSBRep(fraction)+" i w formie krótkiej: "
                +SternBrocotRepresentation.convertSBRepsLongToShort(SternBrocotRepresentation.getLongSBRep(fraction)));
    }
}