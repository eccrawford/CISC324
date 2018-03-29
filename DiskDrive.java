public class DiskDrive {

    int startTrack = 0; //This is where the disk-read-head starts
    int endTrack;
    int daTime;

    public void useTheDisk(int nextTrack) {

        endTrack = nextTrack; // This is where it needs to go
        daTime = 1 + Math.abs(endTrack - startTrack); // Disk access time
        System.out.println("The disk-read-head is currently at "+ startTrack + " and will move " + (daTime - 1)
                            + " tracks in " + daTime + " time.");
        startTrack = endTrack; //This is where the disk-read-head will start on next call
        try {
            Thread.sleep(daTime);
        } catch (Exception e) {
        }
    }

   /* public void run (){
        try {
            Thread.sleep(daTime);
        } catch (Exception e) {
        }
    }*/

}
