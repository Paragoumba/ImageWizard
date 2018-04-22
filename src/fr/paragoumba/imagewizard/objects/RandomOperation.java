package fr.paragoumba.imagewizard.objects;

import java.util.Random;

/**
 * Created by Paragoumba on 20/05/2017.
 */

public class RandomOperation {

    public RandomOperation(int max, int min, int width, int height){
        this.max = max;
        this.min = min;
        this.width = width;
        this.height = height;
    }

    public static int x;
    public static int y;
    private int width;
    private int height;
    private int max;
    private int min;

    public void op(int x, int y){

        RandomOperation.x = x;
        RandomOperation.y = y;

        Random random = new Random();

        int n = random.nextInt(max + 1 - min) + min;

        if (n == 0 && x + 1 < width) {
            RandomOperation.x++;
        } else if (n == 1 && x - 1 > 0) {
            RandomOperation.x--;
        } else if (n == 2 && y + 1 < height) {
            RandomOperation.y++;
        } else if (n == 3 && y - 1 > 0) {
            RandomOperation.y--;
        }
    }
}
