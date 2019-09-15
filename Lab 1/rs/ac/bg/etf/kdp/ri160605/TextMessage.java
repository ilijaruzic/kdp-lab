package rs.ac.bg.etf.kdp.ri160605;

public class TextMessage implements Message<String> {

    String body;

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {
        
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
