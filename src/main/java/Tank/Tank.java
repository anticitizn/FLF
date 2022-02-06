package Tank;

@SuppressWarnings("ALL")
public abstract class Tank implements ITank{
    private final int length;
    private final int width;
    private final int height;
    private int filled;
    private final int[][][] capacity;

    public Tank(int Length, int Height, int Width){
        length = Length;
        height = Height;
        width = Width;

        filled = length * width * height;

        capacity = new int[length][height][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    capacity[i][j][k] = 1;
                }
            }
        }
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
}
