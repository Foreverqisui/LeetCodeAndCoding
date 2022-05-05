package leetCode.bfs;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列
 * 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * <p>
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 */
public class leetCode_127_单词接龙 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        Solution sol = new Solution();
        System.out.println(sol.ladderLength(beginWord, endWord, wordList));
    }

    static class Solution {
        String s, e;
        Set<String> set = new HashSet<String>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            s = beginWord;
            e = endWord;
            //遍历 字典放入集合
            set.addAll(wordList);
            //如果集合里面没有 目标值
            if (!set.contains(e)) {
                return 0;
            }
            //结果 进行bfs
            int res = bfs();
            return res == -1 ? 0 : res + 1;
        }

        private int bfs() {
            //双向bfs
            //d1:正向bfs d2:反向bfs
            Deque<String> d1 = new LinkedList<>();
            Deque<String> d2 = new LinkedList<>();
            //借助map记录旋转次数
            Map<String, Integer> m1 = new HashMap<>();
            Map<String, Integer> m2 = new HashMap<>();
            /*
             * m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
             * e.g.
             * m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
             * m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
             */
            d1.add(s);
            m1.put(s, 0);
            d2.add(e);
            m2.put(e, 0);
            /*
             * 只有两个队列都不空，才有必要继续往下搜索
             * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
             * e.g.
             * 例如，如果 d1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
             */
            while (!d1.isEmpty() && !d2.isEmpty()) {
                int t = -1;
                if (d1.size() <= d2.size()) {
                    t = update(d1, m1, m2);
                } else {
                    t = update(d2, m2, m1);
                }
                if (t != -1) {
                    return t;
                }
            }
            return -1;
        }

        private int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
            int m = deque.size();
            while (m-- > 0) {
                // 获取当前需要扩展的原字符串
                String poll = deque.pollFirst();
                int n = poll.length();

                // 枚举替换原字符串的哪个字符 i
                for (int i = 0; i < n; i++) {
                    // 枚举将 i 替换成哪个小写字母
                    for (int j = 0; j < 26; j++) {
                        // 替换后的字符串
                        String sub = poll.substring(0, i) + (char) ('a' + j) + poll.substring(i + 1);
                        if (set.contains(sub)) {
                            // 如果该字符串在「当前方向」被记录过（拓展过），跳过即可
                            if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) {
                                continue;
                            }

                            // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                            if (other.containsKey(sub)) {
                                return cur.get(poll) + 1 + other.get(sub);
                            } else {
                                // 否则加入 deque 队列
                                deque.addLast(sub);
                                cur.put(sub, cur.get(poll) + 1);
                            }
                        }
                    }
                }
            }
            return -1;
        }
        }
    }
