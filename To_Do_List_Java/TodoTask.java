public class TodoTask
 {
    private  int iD;
    private String description;
    private boolean isComplete;
    private static int counter=0;

    public TodoTask(String description){
        this.description = description;
        this.isComplete = false;
        this.iD = ++counter;
    }

    public String getDescription(){
        return description;
    }

    public int getID(){
        return iD;
    }

    public boolean isComplete(){
        return isComplete;
    }

    public void markComplete(){
        isComplete = true;
    }
}
