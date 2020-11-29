import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class ResultsList {

    //making an array list
    private ArrayList<Result> results;

    //adding results 
    //not sure to leave it like this and fuck around with the scanner later or if to implement the scanner now
    //i guess we will discuss on monday
    public void addResult(Result result){
        results.add(result);
    }

    //loading results from file to results list
    public void loadResults(){ 
        try { 
            Scanner read = new Scanner(new File("RESULTS.TXT"));
            while (read.hasNextLine()){
                results.add(new Result(read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine(),read.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace(); //priting our current error
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

    //when a member is removed it would be usefull to deelete all their results
    //maybe should work with their name or member id, ill change it upon discussion
    public void deleteResult(int index){
        results.remove(index);    
    }

    
}
