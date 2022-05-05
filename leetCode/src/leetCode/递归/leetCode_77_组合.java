package leetCode.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 递归
 */
public class leetCode_77_组合 {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4, k = 2;

    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }

}
