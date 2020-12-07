import java.util.*;
import java.io.*;

public class Coach extends Employee {


     public Coach() {

        super(UserType.COACH);
     
     }
     
     //make an arraylist of coaches


     //entering results
     /*public void enterResult(){
        Scanner scan = new Scanner(System.in);
        MemberList ml = new MemberList();

        rl.addResult(new Result());
        System.out.println("Enter Type(Competition/Training)");
        rl.getIndex(()-1).setType(scan.nextLine());
        System.out.println("Enter ID");
        rl.getIndex(getSize()-1).setID(scan.nextLine());

        for(int i=0;i<ml.getSize();i++){
            if(ml.getIndex(i).getID()==Integer.valueOf(rl.getIndex(getSize()-1).getID())){
                rl.getIndex(getSize()-1).setName(ml.getIndex(i).getName());
            }
        }
        System.out.println("Enter Distance(100m/200m/400m)");
        rl.getIndex(getSize()-1).setDiscipline(scan.nextLine());

        System.out.println("Enter Time(Format minute.second)");
        rl.getIndex(getSize()-1).setTime(scan.nextLine());

        System.out.println("Enter Discipline(breaststroke,front crawl,backstroke,butterfly)");
        rl.getIndex(getSize()-1).setDiscipline(scan.nextLine());

        rl.getIndex(getSize()-1).setDate();
        scan.close();
        rl.saveToFile();
    }***/


    public void enterResult(Result r, ResultsList rl) {
    
        Result result = new Result(r.getID(), r.getType(), r.getDistance(), r.getTime(), r.getDiscipline());
        rl.addResult(result);
    
    }
     
    //viewin all the results
    public void viewResults(ResultsList rl){
        rl.printResults();
    }
    
    
    public void viewTop5(Result r, ResultsList rl) {
            
            rl.getTop5(r);
    }
    
    public void viewDisciplineRank(Result r, ResultsList rl) {
            
           rl.getRank(r);
    }
}
