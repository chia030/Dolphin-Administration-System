import java.io.*;
import java.util.*;

public class ResultsList {

   PrintWriter writer = null;
   FileWriter fw = null;

    //making an array list
    private ArrayList<Result> results;
    
    //constructor when creating a main arraylist
    public ResultsList() {
    
        resultsFile();
        ArrayList<Result> results = new ArrayList();        
        loadResults(); 
        
       }
    
    //constructor when making a results list for separate disciplines
    public ResultsList(boolean help) { 
        ArrayList<Result> results = new ArrayList();        
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
        

    //sort the results list from quickest time to longest
    public void swap(){
        int n = results.size();
        for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (Double.parseDouble(results.get(j).getTime()) < Double.parseDouble(results.get(j + 1).getTime())) {
                Result temp = results.get(j);
                results.set(j, results.get(j + 1));
                results.set(j + 1, temp);
            }
        }
        }
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
    public void loadResults() { 
    
        try { 
            Scanner read = new Scanner(DAS.RESULTLISTFILE);
            while (read.hasNextLine()){
                addResult(new Result(read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace(); //priting our current error
        }
    }


    //save ResultsList to file when closing the program
    public void saveToFile(){
    
    
      try {
          fw = new FileWriter(DAS.RESULTLISTFILE, false);
          writer = new PrintWriter(fw);
      } catch (Exception e) { e.printStackTrace(); }
      
      
      for (Result i: results) {
            writer.println(i.toString());
      }
      
      writer.close();      
        
    }
    
    //delete results from results list
    public void deleteResult(String ID){
        for(Result i: results){
            if (i.getID().equals(ID)){
                results.remove(i);
            }
        }   
    }

    //print all results to console
    public void printResults(){
        for (Result i: results){
           System.out.println(i.toString());
        }
     }

    //print top 5 results
    public void printTopResults(){
        swap();
        for(int i=0;i<=4;i++){
            System.out.println(results.get(i).toString());    
        }
    } 

    
}