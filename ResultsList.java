import java.io.*;
import java.util.*;
import java.time.*;

public class ResultsList {

   PrintWriter writer = null;
   FileWriter fw = null;

    //making an array list
    private ArrayList<Result> results;
    
    //constructor when creating a main arraylist
    public ResultsList() {
        
        File file = new File(DAS.RESULTLISTFILE);
        resultsFile();
        results = new ArrayList<Result>();        
        loadResults(file); 
        
       }
    
    //constructor when making a results list for separate disciplines
    public ResultsList(boolean help) { 
        results = new ArrayList<Result>();        
       }

    //method to get results
    public ArrayList<Result> getResults(){
        return results;
    }

    //method to get result at an index
    public Result getIndex(int i){
        return results.get(i);
    }

    //method to get size of results list
    public int getSize(){
        return results.size();
    }
        

//     //method to enter result
//     public void enterResult(ResultsList rl, MemberList ml) throws FileNotFoundException {
//         
//  
//         rl.addResult(new Result());
//         System.out.println("Enter Type(Competition/Training)");
//         rl.getIndex(getSize()-1).setType(scan.nextLine());
//         System.out.println("Enter ID");
//         rl.getIndex(getSize()-1).setID(scan.nextLine());
// 
//         for(int i=0;i<ml.getSize();i++){
//             if(ml.getIndex(i).getID()==Integer.valueOf(rl.getIndex(getSize()-1).getID())){
//                 rl.getIndex(getSize()-1).setName(ml.getIndex(i).getName());
//             }
//         }
//         System.out.println("Enter Distance(100m/200m/400m)");
//         rl.getIndex(getSize()-1).setDiscipline(scan.nextLine());
// 
//         System.out.println("Enter Time(Format minute.second)");
//         rl.getIndex(getSize()-1).setTime(scan.nextLine());
// 
//         System.out.println("Enter Discipline(breaststroke,front crawl,backstroke,butterfly)");
//         rl.getIndex(getSize()-1).setDiscipline(scan.nextLine());
// 
//         rl.getIndex(getSize()-1).setDate();
//         scan.close();
//         rl.saveToFile();
// 
//     }

//     sort the results list from quickest time to longest
//     public void swap(){
//         int n = results.size();
//         for (int i = 0; i < n - 1; i++) {
//         for (int j = 0; j < n - i - 1; j++) {
//             if (Double.parseDouble(results.get(j).getTime()) < Double.parseDouble(results.get(j + 1).getTime())) {
//                 Result temp = results.get(j);
//                 results.set(j, results.get(j + 1));
//                 results.set(j + 1, temp);
//             }
//         }
//         }
//     }
    

    //adding results 
    public void addResult(Result result){
        results.add(result);
    }
    
    public void resultsFile() {
    
        try {
            fw = new FileWriter(DAS.RESULTLISTFILE, true);
        } catch (Exception e) { e.printStackTrace(); }     
    
    }

    //loading results from file to results list
    public void loadResults(File f) {
    
        try { 

            Scanner scan = new Scanner(f);
            scan.useDelimiter("\s|\r\n"); // \s = space OR \r = end of line, \n = new line
            
            
            while (scan.hasNext()){
                addResult(
                new Result(scan.nextInt(), //id
                scan.nextBoolean(), //iscompetitive?
                scan.nextInt(), //distance
                scan.nextDouble(), //time
                scan.nextInt(), //discipline
                LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()))); //date
            }
            
         } catch (Exception e) { e.printStackTrace(); } 

        }



    //save ResultsList to file when closing the program
    public void saveToFile(){
    
    
      try {
          fw = new FileWriter(DAS.RESULTLISTFILE, false);
          writer = new PrintWriter(fw);
      } catch (Exception e) { e.printStackTrace(); }
      
      
      for (Result i: results) {
            writer.println(i.toFile());
      }
      
      writer.close();      
        
    }
    
    //delete results from results list
    public void deleteResult(int ID){
        for(Result i: results){
            if (i.getID() == ID){
                results.remove(i);
            }
        }   
    }

    //print all results to console
    public void printResults(){
        for (Result i: results){
           System.out.println(i);
        }
     }

//     print top 5 results
//     public void printTopResults(){
//         swap();
//         for(int i=0;i<=4;i++){
//             System.out.println(results.get(i));    
//         }
//     } 

    
}