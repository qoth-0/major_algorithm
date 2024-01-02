import java.util.Arrays;

import static java.lang.Math.min;

public class DPCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 13;
        // 13원 만들기 - 탐욕법으로 풀면 5*2, 1*3 -> 5개 코인
        // DP는 4*2, 5*1 -> 3개
        // 12원이 되게하는 최소 동전수, 9원 동전 수, 8원 동전수 -> 3case 중 가장 작은 동전수 + 1이 답

        // 식 : f(n) = min(f(n-a) : for a in coins) + 1
        // 메모이제이션 : new int[amount+1];

        int[] arr = new int[amount+1]; // amount가 1부터 13까지일 때 경우의 수
        int answer = 0;
        arr[1] = 1;
        for(int i=2; i<=amount; i++) {
            int min = amount;
            for (int a : coins) {
                if(i-a < 0) continue;
                if(min > arr[i-a]) {
                    min = arr[i-a];
                }
            }
            arr[i] = min + 1;
        }


        System.out.println(Arrays.toString(arr)); // 0, 1, 2, 3, 1, 1, 2, 3, 2, 2, 2, 3, 3, 3

//        // DP 구현
//        static int[] temp2;
//        public static void main(String[] args) {
//            temp2 = new int[amount+1];
//            temp2[1] = 1;
//            System.out.println(dfs(13, coins));
//            System.out.println(Arrays.toString(temp2));
//        }
//
//        static int dfs(int i, int[] coins){
//            if(i==0){
//                return 0;
//            }
//            if(temp2[i] !=0){
//                return temp2[i];
//            }
//            int min = 10000;
//            for(int c : coins){
//                if(i-c<0)continue;
//                if(min > dfs(i-c, coins)){
//                    min = dfs(i-c, coins);
//                    temp2[i] = min + 1;
//                }
//            }
//            return min+1;
//        }




    }
}
