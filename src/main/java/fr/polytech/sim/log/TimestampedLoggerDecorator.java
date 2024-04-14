package fr.polytech.sim.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampedLoggerDecorator extends LoggerDecorator{

    TimestampedLoggerDecorator(Logger logger){
        this.logger = logger;
    }

    public void log(String format, Object... args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        String updatedFormat = date + " : " + format;
        logger.log(updatedFormat, args);
    }
}
