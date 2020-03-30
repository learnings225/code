package easy;

/**
 * 
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * 168. Excel Sheet Column Title
 * 
 * @author srimeda
 *
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
        	n--;
            int temp = n % 26;
            sb.append((char) (temp+65)); // http://sticksandstones.kstrom.com/appen.html
            n = n/26;
        }
        
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(25));
	}
}
