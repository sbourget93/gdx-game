package networking.interpolation.sandbox.util;

public class Utils {

    public static double nanosecondsToSeconds(long nanoseconds){
        return nanoseconds / 1000000000.0;
    }

    public static long nanosecondsToMilliseconds(long nanoseconds){
        return nanoseconds / 1000000;
    }

    public static long secondsToNanoseconds(long seconds){
        return seconds * 1000000000;
    }

}
