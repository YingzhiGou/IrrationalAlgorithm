package im.irrational.algorithm.GameTreeSearch;

public interface ITreeFactory<TTreeNode extends TreeNode> {
    /**
     * construct complete game tree
     * @param root root of the tree
     */
    void construct(final TTreeNode root);

    /**
     * construct *level* levels of tree, where the root is level 0
     * @param root root of tree
     * @param level number of level to construct or -1 if no limit
     */
    void construct(final TTreeNode root, int level);
}
