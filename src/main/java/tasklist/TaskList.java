package tasklist;
import java.util.ArrayList;
import task.Task;
public class TaskList {
    public ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    public Task getTask(int index) {
        return this.list.get(index);
    }

    public void removeTask(int index) {
        this.list.remove(index);
    }

    public void addTask(Task task) {
        this.list.add(task);
    }

    public int size() {
        return this.list.size();
    }
}