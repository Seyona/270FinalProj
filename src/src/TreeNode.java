

/**
 * @author David G Baker
 * @version 2014-04-15
 */
public class TreeNode {
    private Person val;
    private TreeNode lKid;
    private TreeNode rKid;

    /**
     * Create a node from the given parameters
     * pre: TreeNode has no value
     * post: TreeNode has a value
     *
     * @param pVal  Person object
     * @param pLkid TreeNode object that will be the currents lkid
     * @param pRkid TreeNode object that will be the currents rkid
     */
    public TreeNode(Person pVal, TreeNode pLkid, TreeNode pRkid) {
        this.val = pVal;
        this.lKid = pLkid;
        this.rKid = pRkid;
    }

    /**
     * Get the val of this node
     * pre: Val is not known
     * post: Val is known
     *
     * @return Person object
     */
    public Person getVal() {
        return this.val;
    }

    /**
     * Set the val to the given parameter
     * pre: Val is unwanted value
     * post: val is wanted vaue
     *
     * @param val Person object
     */
    public void setVal(Person val) {
        this.val = val;
    }

    /**
     * Get the lkid
     * pre: Lkid is unknown
     * post: Lkid is known
     *
     * @return Left Child of Root : TreeNode Object
     */
    public TreeNode getLkid() {
        return this.lKid;
    }

    /**
     * Set the lkid to the given parameter
     * pre: lkid is unwanted value
     * post: lkid is wanted value
     *
     * @param lkid New Left Child of Root : TreeNode Object
     */
    public void setLkid(TreeNode lkid) {
        this.lKid = null;
        this.lKid = lkid;
    }

    /**
     * Get the rkid
     * pre: rkid is unknown
     * post: rkid is known
     *
     * @return Right Child of Root : TreeNode Object
     */
    public TreeNode getRkid() {
        return this.rKid;
    }

    /**
     * Set the rkid to the given parameter
     * pre: rkid is unwanted value
     * post: rkid is wanted value
     *
     * @param rkid new Right Child of Root : TreeNode Object
     */
    public void setRkid(TreeNode rkid) {
        this.rKid = null;
        this.rKid = rkid;
    }
}
