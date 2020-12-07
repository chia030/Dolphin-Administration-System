import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class Result {


// new result vars
    
    public int ID;
    public boolean type; //true = competition, false = training
    public int distance;
    public LocalDate date;
    public double time;
    public int discipline;
    public String discipline2;
//    public Member mem; //is this needed??
    
    
    
    // enterResult() CONSTRUCTOR
    public Result(int ID, boolean type, int distance, double time, int discipline) {
    
        this.ID = ID;
        this.type = type;
        this.distance = distance;
        this.time = time;
        this.discipline = discipline;
        setDiscipline2(discipline);
        this.date = LocalDate.now();
    
    }
    
    //RESULTLIST CONSTRUCTOR
    public Result(int ID, boolean type, int distance, double time, int discipline, LocalDate date) {
    
        this.ID = ID;
        this.type = type;
        this.distance = distance;
        this.time = time;
        this.discipline = discipline;
        setDiscipline2(discipline);
        this.date = date;
    
    }
    //constructor needed when entering a result
    public Result(){}
 
    //getters and setters:
    public void setDistance(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }

    public void setType(boolean type){
        this.type = type;
    }

    public boolean getType(){
        return type;
    }
    
    // formatting the type``int`` into a readable String
    public String isCompetitive() {
    
        if (this.type) return "COMPETITIVE";
        return "TRAINING"; //if not
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }


    public void setTime(double time){
        this.time = time;    
    }

    public double getTime(){
        return time;
    }

    public void setDate(LocalDate d) {
        this.date = d;
    }


    public LocalDate getDate(){
        return date;
    }
    
    public void setDiscipline(int disc) {
    
        this.discipline = disc;
    
    }

    public void setDiscipline2(int d){
    
         switch (d) {
            case 1: this.discipline2 = "BREASTSTROKE"; break;
            case 2: this.discipline2 = "FRONTCRAWL"; break;
            case 3: this.discipline2 = "BACKSTROKE"; break;
            case 4: this.discipline2 = "BUTTERFLY"; break;        
        }
    }

    public int getDiscipline(){
        return discipline;
    }
    
    public String getDiscipline2() {
        return discipline2;    
    }
    
    public String formatDATE() {
    
        return DateTimeFormatter.ofPattern("yyyy MM dd").format(this.date);
    
    }
    
    public String newResultSummary(MemberList ml) {
    
        return "\n"+ml.findMember(this.ID).getName()+" (ID: "+this.ID+")\n"+this.isCompetitive()+"\n"+this.distance+"m\n"
               +this.time+" min\n"+this.discipline2+"\n\n\n";

    }


    public String toString() { //new toString()
    
        return this.ID+" "+this.isCompetitive()+" "+this.distance+"m "+this.time+" min "+this.discipline2+" "+this.date;
//         return "\n"+this.ID+" "+this.isCompetitive()+" "+this.distance+"m "+this.time+" min "+this.discipline2+" "+this.date+"\n\n\n";
    
    }
 
//  METHOD TO SAVE INFO INTO ResultsList.txt  
    public String toFile() {
        
        return this.ID+" "+this.type+" "+this.distance+" "+this.time+" "+this.discipline+" "+formatDATE();

    }
    
        public static Result compare(Result r1, Result r2) {
    
        double time1 = (r1.getTime()), time2 = (r2.getTime());
        
        if (time1 < time2) return r1;
        
        else if (time2 < time1) return r2;
        
        else return null;
    
    }

}
