package im.irrational.algorithm.GameTreeSearch.minimax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class TreeNode<TAction extends IAction, TState extends IState> {
    static protected final Logger logger = Logger.getLogger(TreeNode.class.getName());

    public TAction getAction() {
        return action;
    }

    public TState getState() {
        return state;
    }

    final protected List<TreeNode<TAction, TState>> children;
    final private TAction action;
    final private TState state;

    TreeNode(final TAction action, final TState state) {
        this.action = action;
        this.state = state;
        this.children = new ArrayList<>();
    }

    public List<TreeNode<TAction, TState>> getChildren() {
        return children;
    }

    public void expand(final TreeNode child){
        this.children.add(child);
    }

    public TreeNode<TAction, TState> expand(final TAction action, final TState state) {
        TreeNode<TAction, TState> child = new TreeNode(action, state);
        this.expand(child);
        return child;
    }

    public boolean isPseudoLeaf() {
        return this.children.isEmpty();
    }

    public int arity() {
        return children.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return action.equals(treeNode.action) &&
                state.equals(treeNode.state) &&
                children.equals(treeNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, state);
    }
}
