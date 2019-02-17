package im.irrational.algorithm.GameTreeSearch;

public interface IPlayerNode<Action extends IAction> {
    IPlayer<Action> getPlayer();
}
