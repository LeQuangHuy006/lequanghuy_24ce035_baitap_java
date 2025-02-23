package Bai34;

public class MyTime {
   
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    
    public MyTime() {
    }

   
    public MyTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

   
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

   
    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        }
    }

 
    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

  
  
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

  
    public MyTime nextSecond() {
        second++;
        if (second >= 60) {
            second = 0;
            nextMinute();
        }
        return this;
    }

   
    public MyTime nextMinute() {
        minute++;
        if (minute >= 60) {
            minute = 0;
            nextHour();
        }
        return this;
    }

  
    public MyTime nextHour() {
        hour = (hour + 1) % 24;
        return this;
    }

  
    public MyTime previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            previousMinute();
        }
        return this;
    }

   
    public MyTime previousMinute() {
        minute--;
        if (minute < 0) {
            minute = 59;
            previousHour();
        }
        return this;
    }

   
    public MyTime previousHour() {
        hour = (hour - 1 + 24) % 24;
        return this;
    }
}
