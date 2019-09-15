package rs.ac.bg.etf.kdp.ri160605;

public interface MessageBox<T> {

    Message<T> get(long timeToDie, Status status);

    void put(Message<T> message, Priority priority, long timeToLive);
}
