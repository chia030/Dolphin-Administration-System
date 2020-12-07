import java.io.*;
import java.util.*;
import java.time.*;

public class ResultsList {

   PrintWriter writer = null;
   FileWriter fw = null;

    //making an array list
    private ArrayList<Result> results;
    private ArrayList<Result> sortedResults;
    
    //constructor when creating a main arraylist
    public ResultsList() {
        
        File file = new File(DAS.RESULTLISTFILE);
        resultsFile();
        results = new ArrayList<Result>(); 
        sortedResults = new ArrayList<Result>();     
        loadResults(file);
        sortList(); 
        
       }
    
    //constructor when making a results list for separate disciplines
//     public ResultsList(boolean help) { 
//         results = new ArrayList<Result>();        
//        }

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
        

    //adding results 
    public void addResult(Result result){
        results.add(result);
        sortedResults.add(result);
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
        

    public void sortList() {  

//             for (Result i: sortedResults) {
//                 for (Result j: sortedResults) { if (i.getTime() < j.getTime()) sortedResults.set(sortedResults.getIndex(i)-1, i);
//                                                 else if (i.getTime() == j.getTime()) sortedResults.set(sortedResults.getIndex(i), i);
//                                                 else sortedResults.set(sortedResults.getIndex(i)+1, i);
// 
//             }
//             }

        Collections.sort(sortedResults, (a, b) -> a.time < b.time ? -1 : a.time == b.time ? 0 : 1);
    
    }
    
    
    public void getRank(Result r) {
        
        int j = 1;
    
        for (Result i: sortedResults) {
            if (i.getDiscipline()==r.getDiscipline() && i.getDistance()==r.getDistance()) {
                System.out.println(j+". "+i);
                j++;
            }
        }
    
    }
    
    public void getTop5(Result r) {
    
        for(int i=0;i<=4;i++) { 
            if (sortedResults.get(i).getDiscipline()==r.getDiscipline() && sortedResults.get(i).getDistance()==r.getDistance()) {
                System.out.println(i+" "+sortedResults.get(i)); 
            }
        }

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
    
    //delete results from both results lists
    public void deleteResult(int ID){
        for(Result i: results){
            for (Result j: sortedResults) {
                if (i.getID() == ID){
                    this.results.remove(i);
                }
            }
        }   
    }

    //print all results
    public void printResultList(ArrayList<Result> rl){
        for (Result i: rl){
           System.out.println(i);
        }
     }
     
     public void printResults(){
        for (Result i: results){
           System.out.println(i);
        }
     }

    
}