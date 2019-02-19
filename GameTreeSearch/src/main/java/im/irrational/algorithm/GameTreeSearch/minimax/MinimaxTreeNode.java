package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.IAction;
import im.irrational.algorithm.GameTreeSearch.IState;
import im.irrational.algorithm.GameTreeSearch.IValueNode;
import im.irrational.algorithm.GameTreeSearch.PlayerTreeNode;

public class MinimaxTreeNode<Action extends IAction, State extends IState, Value extends Comparable<Value>> extends PlayerTreeNode<Action, State> implements IValueNode<Value> {
    private Value value;

    private MinimaxTreeNode<Action, State, Value> bestChild;

    public MinimaxTreeNode<Action, State, Value> getBestChild() {
        return bestChild;
    }

    public void setBestChild(MinimaxTreeNode<Action, State, Value> bestChild) {
        this.bestChild = bestChild;
    }

    MinimaxTreeNode(MinimaxPlayer<Action> player, Action action, State state, Value value) {
        super(player, action, state);
        this.value = value;
    }

    public MinimaxTreeNode(MinimaxPlayer<Action> currentPlayer, Action action, State newState) {
        super(currentPlayer, action, newState);
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public void setValue(Value value) {
        this.value = value;
    }

    public MinimaxTreeNode<Action, State, Value> expand(MinimaxPlayer<Action> currentPlayer, Action action, State newState) {
        MinimaxTreeNode<Action, State, Value> newNode = new MinimaxTreeNode<>(currentPlayer, action, newState);
        this.expand(newNode);
        return newNode;
    }

    public void expand(MinimaxTreeNode<Action, State, Value> child) {
        super.expand(child);
        if (this.children.size() == 1) {
            this.setValue(child.getValue());
            this.setBestChild(child);
        } else if (this.getPlayer().getType() == PlayerType.MINIMIZING && child.getValue().compareTo(this.getValue()) < 0) {
            this.setValue(child.getValue());
            this.setBestChild(child);
        } else if (this.getPlayer().getType() == PlayerType.MAXIMIZING && child.getValue().compareTo(this.getValue()) > 0) {
            this.setValue(child.getValue());
            this.setBestChild(bestChild);
        }
    }

    @Override
    public MinimaxPlayer<Action> getPlayer() {
        return (MinimaxPlayer<Action>) super.getPlayer();
    }
}
