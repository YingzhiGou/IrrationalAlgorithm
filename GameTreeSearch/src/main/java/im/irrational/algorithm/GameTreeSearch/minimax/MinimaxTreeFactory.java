package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.*;


public class MinimaxTreeFactory<Action extends IAction, State extends IState> extends MultiPlayerGameTreeFactory<Action, State> {

    public MinimaxTreeFactory(IStateUpdateOperator<Action, State> stateUpdateOperator, final IPlayer minimizingPlayer, final IPlayer maximizingPlayer){
        super(stateUpdateOperator, minimizingPlayer, maximizingPlayer);
    }

    @Override
    public void construct(PlayerTreeNode<Action, State> root, int level) {
        super.construct(root);
    }
}
