package tree;

public class MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return findDepth(root, 0);
	}

	private int findDepth(TreeNode node, int count) {
		if (node == null) {
			return count;
		}
		count++;
		return Math.max(findDepth(node.left, count), findDepth(node.right, count));

	}
}
