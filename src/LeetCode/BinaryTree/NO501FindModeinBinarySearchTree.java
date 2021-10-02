package LeetCode.BinaryTree;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
假定 BST 有如下定义：

    结点左子树中所含结点的值小于等于当前结点的值
    结点右子树中所含结点的值大于等于当前结点的值
    左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],
   1
    \
     2
    /
   2
返回[2].
提示：如果众数超过1个，不需考虑输出顺序
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO501FindModeinBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode pre;
    int count=0;
    int MaxCount=0;
    List<Integer> list=new ArrayList<>();

    int index=0;
    public int[] findMode(TreeNode root) {
        if(root==null)return new int[]{};
        Find(root);
        int[] d = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            d[i] = list.get(i);
        }
        return d;
    }

    private void Find(TreeNode root) {
        if(root==null)return;
        Find(root.left);
        if(pre!=null&&pre.val==root.val)++count;
        else count=1;
        pre=root;
        if(count==MaxCount)list.add(root.val);
        else if(count>MaxCount){
            list.clear();
            list.add(root.val);
            MaxCount=count;
        }
        Find(root.right);
    }
    private void Find_review(TreeNode root){
        if(root==null)return;
        Find_review(root.left);
        if(pre!=null){
            if(pre.val==root.val)++count;
        }
        else count=1;
        if(count==MaxCount)list.add(root.val);
        else if(count>MaxCount){
            list.clear();
            MaxCount=count;
            list.add(root.val);
        }
        pre=root;
        Find_review(root.right);
    }
}
