import java.util.*;
public class Duke {

    public static ArrayList<Task> list;

    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<Task>();
        String command = sc.next();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                getList();
            } else if (isMark(command) ) {
                int index = Integer.parseInt(sc.next());
                Task task = list.get(index-1);
                task.mark();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + task.toString());
            } else if (isUnmark(command)) {
                int index = Integer.parseInt(sc.next());
                Task task = list.get(index-1);
                task.unmark();
                System.out.println("OK,, I've marked this task as not done yet:");
                System.out.println("  " + task.toString());
            } else {
                String fullCommand = sc.nextLine();
                Task newTask = new ToDo(fullCommand);
                if (isDeadline(command)) {
                    String[] splitedString = fullCommand.split(" /by ");
                    String action = splitedString[0];
                    String date = splitedString[1];
                    newTask = new Deadline(action, date);
                } else if (isEvent(command)) {
                    String[] splitedString = fullCommand.split(" /from ");
                    String action = splitedString[0];
                    String duration = splitedString[1];
                    String[] fromTo = duration.split(" /to ");
                    String from = fromTo[0];
                    String to = fromTo[1];
                    newTask = new Event(action, from, to);
                }
                list.add(newTask);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + newTask.toString());
                System.out.println(String.format("Now you have %d tasks in the list.", list.size()));
            }
            command = sc.next();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void getList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            System.out.println(i+1 + "." + task.toString());
        }
    }

    public static boolean isMark(String word) {
        return word.equals("mark");
    }

    public static boolean isUnmark(String word) {
        return word.equals("unmark");
    }

    public static boolean isToDo(String word) {
        return word.equals("todo");
    }

    public static boolean isDeadline(String word) {
        return word.equals("deadline");
    }

    public static boolean isEvent(String word) {
        return word.equals("event");
    }
}






