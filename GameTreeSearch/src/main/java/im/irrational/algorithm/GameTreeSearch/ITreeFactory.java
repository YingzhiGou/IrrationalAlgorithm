package im.irrational.algorithm.GameTreeSearch;

public interface ITreeFactory<TTreeNode extends TreeNode> {
    void construct(TTreeNode root);
}
