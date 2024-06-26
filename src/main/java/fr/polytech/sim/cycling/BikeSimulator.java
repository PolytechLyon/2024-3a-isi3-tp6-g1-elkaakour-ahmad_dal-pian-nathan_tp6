package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;
import fr.polytech.sim.utils.Context;

import java.util.Iterator;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerFactory.getLogger("BikeSimulator");

    public void run() {

        Iterator<Bike> bikeIterator = Context.injectAll(Bike.class);

        Bike bike;

        while (bikeIterator.hasNext())
        {
            bike = bikeIterator.next();
            this.logger.log(bike.getClass().getSimpleName() + "'s speed %.2f Km/h.", bike.getVelocity());
            this.logger.log(bike.getClass().getSimpleName() + "'s mass %.2f Kg.", bike.getMass());
        }
    }
}
