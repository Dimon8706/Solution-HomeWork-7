package Part_2_Mediator_Pattern;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a);
}
