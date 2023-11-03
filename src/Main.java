import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// this is my favorite of the editorial
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> nextLevel = new ArrayDeque() {{ offer(root); }};
        ArrayDeque<TreeNode> currLevel = new ArrayDeque();
        List<Integer> rightside = new ArrayList();

        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();

            while (! currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            // The current level is finished.
            // Its last element is the rightmost one.

            rightside.add(node.val);
        }
        return rightside;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList(){{ offer(root); offer(null); }};
        TreeNode prev, curr = root;
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            while (curr != null) {
                // add child nodes in the queue
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                prev = curr;
                curr = queue.poll();
            }

            // the current level is finished
            // and prev is its rightmost element
            rightside.add(prev.val);
            // add a sentinel to mark the end
            // of the next level
            if (!queue.isEmpty())
                queue.offer(null);
        }
        return rightside;
    }
}


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                // if it's the rightmost element
                if (i == levelLength - 1) {
                    rightside.add(node.val);
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightside;
    }
}


// my attempt. the prompt was unclear. this passed 3 examples, but real cases were much differeent
// had to look at answers parially just to understand what the problem actually was
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        while(root != null){
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}