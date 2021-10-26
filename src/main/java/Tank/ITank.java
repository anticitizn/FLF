package Tank;

public interface ITank {
    void fill(int amount);
    void drain(int amount);
    int getCapacity();
}
