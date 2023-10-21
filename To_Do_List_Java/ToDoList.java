import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoList {
    private List<TodoTask> tasks;
    
    public ToDoList(){
        tasks = new ArrayList<>();
    }

    public void addTask(String descrption){
        TodoTask task = new TodoTask(descrption);
        tasks.add(task);
    }

    public void listTask(){
        for( int i =0 ; i<tasks.size();i++){
            TodoTask task = tasks.get(i);
            System.out.println(task.getID()+ "\t" + task.getDescription()+ "\t" + (task.isComplete() ? "[X] " : "[ ] "));
        }
    }

    public void markAsComplete(int index){
        if(index > tasks.size()){
            System.out.println("Task ID not present. Please enter a valid ID");
        }
        else {
            TodoTask task = tasks.get(index);
            task.markComplete();
        }

    }

    public void saveFile(String filename){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write("-------------To Do List Application -----------");
            writer.newLine();
            writer.write("ID \t Description \t Status");
            writer.newLine();
            for (TodoTask task : tasks){
                writer.write(task.getID()+ "\t" + task.getDescription()+ "\t" + (task.isComplete() ? "[X] " : "[ ] "));
                writer.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Error Saving to file " + e.getMessage());
        }

    }
}
