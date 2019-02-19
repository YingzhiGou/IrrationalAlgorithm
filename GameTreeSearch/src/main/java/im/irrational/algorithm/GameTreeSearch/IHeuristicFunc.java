package im.irrational.algorithm.GameTreeSearch;

public interface IHeuristicFunc<State extends IState, Value> {
    Value evaluate(final State state);
}
