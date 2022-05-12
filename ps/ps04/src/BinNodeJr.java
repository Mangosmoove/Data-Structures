/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 9/19/2020,
 */
public class BinNodeJr <E extends Comparable<?super E>>{
    private E value;
    private BinNodeJr<E> left;
    private BinNodeJr<E> right;

    public BinNodeJr(E e) {
        value = e;
        left = right = null;
    }

    public void setLeft(BinNodeJr<E> node) {
        left = node;
    }

    public void setRight(BinNodeJr<E> node) {
        right = node;
    }

    public boolean find(E q) {
        if (q.compareTo(value) == 0) {
            return true;
        } else {
            if (left == null && right == null){
                return false;
            }
            else if (left == null && right != null){
                return right.find(q);
            }
            else if (left != null && right == null){
                return left.find(q);
            }
            else{ //had assistance with this over discord
                return left.find(q) || right.find(q);
            }
        }
    }

    public static void main(String[] argv) {
        BinNodeJr<Integer> root = new BinNodeJr<Integer>(8);
        BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(28);
        BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(38);
        BinNodeJr<Integer> node3 = new BinNodeJr<Integer>(12);
        BinNodeJr<Integer> node4 = new BinNodeJr<Integer>(5);
        BinNodeJr<Integer> node5 = new BinNodeJr<Integer>(7);
        BinNodeJr<Integer> node6 = new BinNodeJr<Integer>(50);
        BinNodeJr<Integer> node7 = new BinNodeJr<Integer>(42);
        BinNodeJr<Integer> node8 = new BinNodeJr<Integer>(30);
        BinNodeJr<Integer> node9 = new BinNodeJr<Integer>(6);
        BinNodeJr<Integer> node10 = new BinNodeJr<Integer>(14);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setLeft(node4);
        node3.setRight(node5);
        node2.setRight(node6);
        node4.setLeft(node7);
        node5.setRight(node8);
        node5.setLeft(node9);
        node7.setRight(node10);
        // find() needs to be implemented
        System.out.println("is 38 found in the tree: " + root.find(38));
        // find(39) should return true
        System.out.println("is 100 found in the tree: " + root.find(100));
        // find(100) should return false
        System.out.println("is 12 found in the tree: " + root.find(12));
        // find(12) should return true
        System.out.println("is 7 found in the tree: " + root.find(7));
        // find(7) should return true
        System.out.println("is 40 found in the tree: " + root.find(40));
        // find(40) should return false
    }
}