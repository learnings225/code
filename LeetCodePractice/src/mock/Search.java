package mock;

public class Search {
	public boolean search(int[] a, int target) {

		if (a == null || a.length == 0) {
			return false;
		}

		if (a.length == 1 && a[0] == target) {
			return true;
		}

		if (a.length == 2 && (a[0] == target || a[1] == target)) {
			return true;
		}

		for (int i = 0; i < a.length - 1;) {
			if (a[i] < a[i + 1] && a[i] > target) {
				i++;
			} else if (a[i] == target && a[i + 1] >= target) {
				return true;
			} else if (a[i] > a[i + 1] && a[i + 1] == target) {
				i++;
			} else {
				return false;
			}
		}

		return false;
	}

	public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        int maxNum = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] * 2 > maxNum && i != maxIndex) {
                return -1;
            }
        }
        
        return maxIndex;
    }
	
	public int[] plusOne(int[] digits) {
        int[] result;
        int resultIndex = 0;
        int n = digits.length;
        
        boolean addnSpace = true;
        
        for(int i: digits) {
        	if(i != 9) {
        		addnSpace = false;
        		break;
        	}
        }
        
        if(addnSpace) {
            result = new int[digits.length + 1];
            resultIndex = 1;
        } else {
            result = new int[digits.length];
        }
        
        int carry = 1;
        
        
        for(int i = n - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            if(temp >= 10 && carry > 0) {
                int div = temp % 10;
                carry = temp / 10;
                
                result[i+resultIndex] = div;
            } else {
                result[i+resultIndex] = temp;
                carry = 0;
            }
        }
        
        if(carry != 0) {
        	result[0] = carry;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Search s = new Search();

		int a[] = { 1, 2, 3 };
		int target = 3;

		System.out.println(s.search(a, target));
		
		int x[] = {0, 0, 0, 2};
		s.dominantIndex(x);
		
		int a1[] = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(s.plusOne(a1));
	}
}
