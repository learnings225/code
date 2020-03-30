package easy;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * 58. Length of Last Word
 * 
 * @author srimeda
 *
 */
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
        int count = 0;
        String temp = s.trim();
        int n = temp.length()-1;
        
        for(int i = n; i >= 0; i--){
            if(temp.charAt(i) == ' ') {
                return count;
            } 
            
            count++;
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a "));
	}
}
