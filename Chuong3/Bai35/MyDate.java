package Bai35;

public class MyDate {
    private int year;
    private int month;
    private int day;

    private static final String[] MONTHS = 
        {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    
    private static final String[] DAYS = 
        {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    private static final int[] DAYS_IN_MONTHS = 
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    
    public MyDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Ngay khong hop le");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

   
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

   
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12) {
            return false;
        }
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        return day >= 1 && day <= maxDay;
    }

  
    public static int getDayOfWeek(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Ngay khong hop le");
        }
        int[] monthOffset = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year -= 1;
        }
        return (year + year / 4 - year / 100 + year / 400 + monthOffset[month - 1] + day) % 7;
    }


    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

   
    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 1 || year > 9999) throw new IllegalArgumentException("Nam khong hop le");
        this.year = year;
    }

   
    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Thang khong hop le");
        this.month = month;
    }

    
    public int getDay() { return day; }
    public void setDay(int day) {
        if (!isValidDate(this.year, this.month, day)) throw new IllegalArgumentException("Ngay khong hop le");
        this.day = day;
    }

   
    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else if (month < 12) {
            month++;
            day = 1;
        } else {
            year++;
            month = 1;
            day = 1;
        }
        return this;
    }

   
    public MyDate previousDay() {
        if (isValidDate(year, month, day - 1)) {
            day--;
        } else if (month > 1) {
            month--;
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        } else {
            year--;
            month = 12;
            day = 31;
        }
        return this;
    }

   
    public MyDate nextMonth() {
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }
        if (!isValidDate(year, month, day)) {
            day = DAYS_IN_MONTHS[month - 1];
        }
        return this;
    }

   
    public MyDate previousMonth() {
        if (month == 1) {
            year--;
            month = 12;
        } else {
            month--;
        }
        if (!isValidDate(year, month, day)) {
            day = DAYS_IN_MONTHS[month - 1];
        }
        return this;
    }

   
    public MyDate nextYear() {
        if (year < 9999) {
            year++;
            if (!isValidDate(year, month, day)) {
                day = DAYS_IN_MONTHS[month - 1];
            }
        }
        return this;
    }

    public MyDate previousYear() {
        if (year > 1) {
            year--;
            if (!isValidDate(year, month, day)) {
                day = DAYS_IN_MONTHS[month - 1];
            }
        }
        return this;
    }
}
