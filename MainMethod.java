// This program demonstrates synchronization CPU and IO bound processes attempting to access a disk


public class MainMethod {
  public static void main (String argv[]) {
    boolean IObound = false;
    boolean CPUbound = true;

    System.out.println("The simulation of the computer system is starting"); // initial print of the computer system

    UserJob U;

    for (int i=1; i <=20; i++) {
      // half the jobs will be IO bound, half CPU bound
      if(i % 2 == 0) {
        U = new UserJob(i, IObound);
      }
      else {
        U = new UserJob(i, CPUbound);
      }
      U.start();
    }

  }  // end of "main"
}  // end of "MainMethod"
