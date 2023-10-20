#include<iostream>
#include<string>
#include<vector>
#include<fstream>

using namespace std;
int id = 1;



struct todo // structure for todo list
    {
        int iD;
        string description;
        bool completed;

    };

vector<todo> tasks; // dynamic list to store tasks


int addTask(){
    todo addTask;
    cout<< "Enter Task Description \n";
    cin.ignore();
    getline(std::cin, addTask.description);
    addTask.completed = false;
    addTask.iD = id++;
    tasks.push_back(addTask);
    cout<< "Task Entered \n";
    return 0;


}

void listTask(){
    cout<< "The list of tasks are : \n";
    for (size_t i = 0; i < tasks.size(); i++){  
        cout<<tasks[i].iD << "\t" <<tasks[i].description << "\t";
        if (tasks[i].completed)
        {
            cout << "Completed" << endl;
        }

        else
        {
            cout << "Not Completed" << endl;
        } 
        
    }
    
}

void completeTask(){

    int task_no;

    cout<< "Enter the task id to be marked completed \n";
    cin>>task_no;

    if (task_no > tasks.size())
    {
        cout<< "No task present. Please check task list and try again \n";
    }
    else if (tasks[task_no-1].completed) {
        cout<< "Task already marked as completed \n";
    }

    else{
        tasks[task_no-1].completed = true;
        cout<< "Task Marked as complete \n" ;

    }


}



int main(){
    int option;

    fstream todolist;
    todolist.open("To-Do_List.txt",ios::out);
    todolist<< "------------------To-Do List------------------" << endl;
    todolist<<"Task ID" << "\t \t" << "Description" << "\t \t" << "Task Status" << "\t \t" <<endl;

    while(true){
        cout<< "To-Do List Application \n" ;
        cout<< "1. Enter Task \n" ;
        cout<< "2. List Tasks \n" ;
        cout<< "3. Mark task as complete \n" ;
        cout<< "4. Quit \n" ;
        cout<< "Enter your choice : \n";
        cin>>option;


        switch (option)
        {
        case 1:
            addTask();
            break;
        case 2:
            listTask();
            break;
        case 3:
            completeTask();
            break;
        case 4:
            for (size_t i = 0; i < tasks.size(); i++)
            {
                todolist<<tasks[i].iD << "\t \t" <<tasks[i].description << "\t \t" ;
                if (tasks[i].completed){
                    todolist << "Completed" << endl;
                }

                else{
                    todolist << "Not Completed" << endl;
                } 
            }
            
            todolist.close();
            return 0;
        
        default:
            cout<< "Invalid choice, please select between options 1 - 4 \n";
        }

    }

    return 0;
}

