public class DeadlineTask extends Task {
  private int dueDate;
  private final int K = 1;

  public DeadlineTask(String description, int dueDate) {
    super(description);
    this.dueDate = dueDate;
  }

  @Override
  public boolean hasDeadline() {
    return true;
  }

  @Override
  public boolean dueToday() {
    return this.dueDate == 0;
  }

  @Override
  public int getPoints() {
    return this.done() ? this.dueDate * this.K : 0; 
  }

  @Override
  public String remindAllMessage() {
    return String.format("The task \"%s\" is due in %s days", this, this.dueDate);
  }

  @Override 
  public String printDetails() {
    return String.format("%s | Due in %s days", super.printDetails(), this.dueDate);
  }

}
