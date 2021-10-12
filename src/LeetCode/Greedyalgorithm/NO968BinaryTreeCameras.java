package LeetCode.Greedyalgorithm;
/*
给定一个二叉树，我们在树的节点上安装摄像头。
节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
计算监控树的所有节点所需的最小摄像头数量。

    val
     /
  camera
  /     \
  val    val
示例 1：
输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-cameras
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO968BinaryTreeCameras {
    private int count = 0;
    static  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minCameraCover(TreeNode root) {
        if (trval(root) == 0) count++;
        return count;
    }

    private int trval(TreeNode root) {
        if (root == null) return -1;

        int left = trval(root.left);
        int right = trval(root.right);

        if (left == 0 || right == 0) {
            count++;
            return 2;
        }

        if (left == 2 || right == 2) {
            return 1;
        }

        return 0;
    }
}
