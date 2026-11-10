


public class Refund {

    public static void calculate(int amount) {

        int coins[]={4,3,1};

        // Greedy Method
        int count=0;
        int remaining=amount;

        for(int i=0;i<coins.length;i++) {

            count=count+remaining/coins[i];
            remaining=remaining%coins[i];
        }

        System.out.println("Greedy Method: "+count);


        // Dynamic Programming
        int dp[]=new int[amount+1];

        for(int i=0;i<=amount;i++)
            dp[i]=9999;

        dp[0]=0;

        for(int i=1;i<=amount;i++) {

            for(int j=0;j<coins.length;j++) {

                if(i>=coins[j]) {

                    if(dp[i]>dp[i-coins[j]]+1)
                        dp[i]=dp[i-coins[j]]+1;
                }
            }
        }

        System.out.println("DP Method: "+dp[amount]);
    }
}
