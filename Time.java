import java.util.*;
public class Time{
     //fields
    private int hours;
    private int minutes;
    private int seconds;
    //alternate constructor
    public Time(){
        this(0,0,0);
    }
    //default constructor
    public Time(int hours, int minutes, int seconds){
        set(hours, minutes, seconds);
    }
    //getters for hours, minutes, seconds
    public int getHours(){
        return hours;
    }
    public int getMintues(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    //set hours, minutes, seconds method, invalid values = 0 
    public void set(int hours, int minutes, int seconds){
        if(hours >= 0 && hours < 24){
            this.hours = hours;
        }
        else{
            this.hours = 0;
        }
        if(minutes >= 0 && minutes < 60){
            this.minutes = minutes;
        }
        else{
            this.minutes = 0;
        }
        if(seconds >= 0 && seconds < 60){
            this.seconds = seconds;
        }
        else{
            this.seconds = 0;
        }
    }
    //toString
    public String toString(){
        return hours + ":" + minutes + ":" + seconds;
    } 
    //print military time and standard time
    public void militaryTime(){
        if(hours == 0){
            System.out.printf("12:%02d:%02d", hours, minutes, seconds);
        }
        else{
            System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

    public void standardTime(){
        String amOrPm;
        if (hours < 12){
            amOrPm = " AM";
        }
        else{
            amOrPm = " PM";
        }
        if(hours > 12){
            System.out.printf("%02d:%02d:%02d%s", (hours - 12), minutes, seconds, amOrPm);
        }
        else{
            if (hours == 0){
                System.out.printf("12:%02d:%02d%s", minutes, seconds, amOrPm);
            }
            else{
                System.out.printf("%02d:%02d:%02d%s", hours, minutes, seconds, amOrPm);
            }
            
        }
    }

    //return military
    public String toMilitary(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toStandard(){
        String amOrPm;
        if (hours < 12){
            amOrPm = "AM";
        }
        else{
            amOrPm = "PM";
        }
        if (hours > 12){
            return String.format("%02d:%02d:%02d %s", (hours - 12), minutes, seconds, amOrPm);
        }
        else{
            return String.format("%02d:%02d:%02d %s", hours, minutes, seconds, amOrPm);
        }

    }
    //equals method
    public Boolean equals(Time otherTime){
        return (this.hours == otherTime.hours) && (this.minutes == otherTime.minutes) && (this.seconds == otherTime.seconds);
    }
    //copy method
    public void copy(Time otherTime){
        this.hours = otherTime.hours;
        this.minutes = otherTime.minutes;
        this.seconds = otherTime.seconds;
    }
    //the copy method
    public Time getCopy(){
        return new Time(hours, minutes, seconds);
    }

    //advance the secondsd method
    public void advanceSeconds(int s){
        if (s < 0){
            return;
        }
        int total = seconds + s;
        advanceMinutes(total/60);
        seconds = total % 60;
    }

    public void advanceSeconds(){
        advanceSeconds(1);
    }
    //advance hours
    public void advanceHours(int h){
        if (h < 0){
            return;
        }
        hours = (hours + h) %24;
    }

    //advance minutes
    public void advanceMinutes(int m){
        if (m < 0){
            return;
        }
        int total = minutes + m;
        advanceHours(total / 60);
        minutes = total % 60;
    }
    //less than method 
    public boolean lessThan(Time otherTime){
        if (this.hours < otherTime.hours){
            return true;
        }
        if(this.hours == otherTime.hours && this.minutes == otherTime.minutes){
            return true;
        }
        return this.hours == otherTime.hours && this.minutes == otherTime.minutes && this.seconds ==otherTime.minutes;
    }

    //not equal method
    public boolean notoEquals(Time otherTime){
        return !this.equals(otherTime);
    }

    //less or equal
    public boolean lessOrEquals(Time otherTime){
        return this.lessThan(otherTime) || this.equals(otherTime);
    }

    //greater than
    public boolean greaterThan(Time otherTime){
        return !this.lessOrEquals(otherTime);
    }

    public boolean greaterOrEquals(Time otherTime){
        return !this.lessThan(otherTime);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Time t1 = new Time(4,50, 23);
        Time t2 = new Time();
        System.out.print("Initial time t1 (alternate constructor invoked) - military format: ");
        t1.militaryTime();
        System.out.println();
        System.out.print("Initial time t1 (alternate constructor invoked)- standard time format: ");
        t1.standardTime();
        System.out.println();
        System.out.print("Initial time t2 (default constructor invoked) - military format: ");
        t2.militaryTime();
        System.out.println();
        System.out.print("Initial time t2 (default constructor invoked) - standard time format: ");
        t2.standardTime();
        System.out.println();
        t2.set(9, 43, 23);
        System.out.print("t2 after call to set- military format: ");
        t2.militaryTime();
        System.out.print("t2 after call to set- standard time format: ");
        t2.standardTime();

        System.out.println("After call to lessThan: ");
        if(t1.lessThan(t2)){
            System.out.println("t1 is less than t2");
        } else{
            System.out.println("t1 is not less than t2");
        }

        System.out.print("Enter hours, minutes, and seconds: ");
        int h = scan.nextInt();
        int m = scan.nextInt();
        int s = scan.nextInt();
        t1.set(h, m, s);

        System.out.println("New time t1 after call to set - standard format: ");
        t1.standardTime();

        t2.copy(t1);
        System.out.print("New t2 after call to copy - standard format: ");
        t2.standardTime();
        System.out.println();
        System.out.print("Test toString for t2: " + t2.toString());

    
    }
}
