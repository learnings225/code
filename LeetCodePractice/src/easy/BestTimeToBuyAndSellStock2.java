package easy;

public class BestTimeToBuyAndSellStock2 {
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                profit+= prices[i+1]-prices[i];
            }
        }
        
        return profit;
    }
	
	public static void main(String[] args) {
//		int[] prices = {7,1,5,3,6,4};
//		int[] prices = {1,2,3,4,5};
		int[] prices = {7,6,4,3,1};
		
		System.out.println(maxProfit(prices));
	}
}
