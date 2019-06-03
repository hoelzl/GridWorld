package gridworld.core;

public interface Command {
    void execute();

    String getDescription();
}
