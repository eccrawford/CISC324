/**
 * Created by eccrawford on 2018-03-26.
 */
public class UserJob extends Thread {
    int myName;
    SharedDataStruct sharedData;


    public UserJob(int name, SharedDataStruct SD) {
        myName = name;    // copy the parameter value to local variable "MyName"
        sharedData = SD;  // sharedData refers to the SharedDataStruct object
    }

    public void run () {
        int val;  // The value read from the database
        int CPUtime = 100;
        int IOtime = 300;

        for (int I = 0;  I < 5; I++) {
            System.out.println("UserJob "+I+ " is starting");

            // Simulate "doing something else" by delaying for a while.
            System.out.println( "UserJob "+ I+ " starting CPU burst of length "+ CPUtime);
            try { sleep(CPUtime); } catch(Exception e) {break;}
            System.out.println("UserJob " + I + " starting IO burst of length " + IOtime);
            try { sleep( IOtime); } catch(Exception e) {break;}
        } // end of "for" loop

    }  // end of "run" method
}
