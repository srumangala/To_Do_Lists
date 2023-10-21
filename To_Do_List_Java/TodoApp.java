import java.util.Scanner;

public class TodoApp {
    public static void main (String[] args){

        ToDoList todolist = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("To Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark as Complete");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Task Description: ");
                    String description =  scanner.nextLine();
                    todolist.addTask(description);
                    break;
                case 2:
                    System.out.println("Tasks");
                    todolist.listTask();
                    break;
                case 3:
                    System.out.println("Enter the ID of the task you wish to mark Complete");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    todolist.markAsComplete(index-1);
                    System.out.println("Task Marked Complete!");
                    break;
                case 4:
                    todolist.saveFile("todo.txt");
                    System.exit(0);
                default :
                    System.out.println("Invalid Input ! Please select from available options!!");
            }
        }

    }
    
}
