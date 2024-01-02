import java.util.Arrays;

public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 99;
        int answer = 0;
//        최소 동전의 개수
        Arrays.sort(coins);
        for(int i=coins.length-1; i>=0; i--) {
            int max = coins[i];
            answer += amount / max;
            amount = amount % max;
        }
        System.out.println(answer);
    }
}
