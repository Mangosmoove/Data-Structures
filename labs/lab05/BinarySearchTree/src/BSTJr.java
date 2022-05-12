/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 9/26/2020, 4:23p.m.
 */


public class BSTJr <K extends Comparable<?super K>> {
    BinNode<K> root;
    BinNode<K> curr;

    // TODO for C343/Fall 2020 - Lab 05 part A
    // "unbalanced" is used for balance checking:
    //    if a node is unbalanced, the tree will be unbalanced
    BinNode<K> unbalanced = null;

    public BSTJr() {
        root = null;
        curr = null;
    }
    public void build(K[] ks) {
        for (int i = 0; i < ks.length; i ++)
            insert(ks[i]);
    }
    public void insert(K k) {
        BinNode<K> t = new BinNode<K>(k);
        if (root == null) {
            root = curr = t;
        } else {
            curr = search(root, k);
            if (k.compareTo(curr.getKey()) < 0)
                curr.setLeft(t);
            else
                curr.setRight(t);
        }
    }
    public BinNode<K> search(BinNode<K> entry, K k) {
        if (entry == null)
            return null;
        else {
            entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
            if (entry.isLeaf())
                return entry;
            if (k.compareTo(entry.getKey()) < 0) {
                /*  bug in original version: if (k.compareTo(curr.getKey()) < 0) {  */
                if (entry.getLeft() != null)
                    return search(entry.getLeft(), k);
                else
                    return entry;
            } else {
                if (entry.getRight() != null)
                    return search(entry.getRight(), k);
                else
                    return entry;
            }
        }
    }
    public void display() {
        if (root == null)
            return;
        System.out.println("Preorder enumeration: key(size-of-the-subtree)");
        preorder(root);
        System.out.println();
        System.out.println("Postorder");
        postOrder(root);
        System.out.println();
        System.out.println("Inorder");
        inOrder(root);
        System.out.println();
    }
    public void preorder(BinNode<K> entry) {
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if (entry.getLeft() != null)
            preorder(entry.getLeft());
        if (entry.getRight() != null)
            preorder(entry.getRight());
    }

    public void postOrder(BinNode<K> entry){
        if(entry.getLeft() != null){
            postOrder(entry.getLeft());
        }
        if(entry.getRight() != null){
            postOrder(entry.getRight());
        }
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
    }

    public void inOrder(BinNode<K> entry){
        if(entry.getLeft() != null){
            inOrder(entry.getLeft());
        }
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if(entry.getRight() != null){
            inOrder(entry.getRight());
        }
    }

    // TODO for C343/Fall 2020 - Lab 05 part A
    // implement checkBalance(),
    //   and you may write treeHeight(node) as helper function

    public boolean checkBalance(BinNode<K> entry){
        boolean bal = true;
        if(entry.isLeaf()){
            bal = true;}
        else{
            if(entry.getLeft() != null && entry.getRight() != null){
                if(entry.getLeft().getSize() - entry.getRight().getSize() <= 1) {
                    if(entry.getLeft().isLeaf())
                        checkBalance(entry.getLeft());
                    if(entry.getRight().isLeaf())
                        checkBalance(entry.getRight());
                }
                else{
                    bal = false;
                    return bal;
                }
            }
            else if (entry.getLeft() != null && entry.getRight() == null){
                if(entry.getLeft().isLeaf()){
                    checkBalance(entry.getLeft());
                }
                else{
                    bal = false;
                    return bal;
                }
            }
            else if (entry.getLeft() == null && entry.getRight() != null){
                if (entry.getRight().isLeaf()){
                    checkBalance(entry.getRight());
                }
                else{
                    bal = false;
                    return bal;
                }
            }
        }
        return bal;
    }

    //runs but doesn't print right output
    public void findKthSmallest(int k, BinNode<K> entry, int counter){
        if(entry.getLeft() != null && entry.getRight() != null){
            if (entry.getLeft().getSize() == k){
                System.out.println(entry.getKey());
            }
            else{
                if (entry.getLeft().getSize() > k){
                    findKthSmallest(k, entry.getLeft(), counter);
                }
                else if (entry.getLeft().getSize() < k){
                    findKthSmallest(k - entry.getLeft().getSize(), entry.getRight(), counter + entry.getLeft().getSize());
                }
            }
        }
        else if (entry.getLeft() != null && entry.getRight() == null){
            if (entry.getLeft().getSize() == k){
                System.out.println(entry.getKey());
            }
            else{
                if (entry.getLeft().getSize() > k){
                    findKthSmallest(k, entry.getLeft(), counter);
                }
            }
        }
        else { //testing
            System.out.println(entry.getKey());
        }
    }

    public static void main(String[] argv) {
        BSTJr<Integer> tree1 = new BSTJr<Integer>();
        Integer[] ks1 = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11};
        tree1.build(ks1);
        tree1.display();
        tree1.findKthSmallest(1, tree1.root, 0); //doesn't work
        System.out.println(tree1.checkBalance(tree1.root) + "\n");


        BSTJr<Integer> tree2 = new BSTJr<Integer>();
        //found example of a binary search tree online to test if checkBalance only works on balanced trees:
        //https://rb.gy/x4a8yh
        Integer[] ks2 = {15, 10, 20, 8, 12, 16, 25};
        tree2.build(ks2);
        tree2.display();
        System.out.println(tree2.checkBalance(tree2.root));
        tree2.findKthSmallest(1, tree2.root, 0); //doesn't work
    }
}