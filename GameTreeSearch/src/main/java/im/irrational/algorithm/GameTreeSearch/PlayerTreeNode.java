package im.irrational.algorithm.GameTreeSearch;

public class PlayerTreeNode<TAction extends IAction, TState extends IState> extends TreeNode<TAction, TState> {
    private final IPlayer player;

    public PlayerTreeNode(IPlayer player, TAction action, TState state) {
        super(action, state);
        this.player = player;
    }

    public IPlayer getPlayer() {
        return player;
    }
}
