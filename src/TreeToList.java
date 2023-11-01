import common.ListNode;
import common.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TreeToList {
    public static ListNode flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        getData(set, root);
        List<ListNode> nodes = set.stream().sorted().map(ListNode::new).toList();
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    private static void getData(Set<Integer> set, TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        ListNode node = root.value;
        while (Objects.nonNull(node)) {
            set.add(node.data);
            node = node.next;
        }
        getData(set, root.left);
        getData(set, root.right);
    }
}
