public class AnyTimeTask extends Task{
    public AnyTimeTask(String description) {
        super(description);
    }

    @Override
    public boolean hasDeadline() {
        return false;
    }

    @Override
    public boolean dueToday() {
        return false;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}
