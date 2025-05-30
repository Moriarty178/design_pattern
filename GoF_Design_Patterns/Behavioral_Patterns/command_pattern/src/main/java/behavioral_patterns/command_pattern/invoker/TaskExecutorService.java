package behavioral_patterns.command_pattern.invoker;

import behavioral_patterns.command_pattern.command.TaskCommand;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Service
public class TaskExecutorService {
    private final List<TaskCommand> taskQueue = new ArrayList<>();
    private final Deque<TaskCommand> history = new ArrayDeque<>();
    private final Deque<TaskCommand> redoStack = new ArrayDeque<>();


    public void addTask(TaskCommand taskCommand) {
        taskQueue.add(taskCommand);
    }

    public void runAll() {
        for (TaskCommand command : taskQueue) {
            command.execute();
            history.push(command);
            redoStack.clear();
        }
        taskQueue.clear();
    }

    public void undo() {
        System.out.printf("Size history & redoStack before UNDO: History =%s, Redo stack = %s\n", history.size(), redoStack.size());
        if (!history.isEmpty()) {
            TaskCommand cmd = history.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
        System.out.printf("Size history & redoStack after UNDO: History =%s, Redo stack = %s\n", history.size(), redoStack.size());
    }

    public void redo() {
        System.out.printf("Size history & redoStack before REDO: History =%s, Redo stack = %s", history.size(), redoStack.size());
        if (!redoStack.isEmpty()) {
            TaskCommand cmd = redoStack.pop();
            cmd.execute();
            history.push(cmd);
        }
        System.out.printf("Size history & redoStack after REDO: History =%s, Redo stack = %s", history.size(), redoStack.size());

    }
}
