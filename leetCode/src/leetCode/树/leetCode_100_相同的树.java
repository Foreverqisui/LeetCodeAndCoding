package leetCode.树;



/**
 * 相同的树
 */
public class leetCode_100_相同的树 {

    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p==null&&q!=null){
            return false;
        }
        if (p.val==q.val){
            return true;
        }
        return isSameTree(q.left,p.left)&&isSameTree(q.right,p.right);
    }
}