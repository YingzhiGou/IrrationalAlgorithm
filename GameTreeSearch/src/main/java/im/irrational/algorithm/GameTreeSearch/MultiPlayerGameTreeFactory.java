package im.irrational.algorithm.GameTreeSearch;

public abstract class MultiPlayerGameTreeFactory<TTreeNode extends PlayerTreeNode> implements ITreeFactory<TTreeNode> {
    protected final IPlayer[] players;

    protected MultiPlayerGameTreeFactory(IPlayer... players) {
        this.players = players;
    }
}
