package xin.jerome.study.datastructures.leetcode;

/**
 * 树节点的定义
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 使用数组作为参数，创建一个二叉树
     *
     * @param arr 数组参数
     */
    public TreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Arr can not be empty.");
        this.val = arr[0];
        this.left = createBinaryTreeByArray(arr, 1);
        this.right = createBinaryTreeByArray(arr, 2);
    }

    /**
     * 使用数组作为参数，创建一个二叉树
     *
     * @param array 数组参数
     * @param index 数组的 index
     * @return 以index位置的元素为根节点的二叉树
     */
    private TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    /**
     * 指定节点树的前序遍历(递归实现)
     */
    private void recursivePreOrder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.val + ",");
        recursivePreOrder(node.left, sb);
        recursivePreOrder(node.right, sb);
    }

    /**
     * 指定节点树的中序遍历(递归实现)
     */
    private void recursiveInOrder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        recursiveInOrder(node.left, sb);
        sb.append(node.val + ",");
        recursiveInOrder(node.right, sb);
    }

    /**
     * 指定节点树的后序遍历(递归实现)
     */
    private void recursivePostOrder(TreeNode node, StringBuilder sb) {

        if (node == null)
            return;

        recursivePostOrder(node.left, sb);
        recursivePostOrder(node.right, sb);
        sb.append(node.val + ",");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("root:" + this.val + "; 前序遍历:{");
        recursivePreOrder(this, sb);
        sb.deleteCharAt(sb.length() - 1).append("};");
        sb.append(" 中序遍历:{");
        recursiveInOrder(this, sb);
        sb.deleteCharAt(sb.length() - 1).append("};");
        sb.append(" 后序遍历:{");
        recursivePostOrder(this, sb);
        sb.deleteCharAt(sb.length() - 1).append("}.");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2};
        TreeNode treeNode = new TreeNode(arr);
        System.out.println(treeNode);
    }
}
