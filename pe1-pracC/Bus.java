// @author A0302149M

public class Bus {
  
  private static int counter = 0;
  private int capacity;
  private int numberOfStops;
  private int currentStop;
  private Queue<Passenger>[] stops;
  private int id;
  private int currentCapacity = 0;


  public Bus(int capacity, int numberOfStops) {
    this.capacity = capacity;
    this.numberOfStops = numberOfStops;
    this.id = Bus.counter++;
    this.currentStop = 0;

    @SuppressWarnings("unchecked")
    Queue<Passenger>[] temp  = (Queue<Passenger>[]) new Queue<?>[numberOfStops];
    
    this.stops = temp;
    for (int i = 0; i < this.numberOfStops; i++) {
      this.stops[i] = new Queue<Passenger>(this.capacity);
    }
  }

  public Bus board(Passenger passenger) throws CannotBoardException {
    if (currentCapacity < capacity) {
      this.stops[passenger.getDestination()].enq(passenger);
      this.currentCapacity += 1;

    } else {
      throw new CannotBoardException("Bus is full");
    }
    return this;
  }

  public Bus alight() {
    while (this.stops[this.currentStop].deq() != null) {
      this.currentCapacity -= 1;
    }

    return this;
  }

  public Bus move() {
    this.currentStop = (this.currentStop + 1) % this.numberOfStops;
    return this;
  }

  public int getCurrentStop() {
    return this.currentStop;
  }

  public boolean isFull() {
    return currentCapacity >= capacity;
  }

  private String getQueueString() {
    String ts = "";
    for(int i = 0; i < this.numberOfStops;i++) {
      ts = ts + stops[i] + " ";
    }
    return ts;
  }

  @Override 
  public String toString() {
    return String.format("B%s@COM%s passengers: %s", this.id, this.currentStop, this.getQueueString());
  }
}
