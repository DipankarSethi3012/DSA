/*You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich". */

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> st = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            String s = recipes[i];
            for(String temp : ingredients.get(i)) {
                if(!st.contains(temp)) {
                    adj.putIfAbsent(temp, new ArrayList<>());
                    adj.get(temp).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<String> res = new ArrayList<>();
      
        while(!q.isEmpty()) {
            int i = q.poll();
            String s = recipes[i];
            res.add(s);

            if(adj.containsKey(s)) {
                List<Integer> li = adj.get(s);
                for(int j : li) {
                    if(--indegree[j] == 0) {
                        q.add(j);
                    }
                }
            }
        }
        return res;

    }
}