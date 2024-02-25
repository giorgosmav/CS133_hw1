package hw1;

/**
 * This class is a calculator for negadecimal numbers.
 *
 * @author George Mavronicolas
 * @since 22/02/2024
 */
public class NegadecimalCalculator {

    private NegadecimalNumber n1;
    private NegadecimalNumber n2;
    private char op;
    private int decimalN1;
    private int decimalN2;

    /**
     * This is the default constructor of the class. It assigns the value 0 to n1, n2, dN1, dN2 and removes any character from op.
     */
    public NegadecimalCalculator() {
        n1.setN(0);
        n2.setN(0);
        decimalN1 = 0;
        decimalN2 = 0;
        op = ' ';
    }

    /**
     * This constructor assignes the given values of n1, n2 and op to this.n1, this.n2, this.op respectivly.
     * @param n1    The first {@link NegadecimalNumber}
     * @param n2    The second {@link NegadecimalNumber}
     * @param op    The arithmetic operator
     */
    public NegadecimalCalculator(NegadecimalNumber n1, NegadecimalNumber n2, char op){
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
        decimalN1 = n1.toPositiveBase(10);
        decimalN2 = n2.toPositiveBase(10);
    }

    /**
     * This method claculates the result of the numeric expression of the two {@link NegadecimalNumber}.
     * @return The result of the numeric expression
     */
    public NegadecimalNumber calculate(){
        if(op == '+')
            return sumOf();
        else if(op == '-')
            return diffOf();
        else if(op == '*')
            return productOf();
        return quotientOf();
    }

    /**
     * This method adds the two numbers, n1 and n2.
     * @return The sum of n1 and n2
     */
    public NegadecimalNumber sumOf(){
        return new NegadecimalNumber(Integer.parseInt(NegadecimalNumber.toNegativeBase(decimalN1 + decimalN2, -10)));
    }

    /**
     * This method subtracts n2 from n1.
     * @return The difference of n1 and n2
     */
    public NegadecimalNumber diffOf(){
        return new NegadecimalNumber(Integer.parseInt(NegadecimalNumber.toNegativeBase(decimalN1 - decimalN2, -10)));
    }

    /**
     * This method returns the product of n1 and n2.
     * @return  The product of n1 and n2
     */
    public NegadecimalNumber productOf(){
        return new NegadecimalNumber(Integer.parseInt(NegadecimalNumber.toNegativeBase(decimalN1 * decimalN2, -10)));
    }

    /**
     * This method calculates the quotend of n1 over n2.
     * @return The quotend of n1 over n2
     */
    public NegadecimalNumber quotientOf(){
        return new NegadecimalNumber(Integer.parseInt(NegadecimalNumber.toNegativeBase(decimalN1 / decimalN2, -10)));
    }
}
