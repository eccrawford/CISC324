import sun.plugin2.gluegen.runtime.CPU;

/**
 * Created by eccrawford on 2018-04-02.
 */
public class CPUMonitor {

    public static int[] CPUs = new int[0];
    public static int numCPUs = 3;

    public CPUMonitor() {
        createCPUs(numCPUs);
    }

    public void createCPUs(int numCPUs) {
        if(CPUs.length == 0) {
            CPUs = new int[numCPUs];
            for (int i=0; i < numCPUs; i++) {
                CPUs[i] = 0;
            }
        }
    }


    public synchronized  void startCPU(int process) {
        while(checkCPUs() == true) {
            try {
            wait();
            }
            catch(Exception e) {};
            useCPU(process, 0);
            System.out.println("UserJob " + process + " is executing on CPU " + getProcess(process));
        }


    }

    public synchronized void endCPU(int process) {
        System.out.println("UserJob "+ process + " is releasing CPU "+getProcess(process));
        useCPU(0,process);
        if(!checkCPUs()) { //free CPUs exist, wake up any other processes
            notifyAll();
        }

    }

    public int getProcess(int process) {
        for (int i =0; i < CPUs.length; i++) {
            if(CPUs[i] == process) {
                return i;
            }
        }
        return -1;
    }


    public static boolean checkCPUs() {
        for (int i = 0; i < CPUs.length; i++) { // check if there are any free CPUs
            if (CPUs[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public void useCPU(int value, int match) {
        // switches back and forth between freeing a particular CPU and using it
        // if a CPU is not in use, its value (a certain index in the array) will be 0, otherwise it will be the process
        for(int i=0; i < CPUs.length; i++) {
            if (CPUs[i] == match) {
                CPUs[i] = value;
                return;
            }
        }
    }
}
