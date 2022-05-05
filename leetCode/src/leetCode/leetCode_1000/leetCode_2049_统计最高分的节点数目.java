package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 * <p>
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 * <p>
 * 请你返回有 最高得分 节点的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * example-1
 * <p>
 * 输入：parents = [-1,2,0,2,0]
 * 输出：3
 * 解释：
 * - 节点 0 的分数为：3 * 1 = 3
 * - 节点 1 的分数为：4 = 4
 * - 节点 2 的分数为：1 * 1 * 2 = 2
 * - 节点 3 的分数为：4 = 4
 * - 节点 4 的分数为：4 = 4
 * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
 */
public class leetCode_2049_统计最高分的节点数目 {


    public static void main(String[] args) {
        int[] parents = {-1, 2, 0, 2, 0};
        Solution so = new Solution();
        System.out.println(so.countHighestScoreNodes(parents));
    }


    static class Solution {
        long maxSoccer = 0;
        int cnt,n=0;
        List<Integer>[] children;
        public int countHighestScoreNodes(int[] parents) {
            //初始化步骤
            n = parents.length;
            children = new List[n];
            //主要是为了关联父节点的值 放在数组里承接
            for(int i =0;i<n;i++){
                children[i] = new ArrayList<>();
            }
            //将parents的值和children的索引进行关联
            for(int i =0;i<n;i++){
                int p = parents[i];
                //判断是否为根
                if(p!=-1){
                    children[p].add(i);
                }
            }
            //dfs深搜
            dfs(0);
            return cnt;
        }
        public int dfs(int node){
            //初始化个数 尺寸
            long soccer = 1;
            int size = n-1;
            for(int child :children[node]){
                //找到他的孩子们
                int t = dfs(child);
                //获得删掉之后孩子的值
                soccer*=t;
                //拿走删掉的值剩余的子树
                size-=t;
            }
            //判断删除之后父子树是否为空 进行乘法操作
            if(node!=0){
                soccer*=size;
            }
            //最大值判断
            if(soccer==maxSoccer){
                cnt++;
            }else if(soccer>maxSoccer){
                cnt=1;
                maxSoccer=soccer;
            }
            return n-size;
        }
    }

}
