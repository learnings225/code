package easy;

/**
 * 
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * 171. Excel Sheet Column Number
 * 
 * @author srimeda
 *
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
        int value = 0;
        int index = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            value += (int)Math.pow(10, index) * ((int)s.charAt(i) - 64);
            index++;
        }
        
        return value + 1;
    }
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AA"));
		System.out.println(titleToNumber("Y"));
	}
}
