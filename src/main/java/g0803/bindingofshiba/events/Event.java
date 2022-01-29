package g0803.bindingofshiba.events;

public class Event {
    private boolean cancelled = false;
    private final double dt;

    public Event(double dt) {
        this.dt = dt;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public double getTickTime() {
        return dt;
    }
}
