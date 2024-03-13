
import java.util.Scanner;
import java.util.InputMismatchException;
public class UserClass {
    private DateClass date;
    private static  String name;
    private static  MenstrualCycleCalculatorClass menstrualCycle;
    private static final Scanner input = new Scanner(System.in);

    public void setDate(){
        boolean condition = true;
                        while (condition) {
                  try {
                    System.out.println("Enter the date when your previous Period stated (dd/mm/yyyy)");
                    String lastPeriodDate = input.next();
                    String[] array = lastPeriodDate.split("/");
                    checkUserDateFormat(array);
                    date = new DateClass(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                    condition = false;
                 }catch (Exception e) {
                    System.out.println(e.getMessage());
                  }
                }
    }

    public void collectMenstrualCycleInput(){
            menstrualCycle = new MenstrualCycleCalculatorClass(date);
        boolean conditionTwo = true;
      while(conditionTwo) {
          try {
              System.out.println("Enter The length of your Menstrual Cycle ");
              int menstrualCycleLength = input.nextInt();
              try {
                  menstrualCycle.setNumberOfDaysCycleLast(menstrualCycleLength);
                  conditionTwo = false;
              } catch (IllegalArgumentException e) {
                  System.out.println("IllegalArgumentException: " + e.getMessage());
                  System.out.println("Thank You For Using Our App,But We Cant Help\n Your Situation Is A Critical one ");
                  conditionTwo = false;
                  System.exit(0);
              }
          } catch (InputMismatchException e) {
              System.out.println(e.getMessage());
              input.next();
          }
      }
      conditionTwo = true;
      while(conditionTwo){
        try {
            System.out.println("Your period last for how many days??  ");
            int periodLength = input.nextInt();
            try {
                menstrualCycle.setNumberOfDaysForFlow(periodLength);
                conditionTwo = false;
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException: " + e.getMessage());
                System.out.println("Thank You For Using Our App,But We Cant Help\n Your Situation Is A Critical one ");
                conditionTwo = false;
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter A Valid Input");
            input.next();
        }
      }
    }
    public void mainApp(){
        displayHeadings();
        displayOutPut();
    }
    public void displayOutPut() {
        boolean condition = true;
        int userAnswer = 0;
        while (condition) {
            try {
                System.out.println();
                System.out.printf("""
                        =====================================================
                         Hey %s :)                                      
                        || Welcome To MyMenstrualCycle Tracker             ||
                        =====================================================
                        What's Your Goal ??
                           [(1)] Tracking My Menstrual Cycle (: 
                           [(2)] Trying To Conceive :(
                           [(3)] ExitApp
                        ======================================================\n   
                        """,name);
              //  while (condition) {
                    try {
                        userAnswer = input.nextInt();
                        while(userAnswer>3 || userAnswer<1){
                            System.out.println("Enter Either One Or Two ");
                            userAnswer = input.nextInt();
                        }
                        condition = false;
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        input.next();
                    }
              //  }
            } catch (InputMismatchException e) {
                System.out.println("Enter A Valid Input \n Enter one out of the numbers shown to you (1 or 2)");
                input.next();
            }

        }
        switch (userAnswer) {
            case 1:
                int userAnswer1 = 0;
                setDate();
                System.out.println();
                collectMenstrualCycleInput();
                System.out.println();
                System.out.println("""
                        Is Your Menstrual Cycle Regular??
                           [(1) yes ]     [(2) no ]
                        """);
                condition = true;
                int userInput = 0;
                while(condition) {
                    try {
                        userInput = input.nextInt();
                        while (userInput>2 || userInput<1){
                            System.out.println("Enter Valid Number 1 or 2");
                            userInput = input.nextInt();
                        }
                        condition = false;
                    } catch (Exception e) {
                        System.out.println("Invalid Input\n Enter Valid Input");
                        input.next();
                    }
                }
                if(userInput==1){
                    System.out.println("Okay Great Our prediction Should be 70% - 80% accurate ");
                }else{
                    System.out.println(" Our prediction might not be so accurate but we will give you the best prediction ");
                }
                System.out.println();
                    System.out.printf("""
                            ============================================================================
                            Hello!!! %s
                            Your Menstrual Cycle Flow..                                    
                                your next flow is predicted to Start on the %s.      
                                       ------------------------------------------------------------------
                                            your ovulation is predicted  to be on the %s.   
                                            -------------------------------------------------------------
                                                   your next flow is predicted end on the %s.          
                            =============================================================================
                            """,name,menstrualCycle.getNextFlow(),menstrualCycle.displayOvulationPeriod(),menstrualCycle.getWhenPeriodIsEnding());
                    System.out.println("""
                            
                            Note That THere are Some Factors that makes our Menstrual Cycle Vary....
                                Some Factors like stress,Contraceptives,eatingDisorder,HealthCondition,
                                Pregnancy and a lot more.
                                
                                So When You Experience Some Of This My Menstrual Cycle Tracker Might
                                not Be Able To Track Your Menstrual Cycle...
                            """);
                    System.out.println("""
                            ===========================================================
                            Would You Like To Go Further To Know About:
                                (1) Your Safe Period During Your Menstrual Cycle....
                                    (2)Your Fertile Window....
                                        (3)Know More About Menstrual Cycle....
                                            (4) ExitApp.....
                            ===========================================================              
                         
                            """);
                    System.out.println();
                    condition = true;
                    int userAnswer2 = 0;
                    while(condition){
                    try {
                        userAnswer2 = input.nextInt();
                        while (userAnswer2>4 || userAnswer2<1){
                            System.out.println("Enter Valid Number (1 - 4)");
                            userAnswer2 = input.nextInt();
                        }
                        condition = false;
                    }catch (Exception e){
                        System.out.println("Invalid Input\n Enter Valid Input");
                        input.next();
                    }
                    }
                    switch(userAnswer2) {
                        case 1:
                            System.out.print("""
                                    DISCLAIMER: This is for educational purpose only!!!!....
                                                                        
                                        What Does A Safe Period Means???
                                          A safe period is a portion of the menstrual cycle of the human
                                          female during which conception is least likely to occur.
                                          It usually includes several days immediately before and after the
                                          menstrual period and the period itself1. Biologically speaking, this
                                          is the time when the egg is not present to be fertilized2. Safe period
                                          refers to the days when a woman has reduced chances of getting pregnant..
                                    """);
                            System.out.println("""
                                    Would You love to know your safe periods??...
                                            [(1) Yes!!]      [(2) No !!!]
                                    """);
                            System.out.println();
                            condition = true;
                            while (condition){
                            try{
                            int userAnswer3 = input.nextInt();
                            while(userAnswer3>2 || userAnswer3<1){
                                System.out.println("Enter 1 Or 2 ");
                                userAnswer3 = input.nextInt();
                            }
                            if (userAnswer3 == 1) {
                                System.out.printf("Your Safe Period Is predicted to be Between %s during Your Menstrual Cycle days ", menstrualCycle.getSafePeriodForSex());
                                System.out.println("[<1>] Back              [<2>] ExitApp");
                                String userResponse = input.next();
                                while (!userResponse.matches("[1-2]")){
                                    System.out.println("Invalid Input\n [<1>] Back    [<2>] Exit App");
                                    userResponse = input.next();
                                }
                                switch (userResponse){
                                    case "1":
                                        displayOutPut();
                                        break;
                                    case "2":
                                        System.out.println("Thank You For Using Our Application\n It's Was A useful App Right??\n tell Your Friends About My MenstrualCycle Tracker");
                                        break;
                                }
                            }else{displayOutPut();}
                            condition = false;
                            }catch (Exception e){
                                System.out.println("Invalid Input\n Enter Valid Input");
                                input.next();
                            }
                            }
                            break;
                        case 2:
                            System.out.println("""
                                    DISCLAIMER: This is for educational purpose only!!!!....
                                        Fertile Window???
                                             A fertile window is the period in which unprotected
                                          sex could result in pregnancy. It includes the day of
                                          ovulation and the following 24 hours, when conception can
                                          occur. The fertile window varies depending on the length and
                                          regularity of the menstrual cycle, but it usually occurs around 
                                          the middle of the cycle.
                                          there is a very high chance of getting pregnant when you have sex during this period...
                                    """);
                            System.out.printf("\nFor You Your Fertile period should be around %s during Your Menstrual cycle days \n ", menstrualCycle.getSafePeriodToConceive());
                            System.out.println("[<1>] Back              [<2>] ExitApp");
                            String userResponse = input.next();
                            while (!userResponse.matches("[1-2]")){
                                System.out.println("Invalid Input\n [<1>] Back    [<2>] Exit App");
                                userResponse = input.next();
                            }
                            switch (userResponse){
                                case "1":
                                    displayOutPut();
                                    break;
                                case "2":
                                    System.out.println("Thank You For Using Our Application\n It's Was A useful App Right??\n tell Your Friends About My MenstrualCycle Tracker");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("""
                                    Understanding the Menstrual Cycle
                                            The menstrual cycle is a regular process in a woman's body. It starts with a period and
                                     lasts about 28 days, although this can vary. There are four main stages: the menstrual phase,
                                     follicular phase, ovulation phase, and luteal phase. Girls usually begin experiencing periods 
                                     when they're 11 to 14 years old. Besides its role in reproduction, the menstrual cycle affects 
                                     a woman's mood and behaviour. Here are the four phases of the menstruation cycle;
                                         Four Phases Of Menstrual Cycle                               
                                    1. Menstruation                          
                                    2. The Follicular Phase                                 
                                    3. Ovulation                              
                                    4. The luteal phase.
                                                                        
                                    To learn More About Menstrual Cycle read More On Our WebSite....
                                    
                                        [<1>] Back           [<2>] ExitApp
                                    """);
                             userResponse = input.next();
                            while (!userResponse.matches("[1-2]")){
                                System.out.println("Invalid Input\n [<1>] Back    [<2>] Exit App");
                                userResponse = input.next();
                            }
                            switch (userResponse){
                                case "1":
                                    displayOutPut();
                                    break;
                                case "2":
                                    System.out.println("Thank You For Using Our Application\n It's Was A useful App Right??\n tell Your Friends About My MenstrualCycle Tracker");
                                    break;
                            }
                            break;

                    }


                break;
            case 2:
                System.out.println("""
                        Trying To Conceive??
                            Have you Been Trying to conceive for some time and it's not working out??
                            Here is what you can do.....
                            
                            You need to know your fertile window,to know your fertile window you have to track
                            menstrual cycle and this help will help you do that..
                            
                                A fertile window is the period in which unprotected
                                 sex could result in pregnancy. It includes the day of
                                 ovulation and the following 24 hours, when conception can
                                 occur. The fertile window varies depending on the length and
                                 regularity of the menstrual cycle, but it usually occurs around
                                  the middle of the cycle.
                                  there is a very high chance of getting pregnant when you have sex during this period...
                                  
                                  it's said that sperms spend up 5 to 7 days in the woman's body,
                                  what does this means??
                                    it means that you can have sex 3-5 days before your ovulation day
                                    (which My Menstrual Cycle Tracker App can help you predict) and still conceive,
                                    but it is more advisable to have sex 2 or a day before your ovulation day, or a day or
                                     two after, or even on the ovulation day, this days have a very high chance for conception 
                                     to occur...
                                    
                                    [<1>] Back  [<2>] Exit
                        """);
                        String userResponse = input.next();
                        while (!userResponse.matches("[1-2]")){
                            System.out.println("Invalid Input\n [<1>] Back    [<2>] Exit App");
                            userResponse = input.next();
                        }
                        switch (userResponse){
                            case "1":
                                displayOutPut();
                                break;
                            case "2":
                                System.out.println("Thank You For Using Our Application\n It's Was A useful App Right??\n tell Your Friends About My MenstrualCycle Tracker");
                                break;
                        }
                break;
            case 3:
                System.out.println("Thank You For Using Our Application\n It's Was A useful App Right??\n tell Your Friends About My MenstrualCycle Tracker");
        }
    }
    private static void checkUserDateFormat(String[] array){
        for(String string: array){
            if(!string.matches("[0-9]+"))throw new IllegalArgumentException("Invalid DateFormat");
        }
    }
    private static void validateDateFormat(String date){
        for(int count = 0; count<date.length();count++){
            if(!contain(date.charAt(count)))throw new IllegalArgumentException("Invalid date format");
        }

    }

    private static boolean contain(char character) {
        boolean condition = true;
        char[] array = {'0','1','2','3','4','5','6','7','8','9','/'};
        for(int count = 0 ; count<array.length;count++) if(array[count] == character) {
            condition = true;
            break;
        }
        return condition;
    }

    private static void displayHeadings(){
        System.out.println("""
                Hey Hello Welcome To My Menstrual Cycle Tracker 
                    With Over 200 Million Users.....
                    
                    Enter Your Name... 
                """);
         name = input.nextLine();
        if(name.isEmpty() || !name.matches("[a-zA-Z]+")){
            System.out.println("Your Name Should Consist Of Alphabetical Letter Alone ");
            System.out.println();
            displayHeadings();
        }
    }
}
