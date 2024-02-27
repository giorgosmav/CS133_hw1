package hw1;

/**
 * This class is a test for the class {@link NegadecimalCalculator}.
 *
 * @author George Mavronicolas
 * @since 22/02/2024
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestNegadecimalCalculator {

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        try{
            File fIn = new File ("input.txt");
            Scanner in = new Scanner (fIn);
            String line;
            while(in.hasNextLine()){
                line = "";
                line += in.nextLine();
                if(!isValid(line))
                    System.out.println(line + " This is an invalid numeric expression.");
                else if(checkSecondNum(line))
                    System.out.println(line + " Can't divide by 0");
                else
                    calculate(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("The input file was not found!");
        }
    }

    /**
     * This method returns true if the second number is 0.
     * @param line  The given numeric expression
     * @return  True if it's 0
     */
    public static boolean checkSecondNum(String line){
        if(line.charAt(line.length()-1) == '0' && line.charAt(line.length()-2) == ' ')
            return true;
        return false;
    }

    /**
     * This method calculates the result of the given numeric expression and displays it to the user.
     * @param line  The given numeric expression
     */
    public static void calculate(String line){
        StringTokenizer tok = new StringTokenizer(line);
        NegadecimalNumber n1 = new NegadecimalNumber(Integer.parseInt(tok.nextToken()));
        char op = tok.nextToken().charAt(0);
        NegadecimalNumber n2 = new NegadecimalNumber(Integer.parseInt(tok.nextToken()));
        NegadecimalCalculator calc = new NegadecimalCalculator(n1,n2,op);
        NegadecimalNumber result = new NegadecimalNumber(calc.calculate());
        System.out.println(line + " = " + result);
    }

    /**
     * This method checks if the given numeric expression is valid.
     * @param line  The given numeric expression
     * @return  False if it's invalid
     */
    public static boolean isValid(String line) {
        StringTokenizer tok = new StringTokenizer(line, " ");
        if (tok.countTokens() != 3)
            return false;

        String sN1 = tok.nextToken();
        if (!isInteger(sN1))
            return false;

        String exp = tok.nextToken();
        if(exp.length() > 1)
            return false;
        char op = exp.charAt(0);
        if(!checkOp(op))
            return false;

        String sN2 = tok.nextToken();
        if (!isInteger(sN2))
            return false;

        return true;
    }

    /**
     * This method checks if the given operator is valid.
     * @param op The given operator
     * @return  True if the given operator is valid
     */
    private static boolean checkOp(char op){
        if(op == '+' || op == '-' || op == '*' || op == '/')
            return true;
        return false;
    }

    /**
     * This method checks if a given string value is an integer number.
     * @param s The given string
     * @return  True if it's an integer
     */
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    /**
     * This method checks if a given string value is an integer number.
     * @param s The given string
     * @param radix The base of the integer
     * @return  True if the given string's value is an integer
     */
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty())
            return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1)
                    return false;
                else
                    continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0)
                return false;
        }
        return true;
    }

}
