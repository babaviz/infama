package infama.interview.question1.urlshortener.models;


public class MyRequest {
    private String url;

    public MyRequest() {}

    public MyRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
