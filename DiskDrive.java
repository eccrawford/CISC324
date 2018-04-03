public class DiskDrive {

    int startTrack = 0; //This is where the disk-read-head starts
    int endTrack;
    int daTime;
    int diskInUse = 0;

    public synchronized void useTheDisk(int nextTrack) {

       while (diskInUse > 0) {
            try {
                wait();
            } catch (Exception e) {}
        }

        diskInUse ++;
        endTrack = nextTrack; // This is where it needs to go
        daTime = 1 + Math.abs(endTrack - startTrack); // Disk access time
        System.out.println("The disk-read-head is currently at "+ startTrack + " and will move " + (daTime - 1)
                            + " tracks in " + daTime + " time.");
        startTrack = endTrack; //This is where the disk-read-head will start on next call
        try {
            Thread.sleep(daTime);
        } catch (Exception e) {};
        diskInUse --;
        notify();
    }

   /* public void run (){
        try {
            Thread.sleep(daTime);
        } catch (Exception e) {
        }
    }*/

}
