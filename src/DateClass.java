
public class DateClass {
    private final int month ;
    private final int year;
    private final int day;
    private final int[] monthInYear = {0,31,28,31,30,31,30,31,31,30,31,30,31};




    public DateClass(int day,int month,int year){
        if(month<1 || month>12){
            throw new IllegalArgumentException("month must be of range 1-12 ");
        }else{
            this.month = month;
        }

        if (day <= 0 || (day > monthInYear[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }

        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }else{
            this.day = day;
        }
            if (year < 2023 || year > 2024) {
                throw new IllegalArgumentException("Enter valid Year Please\n year must either previous Year of present Year ");
            } else {
                this.year = year;
            }


    }


    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getDay(){
        return day;
    }

}
