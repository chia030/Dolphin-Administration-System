import java.time.format.DateTimeFormatter;
import java.time.*;

public class Result {
    private String distance;   
    private String name;
    private String time;
    private String date;
    private String discipline;
    private String ID;

    //constructor when creating a result
    public Result(String name, String ID, String distance,String time, String discipline){
        this.distance = distance;
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        setDate();
    }

    //constructor when reading from a file
    public Result(String name, String ID, String date, String time, String distance,String discipline){
        this.distance = distance;
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        this.date = date;
    }


    //getters and setters
    public void setDistance(String distance){
        this.distance = distance;
    }

    public String getDistance(){
        return distance;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTime(String time){
        this.time = time;    
    }

    public String getTime(){
        return time;
    }

    public void setDate(){
        date = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
    }

    public String getDate(){
        return date;
    }

    public void setDiscipline(String discipline){
        this.discipline = discipline;
    }

    public String getDiscipline(){
        return discipline;
    }

    public String toString(){
        return getName()+" \n"+getID()+"\n"+getDate()+"\n"+getTime()+"\n"+getDistance()+"\n"+getDiscipline();
    }

}
