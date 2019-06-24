package xin.jerome.study.datastructures.tree;

/**
 * 测试自定义树的功能性
 *
 * @author Jerome Zhu
 * @since 2019.06.05 15:23
 */
public class TestTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            binarySearchTree.add(num);

        binarySearchTree.inOrder();
        System.out.println();
//        System.out.println(String.format("minElement:%d,maxElement:%d.", binarySearchTree.minElement()
//                , binarySearchTree.maxElement()));
//        System.out.println(binarySearchTree.removeMinElement());
//        System.out.println(binarySearchTree.removeMaxElement());
//        System.out.println(String.format("minElement:%d,maxElement:%d.", binarySearchTree.minElement()
//                , binarySearchTree.maxElement()));
        binarySearchTree.removeElement(3);
        binarySearchTree.inOrder();
        System.out.println();
//        binarySearchTree.levelOrder();
//        System.out.println();
//        binarySearchTree.inOrder();
//        System.out.println();
//        binarySearchTree.postOrder();
//        System.out.println();
    }


}
