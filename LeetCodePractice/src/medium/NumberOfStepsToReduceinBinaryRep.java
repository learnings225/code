package medium;

/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 * 
 * https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * 
 * @author srimeda
 *
 */
public class NumberOfStepsToReduceinBinaryRep {
	
	/**
	 * Best Solution with O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int numSteps(String s) {
        int result = 0;
        int reminder = 0;
        for (int i = s.length() - 1; i > 0; --i) {
            if (s.charAt(i) - '0' + reminder == 1) {
                reminder = 1;
                result += 2;
            }
            else
                result += 1;   
        }
        return result + reminder;
    }
	
//	public static int numSteps(String s) {
//        int n = getDecimal(s);
//        System.out.println("Decimal number :: " + n);
//        int result = 0;
//        while(n != 1) {
//            if(n % 2 == 0) {
//                n = n/2;
//            } else {
//                n = n+1;
//            }
//            result++;
//        }
//        
//        return result;
//    }
    
//    public static int getDecimal(String s) {
//        int i = Integer.parseInt(s);
//        
//        int number = 0;
//        int index = 0;
//        
//        while( i > 0) {
//        	number += ( i % 10) * Math.pow(2, index++);
//        	i = i/10;
//        }
//        
//        return number;
//    }
    
	/**
	 * convert to Decimal number from Binary String without using integer class.
	 * @param args
	 */
//    public static int getDecimal(String s) {
//    	int n = s.length()-1;
//    	
//    	int number = 0;
//    	int index = 0;
//    	while(n >= 0) {
//    		int i = s.charAt(n) - '0';
//    		number += (i * Math.pow(2, index++));
//    		n--;
//    	}
//        
//        
//        return number;
//    }
	
	public static void main(String[] args) {
		System.out.println(numSteps("1101"));
//		System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
	}
}
