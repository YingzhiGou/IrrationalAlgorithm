package im.irrational.algorithm.GameTreeSearch;

public class ValueTreeNode<Action extends IAction, State extends IState, Value> extends TreeNode<Action, State> implements IValueNode<Value>{
    private Value value;
    ValueTreeNode(final Action action, final State state) {
        this(action,state,null);
    }

    ValueTreeNode(final Action action, final State state, final Value value){
        super(action, state);
        this.satValue(value);
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public void satValue(final Value value) {
        this.value = value;
    }
}
