package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {
    private static Clock instance;
    private final int time = new Random().nextInt(25);

    private Clock() {}

    public static Clock getInstance(){
        if (instance == null)
            instance = new Clock();
        return instance;
    }

    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }

}
