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

        for (int I = 0;  I < 5; I++) {
            System.out.println("UserJob "+I+ " is starting");

            // Simulate "doing something else" by delaying for a while.
            try { sleep((int)(500.0*Math.random()+1)); } catch(Exception e) {break;}
        } // end of "for" loop
    }  // end of "run" method
}
