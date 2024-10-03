public class DepartureEvent extends Event {
  
  private Passenger passenger;

  public DepartureEvent(double time, Passenger passenger) {
    super(time);
    this.passenger = passenger;

  }

  @Override 
  public Event[] simulate() {
    return new Event[] {
      //TODO: Depart
    };
    
  }

  @Override 
  public String toString() {
    return String.format("%s %s departs", super.toString(), this.passenger);
  }
}
