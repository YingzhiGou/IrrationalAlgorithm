package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.*;


public class MinimaxTreeFactory<Action extends IAction, State extends IState, Value extends Comparable<Value>> extends MultiPlayerGameTreeFactory<Action, State> {
    private final IHeuristicFunc<State, Value> heuristicFunc;

    public MinimaxTreeFactory(final IStateUpdateOperator<Action, State> stateUpdateOperator, final IPlayer minimizingPlayer, final IPlayer maximizingPlayer) {
        super(stateUpdateOperator, minimizingPlayer, maximizingPlayer);
        heuristicFunc = null;
    }

    public MinimaxTreeFactory(final IStateUpdateOperator<Action, State> stateUpdateOperator, final IHeuristicFunc<State, Value> heuristicFunc, final IPlayer minimizingPlayer, final IPlayer maximizingPlayer) {
        super(stateUpdateOperator, minimizingPlayer, maximizingPlayer);
        this.heuristicFunc = heuristicFunc;
    }

    public void construct(final MinimaxTreeNode<Action, State, Value> root, final int level) {
        if (!root.getState().isTerminal() && (level > 0 || level < 0)) {
            MinimaxPlayer<Action> currentPlayer = root.getPlayer().getNextPlayer();
            for (Action action : currentPlayer.getAllActions()) {
                for (State newState : stateUpdateOperator.update(action, root.getState())) {
                    MinimaxTreeNode<Action, State, Value> newNode = root.expand(currentPlayer, action, newState);
                    // depth first
                    construct(newNode);
                }
            }
        } else if (heuristicFunc != null) {
            root.setValue(heuristicFunc.evaluate(root.getState()));
        }
    }
}
