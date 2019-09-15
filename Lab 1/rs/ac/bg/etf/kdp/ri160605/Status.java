package rs.ac.bg.etf.kdp.ri160605;

public class Status {

    public static final int OK = 0;

    public static final int NOT_OK = 1;

    int status;

    public Status() {
        this(OK);
    }

    public Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
