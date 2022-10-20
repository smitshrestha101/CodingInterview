package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightSideViewBinaryTree {

	public List<Integer> rightSideViewBFS(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> finaList = new ArrayList<>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int sizeOfLevel = queue.size();
		int counter = 0;

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.pop();
			counter++;

			if (currentNode.left != null)
				queue.add(currentNode.left);
			if (currentNode.right != null)
				queue.add(currentNode.right);

			if (counter == sizeOfLevel) {
				finaList.add(currentNode.val);
				counter = 0;
				sizeOfLevel = queue.size();
			}
		}

		return finaList;
	}

	public List<Integer> rightSideViewDFS(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<Integer> finalList = new ArrayList<>();

		useDFSPreOrder(root, finalList, 0);
		return finalList;
	}

	private void useDFSPreOrder(TreeNode node, List<Integer> finalList, int level) {
		if (level >= finalList.size())
			finalList.add(node.val);
		if (node.right != null)
			useDFSPreOrder(node.right, finalList, level + 1);
		if (node.left != null)
			useDFSPreOrder(node.left, finalList, level + 1);
	}
}
