package rs.ac.bg.etf.kdp.ri160605;

public interface Priority extends Comparable<Priority> {

    static final long LOW = 0;
    
    static final long HIGH = 100;

    long getPriority();

    void setPriority(long priority);
}
