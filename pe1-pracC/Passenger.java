// @author A0302149M

public class Passenger {
  private static int counter = 0;
  private int id;
  private int stopId;

  public Passenger(int stopId) {
    this.stopId = stopId;
    this.id = Passenger.counter;
    Passenger.counter++;
  }

  public boolean hasReachedDestination(int stopId) {
    return stopId == this.stopId;
  }

  public int getDestination() {
    return stopId;
  }

  @Override 
  public String toString() {
    return String.format("P%s->COM%s", this.id, this.stopId);
  }
}
