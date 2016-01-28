import javafx.scene.shape.Arc;

import java.util.Timer;
import java.util.TimerTask;


public class ArchMonitor {

    private long mana;


    private final long HOUR = 3600000;//3600000
    private final ArchStealMana ArchThief = new ArchStealMana();


    protected ArchMonitor() {

        initManaStealer();

    }

    private void initManaStealer() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                ArchThief.hourlyRun();
            }
        }, 0, HOUR);


    }




}
