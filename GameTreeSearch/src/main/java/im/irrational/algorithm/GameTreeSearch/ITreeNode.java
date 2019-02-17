package im.irrational.algorithm.GameTreeSearch;

import java.util.List;

public interface ITreeNode<State extends IState> {
    List<ITreeNode<State>> getChildren();

    boolean isTerminal();
}
