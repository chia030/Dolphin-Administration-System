import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class ResultsList {

    //making an array list
    public ArrayList<Result> results = new ArrayList<Result>();
    
    public ResultsList() { 
        ArrayList<Result> results = new ArrayList();        
        loadResults(); 
       }
    
    public ResultsList(boolean help) { 
        ArrayList<Result> results = new ArrayList();        
       }

    public ArrayList<Result> getResults(){
        return results;
    }

    public Result getIndex(int i){
        return results.get(i);
    }

    public int getSize(){
        return results.size();
    }
    
    public void enterResult(ResultsList rl) {
        
        Scanner scan = new Scanner(System.in);
        
        rl.addResult(new Result(scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine()));
        rl.saveToFile();

    }

    public void swap(){
        int n = results.size();
        for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (Double.parseDouble(results.get(j).getTime()) < Double.parseDouble(results.get(j + 1).getTime())) {
                Result temp = results.get(j);
                results.set(j, results.get(j + 1));
                results.set(j + 1, temp);
            }
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
                addResult(new Result(read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace(); //priting out current error
        }
    }

    //save ResultsList to file
    public void saveToFile(){
        try { 
            PrintStream write = new PrintStream(new File("Results.txt"));
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

    public void printResults(){
        for (int i = 0; i < results.size(); i++){
           System.out.println(results.get(i).toString());
        }
     }

    
}