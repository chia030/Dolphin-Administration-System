import java.util.*;
import java.io.*;

public class Coach extends Employee {


     public Coach() throws FileNotFoundException {

        super(UserType.COACH);
     
     }

     //entering results
     public void enterResult(){ //this is missing :(
    }
     
    //viewin all the results
    public void viewResults(ResultsList rl){
        rl.printResults();
    }
    
    //viewin top 5 swimmers based on training/competition and later on based on entered discipline
    public void seeTop(MemberList ml, ResultsList rl) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in); //the scanner doesn't work here, move this stuff to the DAS_INTERFACE 
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
                        System.out.println("Top Swimmers of front crawl in 100 m are:");
                        front.printResults();
                        System.out.println("Top Swimmers of front crawl in 200 m are:");
                        front2.printResults();
                        System.out.println("Top Swimmers of front crawl in 400 m are:");
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
                        System.out.println("Top Swimmers of backstroke in 100 m are:");
                        back.printResults();
                        System.out.println("Top Swimmers of backstroke in 200 m are:");
                        back2.printResults();
                        System.out.println("Top Swimmers of backstroke in 400 m are:");
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
                        System.out.println("Top Swimmers of butterfly in 100 m are:");
                        butterfly.printResults();
                        System.out.println("Top Swimmers of butterfly in 200 m are:");
                        butterfly2.printResults();
                        System.out.println("Top Swimmers of butterfly in 400 m are:");
                        butterfly4.printResults();
                        break;
                    default : System.out.println("Wrong discipline entered");
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
                        System.out.println("Top Swimmers of breaststroke in 100 m are:");
                        breast.printResults();
                        System.out.println("Top Swimmers of breaststroke in 200 m are:");
                        breast2.printResults();
                        System.out.println("Top Swimmers of breaststroke in 400 m are:");
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
                        System.out.println("Top Swimmers of front crawl in 100 m are:");
                        front.printResults();
                        System.out.println("Top Swimmers of front crawl in 200 m are:");
                        front2.printResults();
                        System.out.println("Top Swimmers of front crawl in 400 m are:");
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
                        System.out.println("Top Swimmers of backstroke in 100 m are:");
                        back.printResults();
                        System.out.println("Top Swimmers of backstroke in 200 m are:");
                        back2.printResults();
                        System.out.println("Top Swimmers of backstroke in 400 m are:");
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
                        System.out.println("Top Swimmers of butterfly in 100 m are:");
                        butterfly.printResults();
                        System.out.println("Top Swimmers of butterfly in 200 m are:");
                        butterfly2.printResults();
                        System.out.println("Top Swimmers of butterfly in 400 m are:");
                        butterfly4.printResults();
                        break;}
                    default : System.out.println("Wrong discipline entered");
                    }
        }
        }scan.close();   

    }
}
