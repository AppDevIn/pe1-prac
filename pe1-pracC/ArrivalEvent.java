public class ArrivalEvent extends Event {
  
  private Passenger passenger;
  private Stop stop;

  public ArrivalEvent(double time, Passenger passenger, Stop stop) {
    super(time);
    this.passenger = passenger;
    this.stop = stop;
  }

  @Override 
  public Event[] simulate() {
    if (this.stop.isFull()) {
      return new Event[] {
        new DepartureEvent(this.getTime(), this.passenger)
      };
    } else {
      stop.addPassenger(passenger);
      return new Event[] {};
    }
  }

  @Override 
  public String toString() {
    return String.format("%s %s arrives at %s", super.toString(), this.passenger, this.stop);
  }
}
