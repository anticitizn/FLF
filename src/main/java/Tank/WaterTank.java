package Tank;

import java.util.Arrays;

public class WaterTank implements ITank{

    private final int[][][] capacity = new int[50][25][10];
    private int filled = 0;

    public WaterTank(){
        tankInit();
    }

    public void tankInit() {
        for (int[][] row : capacity) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, 0);
            }
        }
    }

    public void fill(int amount) {
        int var = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 10; k++) {

                    if (var == amount || filled == 12500) {
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
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 10; k++) {

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
