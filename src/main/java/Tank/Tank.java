package Tank;

import Task_08_Observer.ITankCapacityListener;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public abstract class Tank implements ITank{
    private final int maxCapacity;
    private final int length;
    private final int width;
    private final int height;
    private int filled;
    private final int[][][] capacity;
    private final ArrayList<ITankCapacityListener> listenerList;

    public Tank(int Length, int Height, int Width){
        listenerList = new ArrayList<>();

        length = Length;
        height = Height;
        width = Width;

        filled = length * width * height;
        maxCapacity = filled;

        capacity = new int[length][height][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    capacity[i][j][k] = 1;
                }
            }
        }
    }

    public void addListener(ITankCapacityListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ITankCapacityListener listener) {
        listenerList.remove(listener);
    }

    public void fill(int amount) {
        int var = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {

                    if (var == amount || filled == length * width * height) {
                        break;
                    }
                    var++;
                    capacity[i][j][k] = 1;
                    filled++;
                }
            }
        }
    }

    public void drain(int amount) {
        int var = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {

                    if (var == amount || filled == 0) {
                        break;
                    }
                    var++;
                    capacity[i][j][k] = 0;
                    filled--;
                }
            }
        }
    }

    public int getCapacity(){
        return filled;
    }

    private void callCapacityListeners() {
        if (getCapacity() < maxCapacity * 0.1) {
            for (ITankCapacityListener listener : listenerList) {
                listener.tenthCapacity();
            }
        } else if (getCapacity() < maxCapacity * 0.25) {
            for (ITankCapacityListener listener : listenerList) {
                listener.quarterCapacity();
            }
        } else if (getCapacity() < maxCapacity * 0.5) {
            for (ITankCapacityListener listener : listenerList) {
                listener.halfCapacity();
            }
        }
    }
}
