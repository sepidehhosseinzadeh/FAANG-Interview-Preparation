import java.util.*;

public class serializeBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "X,";

            String left = serialize(root.left);
            String right = serialize(root.right);

            return root.val + "," + left + right;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(data.split(",")));
            return deserial(q);
        }

        public TreeNode deserial(Queue<String> q)
        {
            String cur = q.remove();
            if (cur.equals("X")) return null;

            TreeNode at = new TreeNode(Integer.valueOf(cur));
            at.left = deserial(q);
            at.right = deserial(q);

            return at;
        }
    }

    public class Codec_v1 {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    res.append("n ");
                    continue;
                }
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));