package im.irrational.algorithm.GameTreeSearch.minimax;

import im.irrational.algorithm.GameTreeSearch.IAction;
import im.irrational.algorithm.GameTreeSearch.IPlayer;

import java.util.List;

public abstract class MinimaxPlayer<Action extends IAction> implements IPlayer<Action> {
    private final PlayerType type;
    private MinimaxPlayer<Action> nextPlayer;

    public MinimaxPlayer(PlayerType type) {
        this.type = type;
    }

    public PlayerType getType() {
        return this.type;
    }

    @Override
    public MinimaxPlayer<Action> getNextPlayer() {
        return this.nextPlayer;
    }

    public void setNextPlayer(MinimaxPlayer<Action> player) {
        this.nextPlayer = player;
    }

    @Override
    abstract public List<Action> getAllActions();
}
