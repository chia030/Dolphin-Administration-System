import java.util.*;
import java.io.*;

public class Coach extends Employee {


     public Coach() throws FileNotFoundException {

        super(UserType.COACH);
     
     }

     ResultsList rl = new ResultsList();

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

    //public void newResult(){}

    //viewin all the results
    public void viewResults(){
        rl.printResults();
    }
    
    //viewin top 5 swimmers based on training/competition and later on based on entered discipline
    public void seeTop() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        switch(scan.nextLine()){
            case "competition" : 
                switch(scan.nextLine()){
                    case "breaststroke" :
                        ResultsList breast = new ResultsList(false);
                        ResultsList breast2 = new ResultsList(false);
                        ResultsList breast4 = new ResultsList(false); 
                        for(int i=0; i<=rl.getSize();i++){
                        
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){breast.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){breast2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){breast4.addResult(rl.getIndex(i));}
                            
                        }
                        
                        System.out.println("Top Swimmers of breaststroke in 100 m are!");
                        breast.printResults();
                        System.out.println("Top Swimmers of breaststroke in 200 m are!");
                        breast2.printResults();
                        System.out.println("Top Swimmers of breaststroke in 400 m are!");
                        breast4.printResults();
                    break;    
                    case "front crawl" :
                        ResultsList front2 = new ResultsList(false);
                        ResultsList front = new ResultsList(false);
                        ResultsList front4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){front.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){front2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){front4.addResult(rl.getIndex(i));}    
                        }
                        System.out.println("Top Swimmers of front crawl in 100 m are!");
                        front.printResults();
                        System.out.println("Top Swimmers of front crawl in 200 m are!");
                        front2.printResults();
                        System.out.println("Top Swimmers of front crawl in 400 m are!");
                        front4.printResults();
                        break;
                    
                    case "backstroke" :
                        ResultsList back = new ResultsList(false);
                        ResultsList back2 = new ResultsList(false);
                        ResultsList back4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){back.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){back2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){back4.addResult(rl.getIndex(i));}
                        }
                        System.out.println("Top Swimmers of backstroke in 100 m are!");
                        back.printResults();
                        System.out.println("Top Swimmers of backstroke in 200 m are!");
                        back2.printResults();
                        System.out.println("Top Swimmers of backstroke in 400 m are!");
                        back4.printResults();
                        break;
        
                    case "butterfly" :
                        ResultsList butterfly = new ResultsList(false);
                        ResultsList butterfly2 = new ResultsList(false);
                        ResultsList butterfly4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){butterfly.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){butterfly2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){butterfly4.addResult(rl.getIndex(i));}
                        }
                        System.out.println("Top Swimmers of butterfly in 100 m are!");
                        butterfly.printResults();
                        System.out.println("Top Swimmers of butterfly in 200 m are!");
                        butterfly2.printResults();
                        System.out.println("Top Swimmers of butterfly in 400 m are!");
                        butterfly4.printResults();
                        break;
                    default : System.out.println("Wrong discpipline entered");
                }
            case "training" :{
                switch(scan.nextLine()){
                    case "breaststroke" :
                        ResultsList breast = new ResultsList(false);
                        ResultsList breast2 = new ResultsList(false);
                        ResultsList breast4 = new ResultsList(false); 
                        for(int i=0; i<=rl.getSize();i++){
                        
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){breast.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){breast2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){breast4.addResult(rl.getIndex(i));}
                        }
                        System.out.println("Top Swimmers of breaststroke in 100 m are!");
                        breast.printResults();
                        System.out.println("Top Swimmers of breaststroke in 200 m are!");
                        breast2.printResults();
                        System.out.println("Top Swimmers of breaststroke in 400 m are!");
                        breast4.printResults();
                    break;    
                    case "front crawl" :
                        ResultsList front2 = new ResultsList(false);
                        ResultsList front = new ResultsList(false);
                        ResultsList front4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){front.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){front2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){front4.addResult(rl.getIndex(i));}    
                        }
                        System.out.println("Top Swimmers of front crawl in 100 m are!");
                        front.printResults();
                        System.out.println("Top Swimmers of front crawl in 200 m are!");
                        front2.printResults();
                        System.out.println("Top Swimmers of front crawl in 400 m are!");
                        front4.printResults();
                        break;
                    
                    case "backstroke" :
                        ResultsList back = new ResultsList(false);
                        ResultsList back2 = new ResultsList(false);
                        ResultsList back4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){back.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){back2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){back4.addResult(rl.getIndex(i));}
                        }
                        System.out.println("Top Swimmers of backstroke in 100 m are!");
                        back.printResults();
                        System.out.println("Top Swimmers of backstroke in 200 m are!");
                        back2.printResults();
                        System.out.println("Top Swimmers of backstroke in 400 m are!");
                        back4.printResults();
                        break;
        
                    case "butterfly" :{
                        ResultsList butterfly = new ResultsList(false);
                        ResultsList butterfly2 = new ResultsList(false);
                        ResultsList butterfly4 = new ResultsList(false);
                        for(int i=0; i<=rl.getSize();i++){
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==100){butterfly.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==200){butterfly2.addResult(rl.getIndex(i));}
                            if (Integer.parseInt(rl.getIndex(i).getDistance())==400){butterfly4.addResult(rl.getIndex(i));}
                        }
                        System.out.println("Top Swimmers of butterfly in 100 m are!");
                        butterfly.printResults();
                        System.out.println("Top Swimmers of butterfly in 200 m are!");
                        butterfly2.printResults();
                        System.out.println("Top Swimmers of butterfly in 400 m are!");
                        butterfly4.printResults();
                        break;}
                    default : System.out.println("Wrong discpipline entered");
                    }
        }
        }scan.close();   

    }
}
