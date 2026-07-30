package month202607.week5.day29;


import java.util.*;

public class L133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Node node = (Node) object;
            return val == node.val && Objects.equals(neighbors, node.neighbors);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, neighbors);
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.offer(node);
        HashMap<Node,Node> nodeToCopy = new HashMap<>();
        // 构造好节点和复制节点的对应关系并复制值
        while (!nodes.isEmpty()){
            Node t = nodes.pop();
            if(!nodeToCopy.containsKey(t)){
                nodeToCopy.put(t,new Node(t.val));
            }
            for (Node neighbor : t.neighbors) {
                if(!nodeToCopy.containsKey(neighbor)){
                    nodes.offer(neighbor);
                }
            }
        }

        // 复制邻边
        for (Map.Entry<Node, Node> nodeNodeEntry : nodeToCopy.entrySet()) {
            Node key = nodeNodeEntry.getKey();
            Node value = nodeNodeEntry.getValue();
            for (Node neighbor : key.neighbors) {
                value .neighbors.add(nodeToCopy.get(neighbor));
            }
        }
        return nodeToCopy.get(node);
    }
}
