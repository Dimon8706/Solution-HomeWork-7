package Part_2_Mediator_Pattern;

import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("ControlTower broadcasting: " + msg);
        if (msg.equals("MAYDAY")) {
            emergencyProtocol(sender);
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.getFuelLevel() < 20 || a instanceof Helicopter) {
            landingQueue.offer(a);
            return true;
        }
        takeoffQueue.offer(a);
        return false;
    }

    private void emergencyProtocol(Aircraft a) {
        System.out.println("Emergency! Clearing runway for " + a.id);
        landingQueue.clear();
        takeoffQueue.clear();
    }

    public void manageRunway() {
        while (!landingQueue.isEmpty() || !takeoffQueue.isEmpty()) {
            if (!landingQueue.isEmpty()) {
                Aircraft aircraft = landingQueue.poll();
                System.out.println("Landing " + aircraft.id);
            } else if (!takeoffQueue.isEmpty()) {
                Aircraft aircraft = takeoffQueue.poll();
                System.out.println("Takeoff " + aircraft.id);
            }
        }
    }
}
