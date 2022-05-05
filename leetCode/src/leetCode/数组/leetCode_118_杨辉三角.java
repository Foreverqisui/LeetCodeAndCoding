package leetCode.数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode_118_杨辉三角 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(generate(n));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <i+1; j++) {
                if (j==i||j==0){
                    row.add(1);
                }else {
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }

            }
            ret.add(row);
        }
        return ret;
    }
}
