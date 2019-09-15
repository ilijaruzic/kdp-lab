package rs.ac.bg.etf.kdp.ri160605;

public interface Message<T> {

    long getId();

    void setId(long id);

    T getBody();

    void setBody(T body);
}
