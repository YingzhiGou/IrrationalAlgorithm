package im.irrational.algorithm.GameTreeSearch;

import java.util.List;

public interface IStateUpdateOperator<Action extends IAction, State extends IState> {
    List<State> update(final Action action, final State state);
}
