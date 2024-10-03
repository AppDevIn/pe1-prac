// @author Axxxxxxx

public class Stop {
  private int cap;
  private int stopId;
  private Queue<Passenger> passengers;

  public Stop(int stopId, int cap) {
    this.stopId = stopId;
    this.cap = cap;
    this.passengers = new Queue<Passenger>(cap);
  } 

  public boolean addPassenger(Passenger p) {
    return passengers.enq(p);
  }

  public Passenger removePassenger() {
    return passengers.deq();
  }

  public boolean isFull() {
    return this.passengers.isFull();
  }

  public boolean isEmpty() {
    return this.passengers.isEmpty();
  }

  @Override
  public String toString() {
    return String.format("COM%s %s", this.stopId, this.passengers);
  }
}
