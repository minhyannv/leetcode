import java.util.HashSet;
import java.util.Set;


public class Q121 {

  /*  public int maxProfit(int[] prices) {  //超出时间限制
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) { // 买入价格大于卖出价格，跳过
                    continue;
                }
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }*/

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; //最低价格
        int maxProfix = 0; //最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfix) { // 如果当前买入股票利润高于最大利润，则当前买入
                maxProfix = prices[i] - minPrice;
            }
        }
        return maxProfix;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Q121 q121 = new Q121();
        int ans = q121.maxProfit(prices);
        System.out.println(ans);
    }
}


