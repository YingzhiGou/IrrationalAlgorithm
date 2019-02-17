package im.irrational.algorithm.GameTreeSearch;

public class MultiPlayerGameTreeFactory<Action extends IAction, State extends IState> implements ITreeFactory<PlayerTreeNode<Action,State>> {
    protected final IPlayer<Action>[] players;
    protected final IStateUpdateOperator<Action, State> stateUpdateOperator;

    protected MultiPlayerGameTreeFactory(final IStateUpdateOperator<Action, State> stateUpdateOperator, final IPlayer... players) {
        this.stateUpdateOperator = stateUpdateOperator;
        this.players = players;
    }

    @Override
    public void construct(final PlayerTreeNode<Action, State> root) {
        construct(root, -1);
    }

    @Override
    public void construct(final PlayerTreeNode<Action, State> root, int level){
        if (!root.getState().isTerminal() && (level > 0 || level < 0)) {
            IPlayer<Action> currentPlayer = root.getPlayer().getNextPlayer();
            for (Action action : currentPlayer.getAllActions()) {
                for (State newState : stateUpdateOperator.update(action, root.getState())) {
                    PlayerTreeNode<Action, State> newNode = root.expand(currentPlayer, action, newState);
                    // depth first
                    construct(newNode, level - 1);
                }
            }
        }
    }
}
