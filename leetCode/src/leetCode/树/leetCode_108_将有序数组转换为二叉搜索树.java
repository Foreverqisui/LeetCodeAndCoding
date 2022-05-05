package leetCode.树;




/**
 * 将有序数组转换为二叉搜索树
 * */
public class leetCode_108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int []nums={1,2,3,4,5,6,7};
        System.out.println(sortedArrayToBST(nums));
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode tree=new TreeNode(nums[mid]);
        tree.left=helper(nums,left,mid-1);
        tree.right=helper(nums,mid+1,right);
        return tree;
    }
}

