import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class ResultsList {

    //making an array list
    private ArrayList<Result> results;
    
    public ResultsList() { 
       /*results = new ArrayList<Results>(); No clue why this is here but it fuckes up the code so I commented it out*/
        loadResults(); 
       }

    //adding results 
    public void addResult(Result result){
        results.add(result);
    }

    //loading results from file to results list
    public void loadResults(){ 
        try { 
            Scanner read = new Scanner(new File("RESULTS.TXT"));
            while (read.hasNextLine()){
                /*results.add(new Result(read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine()));*/
                addResult(new Result(read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace(); //priting out current error
        }
    }

    //alphabetically sorting
    public void sortList(){
        Collections.sort(results, Comparator.comparing(Result::getName));
    }

    //save ResultsList to file
    public void saveToFile(){
        try { 
            PrintStream write = new PrintStream(new File("Results.txt"));
            sortList();
            for(int i=0;(i<=results.size()-1);i++){
                write.println(results.get(i).toString());
            }  
            write.close();
        } catch (Exception e) {
            e.printStackTrace(); //priting our current error
        }
        
    }
    
    public void deleteResult(String ID){
        for(int i=0;(i<=results.size()-1);i++){
            if (results.get(i).getID().equals(ID)){
                results.remove(i);
            }
        }   
    }

    
}
