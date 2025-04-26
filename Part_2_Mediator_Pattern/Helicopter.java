package Part_2_Mediator_Pattern;

public class Helicopter extends Aircraft {
    public Helicopter(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Helicopter " + id + " received: " + msg);
    }
}
