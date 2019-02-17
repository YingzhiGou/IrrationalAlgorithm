package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.*;


public class MinimaxTreeFactory<Action extends IAction, State extends IState> extends MultiPlayerGameTreeFactory<Action, State> {

    public MinimaxTreeFactory(IStateUpdateOperator<Action, State> stateUpdateOperator, final IPlayer minimizingPlayer, final IPlayer maximizingPlayer){
        super(stateUpdateOperator, minimizingPlayer, maximizingPlayer);
    }

    public void construct(MinimaxTreeNode<Action, State> root, int level) {
        
    }
}
