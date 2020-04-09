/*
This class takes user's inputted time in seconds and converts it to days, hours, minutes, and the remaining seconds.
 */
package as2;

public class time {
    
    //instance fields
    private double seconds;
    private double days;
    private double hours;
    private double minutes;
    private double secondsRemain;
    private double secondsRemain2;
    private double secondsRemain3;
    private int daysFinal;
    private int hoursFinal;
    private int minutesFinal;
    private double secondsFinal;
    
    //constants
    private final int seconds2days=86400;
    private final int seconds2hours=3600; //conversion factors from Google
    private final int seconds2minutes=60;
    
    //paramter constructor
    public time(double inSeconds)
    {
        seconds=inSeconds;
    }
    
    //accessors
    
    public int getDays()
    {
        secondsRemain = seconds%seconds2days;//remainder division to get seconds left over that could not be converted to whole days
        days = (seconds-secondsRemain)/seconds2days; //integer division to get the days in integer form from seconds
        daysFinal= (int) days; //convert to integer so that the miles won't have the unnecessary decimal of .0 when displaying it
        return daysFinal;
    }
    
    public int getHours()
    {
        secondsRemain2=secondsRemain%seconds2hours;//remainder division to get seconds left over not divisible into hours
        hours= (secondsRemain-secondsRemain2)/seconds2hours; //integer division to get hours in integer form from seconds
        hoursFinal= (int) hours; //removes unnecessary .0 for visual pleasure
        return hoursFinal;
    }
    
    public int getMinutes()
    {
        secondsRemain3=secondsRemain2%seconds2minutes;//remainder divisiont to get seconds left over not divisible to minutes
        minutes=(secondsRemain2-secondsRemain3)/seconds2minutes;//integer division to get minutes in integer form from seconds
        minutesFinal=(int) minutes;//removes unnecessary .0
        return minutesFinal;
    }
    
    public double getSeconds()
    {
        secondsFinal= secondsRemain3;
        return secondsFinal;
    }
  
    
}
