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
        loadResults(file);
        sortedResults = new ArrayList<Result>();
        sortList(); 
        
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
        
    public Result compareResults() {
        
        for (Result i: results) {
            for (Result j: results) { if (i.getTime() < j.getTime()) return i; }
        }
        
        return null; //if there are no results in the list
    } 
    
    public void sortList() {  sortedResults.add(compareResults());   }
    
    
    public Result getRank(int distance, int discipline) {
    
        for (Result i: sortedResults) {
            if (i.getDiscipline()==discipline && i.getDistance()==distance) return i;
        }
        
        return null;
    
    }
    
    public Result getTop5(int distance, int discipline) {
    
        for(int i=0;i<=4;i++) { if ( sortedResults.get(i).getDiscipline()==discipline && sortedResults.get(i).getDistance()==distance) return sortedResults.get(i); }
        
        return null;
    
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
            for (Result j: sortedResults) {
                if (i.getID() == ID){
                    results.remove(i);
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