public class BusStopEvent extends Event {
  
  private Bus bus;;
  private Soc soc;
  private Stop stop;


  public static final double INTER_STOP_TRAVEL_TIME = 1.0;
  
  public BusStopEvent(double time, Bus bus, Soc soc) {
    super(time);
    this.bus = bus;
    this.soc = soc;
    this.stop = this.soc.getStop(this.bus.getCurrentStop()); 
  }

  @Override 
  public Event[] simulate() {
    this.bus.alight();

    while(!this.stop.isEmpty() && !this.bus.isFull()) {
      Passenger p = this.stop.removePassenger(); 
      try {
        this.bus.board(p);
      } catch (CannotBoardException c) {
      }
    }
    this.bus.move();
    return new Event[] {
     new BusStopEvent(this.getTime() + BusStopEvent.INTER_STOP_TRAVEL_TIME, this.bus, this.soc) 
    };

  }

  @Override 
  public String toString() {
    return String.format("%s %s Stop: %s", super.toString(), this.bus, this.stop);
  }
}
