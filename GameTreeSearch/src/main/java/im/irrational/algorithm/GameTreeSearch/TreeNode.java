package im.irrational.algorithm.GameTreeSearch;

import java.util.*;
import java.util.logging.Logger;

public class TreeNode<TAction extends IAction, TState extends IState> implements IActionNode<TAction>, IStateNode<TState>, ITreeNode {
    static protected final Logger logger = Logger.getLogger(TreeNode.class.getName());

    public TAction getAction() {
        return action;
    }

    public TState getState() {
        return state;
    }

    final protected Set<TreeNode<TAction, TState>> children;
    final private TAction action;
    final private TState state;

    TreeNode(final TAction action, final TState state) {
        this.action = action;
        this.state = state;
        this.children = new HashSet<>();
    }

    public List<TreeNode<TAction, TState>> getChildren() {
        return new LinkedList<>(children);
    }

    public void expand(final TreeNode<TAction, TState> child) {
        this.children.add(child);
    }

    public TreeNode<TAction, TState> expand(final TAction action, final TState state) {
        TreeNode<TAction, TState> child = new TreeNode<>(action, state);
        this.expand(child);
        return child;
    }

    public boolean isTerminal() {
        return state.isTerminal();
    }

    public boolean isPseudoLeaf() {
        return !isTerminal() && this.children.isEmpty();
    }

    public int arity() {
        return isTerminal() ? 0 : children.size();
    }

    @Override
    public String toString() {
        return String.format("%s->%s", action.toString(), state.toString());
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
