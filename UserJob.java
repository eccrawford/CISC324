/**
 * Created by eccrawford on 2018-03-26.
 */
public class UserJob extends Thread{
    int myName;
    boolean bound;
    public DiskDrive DiskDrive = new DiskDrive();
    public CPUMonitor cpu = new CPUMonitor();


    public UserJob(int name, boolean destination) {
        myName = name;    // copy the parameter value to local variable "MyName"
        bound = destination;
    }

    public void run () {
        int CPUtime = 100 + (int)(Math.random() * ((1000-100)+1));
        int IOtime = 1 + (int)(Math.random() * ((200-1)+1));
        //DiskDrive = new DiskDrive();
        //cpu = new CPUMonitor();
        System.out.println("UserJob "+myName+ " is starting");
        for (int I = 1;  I <= 10; I++) {
            int IOtrack = (int) (Math.random() * 1024);

            if (bound) {
                System.out.println("UserJob " + myName + " starting CPU burst of length " + CPUtime);
            }
            else {
                System.out.println("UserJob " + myName + " starting IO burst of length " + IOtime);
            }
            cpu.startCPU(myName);
            try {
                if(bound) {
                    sleep(CPUtime);
                }
                else {
                    sleep(IOtime);
                }
            }
            catch (Exception e) {};
            cpu.endCPU(myName);
            System.out.println("UserJob "+myName+ " is requesting access to track "+ IOtrack);
            DiskDrive.useTheDisk(IOtrack);
            System.out.println("UserJob "+myName+ " is finished accessing track "+ IOtrack);


        } // end of "for" loop

    }  // end of "run" method
}
