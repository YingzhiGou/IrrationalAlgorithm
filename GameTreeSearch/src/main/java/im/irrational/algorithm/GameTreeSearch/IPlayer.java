package im.irrational.algorithm.GameTreeSearch;

import java.util.List;

public interface IPlayer<Action extends IAction> {
    void setNextPlayer(IPlayer<Action> player);
    IPlayer<Action> getNextPlayer();

    List<Action> getAllActions();
}
