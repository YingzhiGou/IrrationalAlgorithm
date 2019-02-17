package im.irrational.algorithm.GameTreeSearch;

public class PlayerTreeNode<Action extends IAction, State extends IState> extends TreeNode<Action, State> implements IPlayerNode<Action> {
    private final IPlayer<Action> player;

    public PlayerTreeNode(final IPlayer<Action> player, final Action action, final State state) {
        super(action, state);
        this.player = player;
    }

    @Override
    public IPlayer<Action> getPlayer() {
        return player;
    }

    public PlayerTreeNode<Action, State> expand(IPlayer<Action> currentPlayer, Action action, State newState) {
        PlayerTreeNode<Action,State> newNode = new PlayerTreeNode<>(currentPlayer, action, newState);
        this.expand(newNode);
        return newNode;
    }
}
