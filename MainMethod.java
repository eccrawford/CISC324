// This program demonstrates synchronizattion CPU and IO bound processes attempting to access a disk


public class MainMethod {
  public static void main (String argv[]) {
    boolean IObound = false;
    boolean CPUbound = true;

    System.out.println("The simulation of the computer system is starting"); // initial print of the computer system

    UserJob U;
    UserJob V;

    for (int i=1; i <=4; i++) {
      U = new UserJob(i, IObound);
      U.start();
      V = new UserJob(i, CPUbound);
      V.start();
    }

  }  // end of "main"
}  // end of "MainMethod"
