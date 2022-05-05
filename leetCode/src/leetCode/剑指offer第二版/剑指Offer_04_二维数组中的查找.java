package leetCode.剑指offer第二版;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 */
public class 剑指Offer_04_二维数组中的查找 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //此题要判断二维数组中是否存在目标数，逐层遍历
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        //末尾判断
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
    //二分

    class twoF{
        public  boolean findNumberIn2DArray1(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            int res = 0;
            //先遍历二维数组中的单个
            for(int [] num : matrix) {
                res = bol(num,target);
                if (res>=0){
                    return true;
                }
            }
            return false;
        }

        private int bol(int[] num,int target) {
            //二分操作 寻找目标元素
            int left = 0,right = num.length-1;
            while(left<right){
                int mid = (left+right)>>1;
                if (num[mid]==target){
                    return mid;
                }else if(num[mid]<target){
                    left=mid;
                }else{
                    right=mid-1;
                }
            }
            return -1;
        }

    }

}
