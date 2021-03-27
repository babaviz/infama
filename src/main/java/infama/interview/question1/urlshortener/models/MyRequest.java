package infama.interview.question1.urlshortener.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyRequest {
    private String url;

    @JsonCreator
    public MyRequest() {
    }

    @JsonCreator
    public MyRequest(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
