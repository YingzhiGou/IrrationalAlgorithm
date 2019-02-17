package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.IAction;
import im.irrational.algorithm.GameTreeSearch.IPlayer;

public interface IMinimaxPlayer<Action extends IAction> extends IPlayer<Action> {
    PlayerType getPlayerType();
}
