package networking.interpolation.sandbox.util.tickspersecond;

public class Tick {

    private long occurrenceNanoseconds; // what time (System.nanotime()) the tick occurred
    private long delayNanoseconds; // how long the tick took

    public Tick(long delayNanoseconds, long idleNanoseconds){
        this.occurrenceNanoseconds = System.nanoTime();
        this.delayNanoseconds = delayNanoseconds;
    }

    public long getDelayNanoseconds(){
        return delayNanoseconds;
    }

    public long getOccurrenceNanoseconds(){
        return occurrenceNanoseconds;
    }

}
