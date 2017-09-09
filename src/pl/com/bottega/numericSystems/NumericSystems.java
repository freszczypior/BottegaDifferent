package pl.com.bottega.numericSystems;

public class NumericSystems {

    public static void main(String[] args) {
        System.out.println(changeFromDecimalToOther(40, 2));
        System.out.println(changeFromDecimalToOther(12, 16));
        System.out.println(changeFromDecimalToOther(15, 1));

        System.out.println(toDecimal("101000", 2));
        System.out.println(toDecimal("AA", 16));
        System.out.println(toDecimal("C", 16));

    }

    public static String changeFromDecimalToOther(int number, int base) {
        if (base > 36 || base <= 0 || number < 0)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        if (base == 1) {
            for (int i = 0; i < number; i++)
                sb.append('1');
        } else
            while (number > 0) {
                if (base < 10) {
                    sb.insert(0, number % base);
                    number /= base;
                } else {
                    int mod = number % base;
                    sb.insert(0, String.valueOf((char) ('A' + mod - 10)));
                    number /= base;
                }
            }
        return sb.toString();
    }
    public static int toDecimal(String digits, int base){
        char[] charTab = digits.toCharArray();      //wyłuskuję znaki stringa
        int result = 0;
        int power = 1;
        for (int i = 0; i < charTab.length; i++){
         char digit = charTab[charTab.length - i - 1];
         int digitDecimal = toDecimal(digit);
         result += digitDecimal * power;
         power *= base;
        }
        return result;
    }

    private static int toDecimal(char digit) {      // TODO dokończyć
        int decimalDigit;
        if (digit >= '0' || digit <= '9')
            return digit - '0';
        else if (digit >= 'A' || digit <= 'F')
            return digit - 'A' + 10;
        else
            throw new IllegalArgumentException("błędny input");
    }

    public static int changeFromOtherToDecimal(String number, int base) {
        number = number.trim();
        int size = number.length();
        int sum = 0;
        int j = 0;
        for (int i = size - 1; i >= 1; i--) {
            int temp = number.charAt(i) - '0';
            int index = (int) Math.pow(2, j);
            int digit = temp * (index);
            sum += digit;
            j++;
        }
        return sum;
}
}
