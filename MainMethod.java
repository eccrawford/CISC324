//                  Monitor Code for the Readers and Writers
//                           (Readers have priority)
//
// This program demonstrates synchronizattion of processes that read and 
// write a shared data structure.  Several readers can access the data 
// simultaneously, or one writer can have exclusive access.
//
// In lab 3 you were given code that implemented the synchronization using
// semaphores.  Here is the same algorithm coded to use Java monitors.

// This code uses class Reader and Writer.


public class MainMethod {
  public static void main (String argv[]) {

    // Create a shared data structure.  This simulation only uses an integer
    // as the "shared data".  The value of this integer is used in the output,
    // to verify that writers get exclusive access.
    // "sleep" statements are used to simulate the time that would be taken
    // to access and update a more complex data structure.
    SharedDataStruct sharedData;         // declare sharedData
    sharedData = new SharedDataStruct(); // assign a value to sharedData
    
    System.out.println("The simiulation of the computer system is starting"); // initial print of the computer system

    UserJob U;

    for (int i=1; i <=4; i++) {
      U = new UserJob(i, sharedData);
      U.start();
    }

  }  // end of "main"
}  // end of "MainMethod"
