package hw1;

/**
 *This class represents a negadecimal number.
 *
 * @author George Mavronicolas
 * @since 22/02/2024
 */
public class NegadecimalNumber {

    private int n;

    /**
     * This is the default constructor of the object NegadecimalNumber.
     */
    public NegadecimalNumber(){
        n = 0;
    }

    /**
     * This constructor assigns the given value to n.
     * @param n
     */
    public NegadecimalNumber(int n){
        this.n = n;
    }

    public NegadecimalNumber(NegadecimalNumber n1){
        this.n = n1.n;
    }

    /**
     * This is a getter method. It returns the value of n.
     * @return The int value of n;
     */
    public int getN(){
        return n;
    }

    /**
     * This is a method that assigns the given value to n.
     * @param n The value that will be assigned to this.n.
     */
    public void setN(int n){
        this.n = n;
    }

    /**
     * This method returns the string representation of the {@link NegadecimalNumber}.
     * @return The string representation of the {@link NegadecimalNumber}
     */
    public String toString(){
        return String.valueOf(n);
    }

    /**
     * This method converts any given number to any given negative base.
     * @param integer
     * @param base
     * @return
     */
    public static String toNegativeBase(int integer, int base) {
        String result = "";
        int number = integer;
        while (number != 0) {
            int i = number % base;
            number /= base;
            if (i < 0) {
                i += Math.abs(base);
                number++;
            }
            result = i + result;
        }
        if(result.isBlank())
            result = "0";
        return result;
    }

    /**
     * This method converts a negative base number to a positive base;
     * @param base  This is the base that the user wants to convert the number
     * @return  The negative base number in a positive base.
     */
    public int toPositiveBase(int base){
        int decimal = 0;
        int negativeBase = -base;
        String n1 = String.valueOf(n);
        int pow = n1.length()-1;
        for(int i=0;i<n1.length();i++){
            int currNum = Character.getNumericValue(n1.charAt(i));
            decimal += (int)Math.pow(negativeBase,pow--) * currNum;
        }
        return decimal;
    }
}
