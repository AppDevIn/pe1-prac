/**
 * CS2030S AY22/23 Sem 2 PE1
 * @author: STUDENT ID
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Encapsulate a list of TODO tasks.
 */
class TaskList {
  private int numOfTasks;
  private Array<Task> taskList;
  // The types of tasks
  /**
   * A constructor that reads in the list from the standard input.
   **/
  public TaskList() {
    this(new Scanner(System.in));
  }

  /**
   * A constructor that reads in the list from the standard input.
   * @throws FileNotFoundException
   **/
  public TaskList(String filename) throws FileNotFoundException {
    this(new Scanner(new File(filename)));
  }

  /**
   * A constructor that reads in the list using the given scanner.
   * If the input contains an invalid type, print an error message.
   * @param sc The Scanner to read from.
   **/
  private TaskList(Scanner sc) {

    try {
     this.loadTasks(sc);
    } catch (WrongTaskTypeException w) { 
     System.out.println(w.getMessage());
    }
  }

  /**
   * Load the tasks from the given scanner.
   * @param sc The scanner to load from.
   * @return false if the input contains a wrong type; true otherwise.
   **/
  private void loadTasks(Scanner sc) throws WrongTaskTypeException {
    this.numOfTasks = Integer.parseInt(sc.nextLine().trim());
    this.taskList = new Array<Task>(this.numOfTasks);

    int i = 0;
    while (sc.hasNext()) {
      String text = sc.nextLine().trim();
      String[] arguments = text.split(",");
      taskList.set(i, Task.of(arguments));
      i += 1;
    }
  }

  /**
   * Print the description of all tasks.
   **/
  public void printTaskDescriptions() {
    for (int i = 0; i < this.numOfTasks; i++) {
      System.out.println(i + " " + taskList.get(i));
    }
  }

  /**
   * Print the details of all tasks.
   **/
  public void printTaskDetails() {
    for (int i = 0; i < this.numOfTasks; i++) {
      System.out.println(i + " " + taskList.get(i).printDetails());
    }
  }

  /**
   * Calculate the total reward points earned.
   * @return The reward points.
   **/
  public int getRewardPoints() {
    int sum = 0;
    for (int i = 0; i < this.numOfTasks; i++) {
      sum += taskList.get(i).getPoints();
    }
    return sum;
  }

  /**
   * Print all the tasks that are due today.
   **/
  public void printDueToday() {
    for (int i = 0; i < this.numOfTasks; i++) {
      if (taskList.get(i).dueToday()) {
        System.out.println(i + " " + taskList.get(i).printDetails());
      }
    }
  }

  /**
   * Remind users about all incomplete tasks with deadline.
   */
  public void remindAll() {
   for (int i = 0; i < this.numOfTasks; i++) {
      if (!taskList.get(i).done() && taskList.get(i).hasDeadline()) {
       System.out.println(taskList.get(i).remindAllMessage());
      }
    }

  }

  /**
   * Mark a task as complete.
   * @param i The index of the task to complete.
   */
  public void completeTask(int i) {
    this.taskList.get(i).complete();
  }
}
