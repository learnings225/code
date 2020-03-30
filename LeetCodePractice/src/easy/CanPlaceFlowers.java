package easy;

/**
 * https://leetcode.com/problems/can-place-flowers/
 * 
 * 605. Can Place Flowers
 * 
 * @author srimeda
 *
 */
public class CanPlaceFlowers {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while(i < flowerbed.length) {
            if(flowerbed[i] == 0 
               && (i == 0 || flowerbed[i-1] == 0) 
               && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            
            i++;
        }
        
        return count >= n;
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		System.out.println(canPlaceFlowers(flowerbed, 1));
		
		int[] flowerbed1 = {1,0,0,0,0,1};
		System.out.println(canPlaceFlowers(flowerbed1, 2));
	}
}
