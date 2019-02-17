package im.irrational.algorithm.GameTreeSearch;

public interface IValueNode<Value> {
    Value getValue();
    void satValue(Value value);
}
