package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。
 * 你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class 剑指Offer_087_复原IP {
    public static void main(String[] args) {
        String s = "25525511135";
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses(s));
    }

    static class Solution {
        //ip地址长度 限制为4
        static final int SEG_COUNT = 4;
        //结果
        List<String> res = new ArrayList<String>();
        //中间结果
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            segments = new int[SEG_COUNT];
            dfs(s, 0, 0);
            return res;
        }

        private void dfs(String s, int segId, int segStart) {
            //递归终止-- 满足ip长度为4
            if (segId == SEG_COUNT) {
                //长度和目标相等
                if (segStart == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < SEG_COUNT; i++) {
                        sb.append(segments[i]);
                        if (i != SEG_COUNT - 1) {
                            sb.append(".");
                        }
                    }
                    res.add(sb.toString());
                }
                return;
            }
            //如果到了结果长度，还没找到ip，则结束回溯
            if (segStart == s.length()) {
                return;
            }
            //如果第一个为0，--不符合要求，直接向下走
            if (s.charAt(segStart) == '0') {
                //全部至为0
                segments[segStart] = 0;
                //向下走
                dfs(s, segId + 1, segStart + 1);
            }
            //枚举每一种可能 向下递归
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                //符合要求0~255
                if (addr > 0 && addr <= 0xFF) {
                    segments[segId] = addr;
                    dfs(s, segId + 1, segEnd + 1);
                } else {
                    break;
                }
            }
        }
    }
}
