package infama.interview.question1.urlshortener.models;

import javax.persistence.*;

@Entity(name="urls")
public class UrlModel {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
