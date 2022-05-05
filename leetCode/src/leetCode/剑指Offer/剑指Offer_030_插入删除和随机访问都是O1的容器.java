package leetCode.剑指Offer;

import java.util.*;

public class 剑指Offer_030_插入删除和随机访问都是O1的容器 {


    class RandomizedSet {
        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        /**
         * 初始化集合
         */
        public RandomizedSet() {
            dict = new HashMap<Integer, Integer>();
            list = new ArrayList<Integer>();
        }

        /**
         * 插入值
         */
        public boolean insert(int val) {
            if (dict.containsKey(val)) {
                return false;
            }
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        /**
         * 删除值 -- 用最后一个元素作为中间值，将删除值的位置和最后一个元素的位置调换
         * */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) {
                return false;
            }
            //最后一个元素
            int lastElement = list.get(list.size() - 1);
            //拿出map中存贮这个值
            int idx = dict.get(val);
            //交换最后一个位置的元素值和要删除的值
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            //删除最后一个元素的位置
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        /**
         * 随机值
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
