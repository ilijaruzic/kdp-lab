package rs.ac.bg.etf.kdp.ri160605;

import java.util.*;
import java.util.concurrent.locks.*;

public class ListMessageBox<T> implements MessageBox<T> {

    public static final int CAPACITY = 2;

    List<Message<T>> buffer;
    int size;

    Lock lock;
    Condition empty, full;

    public ListMessageBox() {
        buffer = new LinkedList<Message<T>>();
        size = CAPACITY;

        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    @Override
    public Message<T> get(long timeToDie, Status status) {
        lock.lock();
        try {
            while (buffer.size() == 0) {
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty.signal();
            return buffer.remove(0);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void put(Message<T> message, Priority priority, long timeToLive) {
        lock.lock();
        try {
            while (buffer.size() == size) {
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            full.signal();
            buffer.add(message);            
        } finally {
            lock.unlock();
        }
    }
}
