//                  Monitor Code for the Readers and Writers
//                           (Readers have priority)
//
// This program demonstrates synchronizattion of processes that read and 
// write a shared data structure.  Several readers can access the data 
// simultaneously, or one writer can have exclusive access.


public class MainMethod {
  public static void main (String argv[]) {
    boolean IObound = false;
    boolean CPUbound = true;

    // Create a shared data structure.  This simulation only uses an integer
    // as the "shared data".  The value of this integer is used in the output,
    // to verify that writers get exclusive access.
    // "sleep" statements are used to simulate the time that would be taken
    // to access and update a more complex data structure.
    SharedDataStruct sharedData;         // declare sharedData
    sharedData = new SharedDataStruct(); // assign a value to sharedData

    System.out.println("The simiulation of the computer system is starting"); // initial print of the computer system

    UserJob U;
    UserJob V;

    for (int i=1; i <=4; i++) {
      U = new UserJob(i, sharedData, IObound);
      U.start();
      V = new UserJob(i, sharedData, CPUbound);
      V.start();
    }

  }  // end of "main"
}  // end of "MainMethod"
