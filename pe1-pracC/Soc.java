public class Soc {
  private Stop[] stops;

  public Soc(Stop[] stops) {
    this.stops = stops;
  }

  public Stop getStop(int id) {
    return this.stops[id];
  }
}
