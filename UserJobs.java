/**
 * Created by eccrawford on 2018-03-26.
 */
public class UserJobs extends Thread {
    int myName;
    SharedDataStruct sharedData;


    public UserJobs(int name, SharedDataStruct SD) {
        myName = name;    // copy the parameter value to local variable "MyName"
        sharedData = SD;  // sharedData refers to the SharedDataStruct object
    }

    public void run () {
        int val;  // The value read from the database

        for (int I = 0;  I < 5; I++) {
            System.out.println("Reader " + myName +
                    " is now requesting to read the database.");
            val = sharedData.dataRead();

            System.out.println("Reader " + myName + " read the value " + val +
                    " and is doing something else for a while");

            // Simulate "doing something else" by delaying for a while.
            try { sleep((int)(500.0*Math.random()+1)); } catch(Exception e) {break;}
        } // end of "for" loop
    }  // end of "run" method
}
