package networking.interpolation.sandbox.util.tickspersecond;

import static networking.interpolation.sandbox.util.Utils.nanosecondsToMilliseconds;
import static networking.interpolation.sandbox.util.Utils.secondsToNanoseconds;

/**
 * Puts a cap on the number of time per second that a loop can run, evenly distributing the runs over the second. If a
 * run is missed because the calling function takes too long, the next run will be skipped instead of delayed.
 */
public class Limiter {

    private long lastTime = 0; //The last time, in nanoseconds, that the limiter returned.
    private final int nanosecondDelay;

    public Limiter(int ticksPerSecond){
        //Calculate nanosecondDelay based on the desired number of ticks per second
        this.nanosecondDelay = (int)secondsToNanoseconds(1) / ticksPerSecond;
    }

    public Tick waitTick(){

        // Edge case for the first return (lastTime == 0). Return immediately and set lastTime to currentTime.
        if(lastTime == 0){
            lastTime = System.nanoTime();

            return new Tick(
                    this.nanosecondDelay,
                    this.nanosecondDelay
            );
        }

        // Wait for the appropriate amount of time
        long waitNanoSeconds = (lastTime + nanosecondDelay) - System.nanoTime();
        long waitMilliSeconds = nanosecondsToMilliseconds(waitNanoSeconds);
        int remainderNanoSeconds = (int) (waitNanoSeconds % 1000000);

        if(waitNanoSeconds > 0){
            try {
                Thread.sleep(waitMilliSeconds, remainderNanoSeconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //If lastTime is significantly  less than currentTime, this means we should skip ticks by incrementing lastTime multiple times.
        long previousLastTime = lastTime;
        do{
            lastTime += nanosecondDelay;
        }while(lastTime + nanosecondDelay <= System.nanoTime());

        return new Tick(
            lastTime - previousLastTime,
            waitNanoSeconds
        );

    }

}