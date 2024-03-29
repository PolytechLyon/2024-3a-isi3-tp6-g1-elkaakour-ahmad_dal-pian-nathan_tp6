package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerFactory.getLogger("BikeSimulator");

    public void run() {

        Bike bike = new SimpleBike();
        this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("Bike's mass %.2f Kg.", bike.getMass());

        bike = new TagAlongBike();
        this.logger.log("TagAlongBike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("TagAlongBike's mass %.2f Kg.", bike.getMass());






    }
}
