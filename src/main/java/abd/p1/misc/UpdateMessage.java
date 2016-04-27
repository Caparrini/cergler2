package abd.p1.misc;

public final class UpdateMessage<T> {
    public enum UpdateEvent {
        LOGIN,
        SIGNUP,
    }

    private final UpdateEvent eventType;
    private final T argument;

    public static <T> UpdateMessage<T> composeMessage(UpdateEvent event, T arg) {
        return new UpdateMessage<>(event, arg);
    }

    private UpdateMessage(UpdateEvent event, T arg) {
        this.eventType = event;
        this.argument = arg;
    }

    public UpdateEvent getEvent() {
        return eventType;
    }

    public T arg() {
        return argument;
    }
}
