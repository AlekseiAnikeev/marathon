package day18;

public class Task3 {
    public static void main(String[] args) {
        Node root = new Node(20);
        Node root2 = new Node(20);
        int[] numbers = {14, 11, 23, 22, 27, 24, 150, 16, 15, 18, 5, 8};
        int[] numbers2 = {55, 22, 235, 66, 2, 1, 33, 2136, 3534, 222, 324235, 223, 1233, 1, 5532, 66, 97, 7, 55, 46, 0, 98, 55, 66};
        System.out.println("Первое древо: ");
        for (int number : numbers){
            addNewNode(number, root);
        }
        dfs(root);
        System.out.println();
        System.out.println("Второе древо: ");
        for (int number : numbers2) {
            addNewNode(number, root2);
        }
        dfs(root2);
        System.out.println();
    }

    public static void addNewNode(int number, Node root) {
        Node newNode = root;
        Node node = null;

        while (newNode != null) {
            node = newNode;
            if (number >= node.getValue()) newNode = node.getRight();
            else newNode = node.getLeft();
        }

        if (node != null) {
            if (number >= node.getValue()) node.setRight(new Node(number));
            else node.setLeft(new Node(number));
        }
    }

    public static void dfs(Node root) {
        if (root == null) return;
        dfs(root.getLeft());
        System.out.print(root.getValue() + " ");
        dfs(root.getRight());
    }
}