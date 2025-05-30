package behavioral_patterns.command_pattern.command;

public interface TaskCommand {
    void execute();
    void undo();
}
