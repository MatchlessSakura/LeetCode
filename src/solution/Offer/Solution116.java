package solution.Offer;

public class Solution116 {
    public int findCircleNum(int[][] isConnected) {
       boolean[] vistit = new boolean[isConnected.length];
       int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!vistit[i]){
                dfs(isConnected,vistit,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] vistit, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !vistit[j])
            {
                vistit[j] = true;
                dfs(isConnected,vistit,j);
            }
        }
    }
}
