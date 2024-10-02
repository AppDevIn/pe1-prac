public class Assign extends DeadlineTask {
  private String assign;

  public Assign(String description, int dueDate, String assign) {
    super(description, dueDate);
    this.assign = assign;
  }

  @Override
  public String remindAllMessage() {
    return String.format("Sending a Reminder to complete \"%s\" to %s", this, this.assign);
  }

  @Override 
  public String printDetails() {
    return String.format("%s | Assigned to %s", super.printDetails(), this.assign);
  }
}
