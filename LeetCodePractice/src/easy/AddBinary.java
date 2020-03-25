package easy;

public class AddBinary {
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int n = a.length();
        int m = b.length();
        
        int k = 0;
        if(n > m) {
            k = n-m;
            StringBuilder sb1 = new StringBuilder();
            while(k > 0) {
                sb1.append(0); k--;
            }
            sb1.append(b);
            b = sb1.toString();
        } else if(n < m) {
            k = m-n;
            StringBuilder sb1 = new StringBuilder();
            while(k > 0) {
                sb1.append(0); k--;
            }
            sb1.append(a);
            a = sb1.toString();
        }
        int i = n-1;
        int carry = 0;
        while(i >= 0) {
        	System.out.println(a.charAt(i)+ ", " + b.charAt(i) + "," + (a.charAt(i) == '1' && b.charAt(i) == '1'));
            if(a.charAt(i) == '1' && b.charAt(i) == '1') {
                sb.append(0);
                carry = 1;
            } else {
                if(carry == 1) {
                	 if(a.charAt(i) == 1 || b.charAt(i) == 1){
                		 sb.append(0);
                         carry = 1;
                	 } else {
                		 sb.append(1);
                		 carry = 0;
                	 }
                } else {
                	if(a.charAt(i) == 1 || b.charAt(i) == 1){
                		sb.append(1);
	                    carry = 0;
	               	} else {
	                    sb.append(0);
	                    carry = 0;
	               	}
                }
            }
            i--;
        }
        
//        sb.append(carry);
        
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
