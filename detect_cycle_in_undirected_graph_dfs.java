class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        boolean vis[] = new boolean[V+1];
        boolean dfs[] = new boolean[V+1];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
                if(solve(i,vis,dfs,adj))
                {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    boolean solve(int i,boolean vis[],boolean dfs[],ArrayList<ArrayList<Integer>> adj)
    {
        vis[i] = true;
        dfs[i] = true;
        
        for(Integer j:adj.get(i))
        {
            if(vis[j]==false)
            {
                if(solve(j,vis,dfs,adj))
                {
                    return true;
                }
            }
            else if(dfs[j]==true)
            {
                return true;
            }
        }
        
        dfs[i] = false;
        
        return false;
        
    }
}
