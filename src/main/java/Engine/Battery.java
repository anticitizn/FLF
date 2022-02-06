package Engine;

import java.util.Arrays;

public class Battery {

    private final int[][][] capacity = new int[100][10][100];
    private int charging = 0;

    public Battery(){
        batteryInit();
    }

    public void batteryInit() {
        for (int[][] row : capacity) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, 0);
            }
        }
    }

    public void charge(int amount) {
        int var = 0;
        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j < capacity[i].length; j++) {
                for (int k = 0; k < capacity[i][j].length; k++) {

                    if (var == amount || charging == 100000) {
                        break;
                    }
                    var++;
                    capacity[i][j][k] = 1;
                    charging++;
                }
            }
        }
    }

    public void drain(int amount) {
        int var = 0;
        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j < capacity[i].length; j++) {
                for (int k = 0; k < capacity[i][j].length; k++) {

                    if (var == amount || charging == 0) {
                        break;
                    }
                    var++;
                    capacity[i][j][k] = 0;
                    charging--;
                }
            }
        }
    }


    public int getCapacity(){
        return charging;
    }
}
