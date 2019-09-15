package rs.ac.bg.etf.kdp.ri160605;

import java.io.*;

public interface Message<T> extends Serializable {

    long getId();

    void setId(long id);

    T getBody();

    void setBody(T body);
}
