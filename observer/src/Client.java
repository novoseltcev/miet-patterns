import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        var deanOffice = new DeanOffice();


        var teachers = new LinkedList<Teacher>() {{
            add(new Teacher("фаывывапвк"));
            add(new Teacher("выавыа"));
            add(new Teacher("ывавыаыа"));
            add(new Teacher("ывавыаыа"));
        }};

        for (var teacher: teachers) {
            teacher.addObserver(deanOffice);
        }

        System.out.println("REPORTS:\n-------------------------------");
        for (var i = 1; i <=5; i++) {
            System.out.println("\nWeek " + i);
            for (var teacher: teachers) {
                if (new Random().nextInt(0, teachers.size() - 1) != 0){
                    teacher.notifyObservers();
                }
            }
            System.out.println(deanOffice.getReport());
            deanOffice.nextWeek();
        }


//        System.out.println("Week 1");
//        t1.notifyObservers();
//        t2.notifyObservers();
//        t3.notifyObservers();
//
//
//        System.out.println("\nWeek 2");
//        deanOffice.nextWeek();
//        t1.notifyObservers();
//        t2.notifyObservers();
//        System.out.println(deanOffice.CheckReports());
//
//        System.out.println("\nWeek 3");
//        deanOffice.nextWeek();
//        t2.notifyObservers();
//        t3.notifyObservers();
//        System.out.println(deanOffice.CheckReports());
//
//
//        Console.WriteLine("\nWeek 4");
//        deanOffice.nextWeek();
//        t1.RemoveObserver(deanOffice);
//        t2.NotifyObservers();
//        t3.NotifyObservers();
//        Console.WriteLine(deanOffice.CheckReports());
//
//        Console.WriteLine("\nWeek 5");
//        deanOffice.nextWeek();
//        t2.RemoveObserver(deanOffice);
//        t3.NotifyObservers();
//        Console.WriteLine(deanOffice.CheckReports());
    }
}
