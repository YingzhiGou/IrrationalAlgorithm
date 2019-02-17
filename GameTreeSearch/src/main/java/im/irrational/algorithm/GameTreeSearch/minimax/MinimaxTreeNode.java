package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.*;

public class MinimaxTreeNode<Action extends IAction, State extends IState> extends PlayerTreeNode<Action,State> implements IValueNode<Double> {
    MinimaxTreeNode(IPlayer<Action> player, Action action, State state) {
        super(player, action, state);
    }

    private double value;

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void satValue(Double value) {
        this.value = value;
    }
}
