import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;

class MenstrualCycleCalculatorClassTest {

    @Test
    void getNumberOfDaysForFlow() {
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass();
        menstrualCalculator.setNumberOfDaysForFlow(7);
        int result = menstrualCalculator.getNumberOfDaysForFlow();
        assertEquals(7,result);
      //  menstrualCalculator.setNumberOfDaysForFlow(28);

        assertThrows(IllegalArgumentException.class, () -> menstrualCalculator.setNumberOfDaysForFlow(28));
    }

    @Test
    void getNumberOfDaysCycleLast() {
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass();
        menstrualCalculator.setNumberOfDaysCycleLast(28);
        int result = menstrualCalculator.getNumberOfDaysCycleLast();
        assertEquals(28,result);


        assertThrows(IllegalArgumentException.class, () -> menstrualCalculator.setNumberOfDaysCycleLast(7));

    }

    @Test
    void getNextFlow() {
        DateClass date = new DateClass(2,1,2024);
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass(date);
          //  date.setYear(2023);
         //   date.setMonth(12);
        //    date.setDay(25);
        menstrualCalculator.setNumberOfDaysCycleLast(22);
        String result = menstrualCalculator.getNextFlow();
        assertEquals("24 January 2024",result);

    }

    @Test
    void getOvulationPeriod() {
        DateClass date = new DateClass(25,4,2024);
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass(date);
        menstrualCalculator.setNumberOfDaysCycleLast(28);

        String result = menstrualCalculator.displayOvulationPeriod();
        assertEquals("09 May 2024",result);
    }

    @Test
    void getMonth() {
        DateClass date = new DateClass(23,12,2022);
        int result = date.getMonth();
        assertEquals(12,result);
    }

    @Test
    void getYear() {
        DateClass date = new DateClass(23,12,2022);
        int result = date.getYear();
        assertEquals(2022,result);
    }

    @Test
    void getDay() {
        DateClass date = new DateClass(23,12,2022);
        int result = date.getDay();
        assertEquals(23,result);
    }
    @Test
    void getSafePeriodForSex(){
        DateClass date = new DateClass(2,1,2024);
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass(date);
        menstrualCalculator.setNumberOfDaysCycleLast(32);

        String sample = menstrualCalculator.displayOvulationPeriod();
        String result = menstrualCalculator.getSafePeriodForSex();
        assertEquals("day1  to day12 and day20 to day32 ",result);


    }
    @Test
    void getWhenPeriodIsEnding(){
        DateClass date = new DateClass(2,1,2024);
        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass(date);
        menstrualCalculator.setNumberOfDaysForFlow(7);
        menstrualCalculator.setNumberOfDaysCycleLast(23);

        String result = menstrualCalculator.getWhenPeriodIsEnding();
        assertEquals("01 February 2024",result);

    }
    @Test
    void getSafePeriodToConceive(){
        DateClass date = new DateClass(2,1,2024);

        MenstrualCycleCalculatorClass menstrualCalculator = new MenstrualCycleCalculatorClass(date);
        menstrualCalculator.setNumberOfDaysCycleLast(22);

        String sample = menstrualCalculator.displayOvulationPeriod();
        String result = menstrualCalculator.getSafePeriodToConceive();
        assertEquals("day3 to day10 ",result);



    }
}