public abstract class Task {
  private boolean completed;
  private String description;

  private static final int ANYTIME = 0;
  private static final int DEADLINE = 1;
  private static final int ASSIGNABLE = 2;


  public Task(String description) {
    this.description = description;
    this.completed = false;
  }

  public static Task of(String[] args) throws WrongTaskTypeException {
    int type = Integer.parseInt(args[0]);
    String description = args[1];

    if (type == Task.ANYTIME) {
       return new AnyTimeTask(description);
    } else if (type == Task.DEADLINE) {
      int dueInDays = Integer.parseInt(args[2]);
      return new DeadlineTask(description, dueInDays);
    } else if (type == Task.ASSIGNABLE) {
      int dueInDays = Integer.parseInt(args[2]);
      String assignees = args[3];

      return new Assign(description, dueInDays, assignees);
    } else {
      throw new WrongTaskTypeException("Invalid task type in input: " + type);
    }
  }

  private String checked() {
    return this.completed ? "[X]" : "[ ]";
  }

  public void complete() {
    this.completed = true;
  }

  public boolean done() {
    return this.completed;
  }


  public abstract boolean hasDeadline();

  public abstract int getPoints();

  public abstract boolean dueToday();

  public String printDetails() {
    return String.format("%s %s", this.checked(), this);
  }

  public String remindAllMessage() {
    return String.format("");
  }

  @Override
  public String toString() {
    return String.format("%s", this.description);
  }


}
