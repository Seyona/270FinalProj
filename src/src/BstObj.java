/**
 * @author David G Baker
 * @version 2014-04-15
 */
public class BstObj {
    private TreeNode root;

    /**
     * Create an empty BstObj. An Empty BstObj is indicated by a null root pre:
     * there is no BstObj post: there is a BstObj
     */
    public BstObj() {
        root = null;
    }

    /**
     * report if the tree is empty pre: Tree emptiness is unknown post: Tree
     * emptiness is known
     *
     * @return True if tree is not empty , false other wise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns a String of the sort keys of the nodes of this tree in inorder,
     * terminated by commas. An empty tree will return an EMPTY String pre: keys
     * of node are unknown post: keys of node are known
     *
     * @return a String of hte sort keys of nodes
     */
    public String nodesInOrder() { // left sub tree, root, right subtree
        if (isEmpty()) {
            return "";
        }

        String out = nodesInOrder(root);
        out = out.substring(0, out.length() - 1);
        return out;
    }

    /**
     * private method used for nodesInOrderRecursion
     *
     * @param next a TreeNode
     */
    private String nodesInOrder(TreeNode next) {
        String inOrder = "";

        if (next == null) {
            return "";
        }

        inOrder += nodesInOrder(next.getLkid());
        inOrder += next.getVal().sortKey() + ",";
        inOrder += nodesInOrder(next.getRkid());

        return inOrder;
    }

    /**
     * Insert the given parameter into this tree. Duplicates are NOT allowed, in
     * which case, an IllegalArgumentException must be thrown pre: Person obj is
     * not in the tree or is not thought to be in the tree post: Person obj is
     * added to tree OR IllegalArgumentException is thrown
     *
     * @param pVal Person Obj
     */
    public void insert(Person pVal) {
        if (!find(pVal)) {
            root = insert(root, pVal);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * private insert method used for recursion
     *
     * @param next TreeNode Obj
     * @param pVal Person Obj passed through insert
     * @return TreeNode Obj
     */
    private TreeNode insert(TreeNode next, Person pVal) {
        if (next == null) {
            next = new TreeNode(pVal, null, null);
        } else if (pVal.compareTo(next.getVal()) < 0) {
            next.setLkid(insert(next.getLkid(), pVal));
        } else if (pVal.compareTo(next.getVal()) > 0) {
            next.setRkid(insert(next.getRkid(), pVal));
        }
        return next;
    }

    /**
     * Find out if the given parameter is in the tree.
     *
     * @param person Person Obj
     * @return Bool returning true if val person is in tree, false otherwise
     */
    public boolean find(Person person) {
        return find(root, person);
    }

    /**
     * private find method used for recursion
     *
     * @param next   TreeNode Obj
     * @param person Person Obj passed through find
     * @return Bool returning true if val person is in tree, false otherwise
     */
    private boolean find(TreeNode next, Person person) {
        if (next == null) {
            return false;
        }
        if (next.getVal().compareTo(person) == 0) {
            return true;
        }

        if (next.getVal().compareTo(person) == 1) {
            return find(next.getLkid(), person);
        } else {
            return find(next.getRkid(), person);
        }

    }

    /**
     * Delete the given person from this tree. If the delete cannot be performed
     * DO NOTHING pre: Node is in the tree post: Node is not in the tree
     *
     * @param person Person Obj
     */
    public void delete(Person person) {
        if (find(person)) {
            root = delete(root, person);
        }
    }

    /**
     * Private delete method used for recursion
     *
     * @param next   Tree node Root
     * @param person Value looking to be deleted
     */
    private TreeNode delete(TreeNode next, Person person) {

        if (next.getVal().compareTo(person) == 0) {
            if (next.getLkid() == null && next.getRkid() == null) {
                next = null;
                return next;
            }

            if (next.getLkid() == null && next.getRkid() != null) {
                next = next.getRkid();
                return next;
            }

            if (next.getRkid() == null && next.getLkid() != null) {
                next = next.getLkid();
                return next;
            }

            // assumes both children of root are non-null
            Person nxt = next.getVal();
            next.setVal(next.getRkid().getVal());
            next.getRkid().setVal(nxt);
            next.setRkid(delete(next.getRkid(), person)); // force it down until
            // it is either a leaf or only has one child
            return next;
        }

        if (find(person)) {
            if (next.getLkid() != null) {
                next.setLkid(delete(next.getLkid(), person));
            }
            if (next.getRkid() != null) {
                next.setRkid(delete(next.getRkid(), person));
            }
        }
        return next;

    }

}
