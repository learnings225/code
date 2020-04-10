package easy;

public class GenerateTheString {
	public static String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		if (n % 2 == 0) {
			int i = 1;
			while (i < n) {
				sb.append("a");
				i++;
			}
			sb.append("b");
		} else {
			while (n > 0) {
				if (n == 1) {
					sb.append("c");
					n--;
				} else if (n == 2) {
					sb.append("d");
					n--;
				} else {
					for (int i = 0; i < n - 2; i++) {
						sb.append("e");
					}
					n = 2;
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(generateTheString(7)); 
//		int a = 2, b = 1, c = 4;
//		char min = (Math.min(a, b) == a ? (Math.min(a, c) == a ? 'a' : 'c') : (Math.min(b, c) == b ? 'b' : 'c'));
//		System.out.println(min);
	}
}
