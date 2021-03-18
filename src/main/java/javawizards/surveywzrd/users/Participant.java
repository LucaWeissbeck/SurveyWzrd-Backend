package javawizards.surveywzrd.users;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "cookie_id")
    private String cookieId;
    @Column(name = "os")
    private String os;
    @Column(name = "browser_language")
    private String browser_language;
    @Column(name = "location")
    private String location;

    public Participant() {
    }

    public Participant(Long id, String cookieId, String os, String browser_language, String location) {
        this.id = id;
        this.cookieId = cookieId;
        this.os = os;
        this.browser_language = browser_language;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookie_id) {
        this.cookieId = cookie_id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser_language() {
        return browser_language;
    }

    public void setBrowser_language(String browser_language) {
        this.browser_language = browser_language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
