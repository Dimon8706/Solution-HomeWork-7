package Part_2_Mediator_Pattern;

import java.util.*;
import java.util.concurrent.*;

public class AirportSimulation {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        List<Aircraft> aircraftList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int fuelLevel = new Random().nextInt(50) + 10;
            if (i % 3 == 0) {
                aircraftList.add(new Helicopter("H" + i, fuelLevel));
            } else if (i % 2 == 0) {
                aircraftList.add(new CargoPlane("C" + i, fuelLevel));
            } else {
                aircraftList.add(new PassengerPlane("P" + i, fuelLevel));
            }
        }

        Map<Aircraft, Boolean> hasRequestedRunway = new HashMap<>();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            for (Aircraft aircraft : aircraftList) {
                if (!hasRequestedRunway.getOrDefault(aircraft, false) && Math.random() > 0.5) {
                    aircraft.send("Request Runway", tower);
                    hasRequestedRunway.put(aircraft, true);
                }
            }
            tower.manageRunway();
        }, 0, 1, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            System.out.println("Emergency situation - MAYDAY!");
            aircraftList.get(0).send("MAYDAY", tower);
        }, 5, TimeUnit.SECONDS);
    }
}
