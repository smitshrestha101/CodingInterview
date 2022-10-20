package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderTreeTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		queue.add(root);
		int size = queue.size();
		int counter = 0;

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.pop();
			currentList.add(currentNode.val);
			counter++;

			if (currentNode.left != null)
				queue.add(currentNode.left);
			if (currentNode.right != null)
				queue.add(currentNode.right);

			if (counter == size) {
				finalList.add(currentList);
				currentList = new ArrayList<>();
				counter = 0;
				size = queue.size();
			}
		}
		return finalList;

	}
}
