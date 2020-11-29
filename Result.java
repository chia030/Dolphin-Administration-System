import java.time.format.DateTimeFormatter;
import java.time.*;

public class Result {
    private int distance;   
    private String name;
    private String time;
    private String date;
    private String discipline;

    //constructor when creating a result
    public Result(String name,int distance,String time, String discipline){
        this.distance = distance;
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        setDate();
    }

    //constructor when reading from a file
    public Result(String name, String date, String time, String distance,String discipline){
        this.distance = Integer.parseInt(distance);
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        this.date = date;
    }


    //getters and setters
    public void setDistance(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
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
        return getName()+" \n"+getDate()+"\n"+getTime()+"\n"+getDistance()+"\n"+getDiscipline();
    }

}
