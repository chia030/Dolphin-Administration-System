import java.util.ArrayList;
import java.io.*; 
import java.util.*;

public class Coach extends Employee {


     public Coach() {

        super(UserType.COACH);
     
     }

    public void enterResult(String name,int distance,String time, String discipline) {

       Result r = new Result(name, distance, time, discipline);
//     results.addResult(r); //this will probably be moved to the main
    
    }

}