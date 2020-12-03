import java.util.*;

public class Coach extends Employee {


     public Coach() {

        super(UserType.COACH);
     
     }

     ResultsList rl = new ResultsList();

     public void enterResult() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please input : Name, ID, distance, time, discipline.");

        rl.addResult(new Result(scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine()));
        rl.saveToFile();
        
        scan.close();

    }

    public void viewResults(){
        rl.printResults();
    }
      

    public void seeTop(){
        rl.loadResults();
        ResultsList breast = new ResultsList(false);
        ResultsList breast2 = new ResultsList(false);
        ResultsList breast4 = new ResultsList(false);
        ResultsList front2 = new ResultsList(false);
        ResultsList front = new ResultsList(false);
        ResultsList front4 = new ResultsList(false);
        ResultsList back = new ResultsList(false);
        ResultsList back2 = new ResultsList(false);
        ResultsList back4 = new ResultsList(false);
        ResultsList butterfly = new ResultsList(false);
        ResultsList butterfly2 = new ResultsList(false);
        ResultsList butterfly4 = new ResultsList(false);

        for(int i=0; i<=rl.getSize();i++){
            switch(rl.getIndex(i).getDiscipline()){

                case "breaststroke": 
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==100){breast.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==200){breast2.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==400){breast4.addResult(rl.getIndex(i));}
                    break;

                case "front crawl": 
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==100){front.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==200){front2.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==400){front4.addResult(rl.getIndex(i));}
                    break;
                
                case "backstroke": 
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==100){back.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==200){back2.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==400){back4.addResult(rl.getIndex(i));}
                    break;

                case "butterfly": 
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==100){butterfly.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==200){butterfly2.addResult(rl.getIndex(i));}
                    if (Integer.parseInt(rl.getIndex(i).getDistance())==400){butterfly4.addResult(rl.getIndex(i));}
                    break;
                default : System.out.println("Wrong discipline is entered in the results.");
            }
        }

            breast.swap();
            breast2.swap();
            breast4.swap();
            front.swap();
            front2.swap();
            front4.swap();
            back.swap();
            back2.swap();
            back4.swap();
            butterfly.swap();
            butterfly2.swap();
            butterfly4.swap();
            System.out.println("Top Swimmers of breaststroke in 100 m are!");
            breast.printResults();
            System.out.println("Top Swimmers of breaststroke in 200 m are!");
            breast2.printResults();
            System.out.println("Top Swimmers of breaststroke in 400 m are!");
            breast4.printResults();
            System.out.println("Top Swimmers of front crawl in 100 m are!");
            front.printResults();
            System.out.println("Top Swimmers of front crawl in 200 m are!");
            front2.printResults();
            System.out.println("Top Swimmers of front crawl in 400 m are!");
            front4.printResults();
            System.out.println("Top Swimmers of backstroke in 100 m are!");
            back.printResults();
            System.out.println("Top Swimmers of backstroke in 200 m are!");
            back2.printResults();
            System.out.println("Top Swimmers of backstroke in 400 m are!");
            back4.printResults();
            System.out.println("Top Swimmers of butterfly in 100 m are!");
            butterfly.printResults();
            System.out.println("Top Swimmers of butterfly in 200 m are!");
            butterfly2.printResults();
            System.out.println("Top Swimmers of butterfly in 400 m are!");
            butterfly4.printResults();

    }
}
