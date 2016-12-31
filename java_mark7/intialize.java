package arindam.mishra.hello;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content1) {
        this.id = id;
        this.content = content1;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
