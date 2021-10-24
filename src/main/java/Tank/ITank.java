package Tank;

public interface ITank {

    void tankInit();

    void fill(int amount);

    void drain(int amount);

    int getCapacity();
}
