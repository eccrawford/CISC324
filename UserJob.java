/**
 * Created by eccrawford on 2018-03-26.
 */
public class UserJob extends Thread{
    int myName;
    SharedDataStruct sharedData;
    boolean bound;


    public UserJob(int name, SharedDataStruct SD, boolean destination) {
        myName = name;    // copy the parameter value to local variable "MyName"
        sharedData = SD;  // sharedData refers to the SharedDataStruct object
        bound = destination;
    }

    public void run () {
        int CPUtime = 100 + (int)(Math.random() * ((1000-100)+1));
        int IOtime = 1 + (int)(Math.random() * ((200-1)+1));

        for (int I = 0;  I < 5; I++) {
            System.out.println("UserJob "+I+ " is starting");

            // Simulate "doing something else" by delaying for a while.
            if (bound) {
                System.out.println("UserJob " + I + " starting CPU burst of length " + CPUtime);

                try {
                    sleep(CPUtime);
                } catch (Exception e) {
                    break;
                } // shorter time
            }
            else {
                System.out.println("UserJob " + I + " starting IO burst of length " + IOtime);
                try {
                    sleep(IOtime);
                    } catch (Exception e) {
                        break;
                    } // longer time
                }
        } // end of "for" loop

    }  // end of "run" method
}
