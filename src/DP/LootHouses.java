package DP;
import java.util.*;
public class LootHouses {
	//A thief wants to loot houses. He knows the amount o
//	f money in each house. He cannot loot two consecutive houses. 
//	Find the maximum amount of money he can loot.
	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        int[] data=new int[houses.length];
        Arrays.fill(data,-1);
        return maxMoneyLooted(houses,0,data);
	}
    private static int maxMoneyLooted(int[] houses,int i,int[] data)
    {
        if(i>=houses.length) return 0;
        if(data[i]!=-1)
            return data[i];
        
        data[i]= Math.max(maxMoneyLooted(houses,i+2,data)+houses[i],maxMoneyLooted(houses,i+1,data));
        return data[i];
    }
    
    
    
    
    //DP
    public static int maxMoneyLootedDP(int[] houses) {
		//Your code goes here
        // int[] data=new int[houses.length];
        // Arrays.fill(data,-1);
        // return maxMoneyLooted(houses,0,data);
        
        int max=Integer.MIN_VALUE;
        int[] dp=houses;
        if(houses.length==0) return 0;
        if(houses.length==2)
            return Math.max(houses[0],houses[1]);
        for(int i=2;i<houses.length;i++)
        {
            int x=dp[i-2]+houses[i];
            int y=dp[i-1];
            dp[i]=Math.max(x,y);
        }
        return dp[houses.length-1];
	}

}
