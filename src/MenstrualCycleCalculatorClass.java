import java.util.Calendar;
import java.text.SimpleDateFormat;
public class MenstrualCycleCalculatorClass {
    private   DateClass date ;
    private  final Calendar calendar= Calendar.getInstance();
    private  final SimpleDateFormat myDateFormat = new SimpleDateFormat("dd MMMM yyyy");

    private int periodDate;
    private int numberOfDaysForFlow;
    private int numberOfDaysCycleLast;

    private  int ovulationPeriod ;

   // private  int firstPeriodDay;


    public MenstrualCycleCalculatorClass(DateClass date){
        this.date = date;
        setCalendar();
    }
    public MenstrualCycleCalculatorClass(){

    }

    public void setCalendar(){
        calendar.set(Calendar.YEAR,date.getYear());
        calendar.set(Calendar.MONTH,date.getMonth()-1);
        calendar.set(Calendar.DAY_OF_MONTH,date.getDay());

    }



    public void setNumberOfDaysForFlow(int numberOfFlows){
        if(numberOfFlows<=0 || numberOfFlows>7){
            throw new IllegalArgumentException("I think you need to see a doctor, sorry we can't help ");
        }else{        this.numberOfDaysForFlow = numberOfFlows;}

    }

    public void setNumberOfDaysCycleLast(int rangeOfCycle){
        if(rangeOfCycle<21 || rangeOfCycle>35){
            throw new IllegalArgumentException("I think you need to see a doctor, sorry we can't help ");
        }else{this.numberOfDaysCycleLast = rangeOfCycle;}

    }
    public int getOvulationPeriod(){
        return ovulationPeriod;
    }


    public int getNumberOfDaysForFlow(){
        return numberOfDaysForFlow;
    }
    public int getNumberOfDaysCycleLast(){
        return numberOfDaysCycleLast;
    }

    Calendar myCalendar = (Calendar) calendar.clone();
    public String getNextFlow(){
         setCalendar();
         calendar.add(Calendar.DAY_OF_MONTH,numberOfDaysCycleLast);
        return myDateFormat.format(calendar.getTime());

           }

    public String displayOvulationPeriod(){

         switch(numberOfDaysCycleLast){
             case 21:
                 ovulationPeriod = 21 -14;
                 break;
             case 22:
                 ovulationPeriod = 22 - 14;
                 break;
             case 23:
                 ovulationPeriod = 23 - 14;
                 break;
             case 24:
                 ovulationPeriod = 24 - 14;
                 break;
             case 25:
                 ovulationPeriod = 25 - 14;
                 break;
             case 26:
                 ovulationPeriod = 26 - 14;
                 break;
             case 27:
                 ovulationPeriod = 27 - 14;
                 break;
             case 28:
                 ovulationPeriod = 28 - 14;
                 break;
             case 29:
                 ovulationPeriod = 29 - 14;
                 break;
             case 30:
                 ovulationPeriod = 30 - 14;
                 break;
             case 31:
                 ovulationPeriod = 31 - 14;
                 break;
             case 32:
                 ovulationPeriod = 32 - 14;
                 break;
             case 33:
                 ovulationPeriod = 33 - 14;
                 break;
             case 34:
                 ovulationPeriod = 34 - 14;
                 break;
             case 35:
                 ovulationPeriod = 35 - 14;
             default:
                 return "You need to go see a doctor ";
         }
                setCalendar();
                calendar.add(Calendar.DAY_OF_MONTH,numberOfDaysCycleLast);
                calendar.add(Calendar.DAY_OF_MONTH,-ovulationPeriod);
        return myDateFormat.format(calendar.getTime());

    }
    public String getSafePeriodForSex(){

        return String.format("day1  to day%d and day%d to day%d ",getOvulationPeriod()-6,getOvulationPeriod()+2,numberOfDaysCycleLast);
    }

    public String getSafePeriodToConceive(){

        return String.format("day%d to day%d ",getOvulationPeriod()-5,getOvulationPeriod()+2);
    }
    public String getWhenPeriodIsEnding(){
        setCalendar();
        calendar.add(Calendar.DAY_OF_MONTH,numberOfDaysCycleLast);
        calendar.add(Calendar.DAY_OF_MONTH,numberOfDaysForFlow);
        return myDateFormat.format(calendar.getTime());
    }
}


