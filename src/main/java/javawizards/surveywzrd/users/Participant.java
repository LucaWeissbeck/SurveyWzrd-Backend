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
    private String cookie_id;
    @Column(name = "os")
    private String os;
    @Column(name = "browser_language")
    private String browser_language;
    @Column(name = "location")
    private String location;

    public Participant() {
    }

    public Participant(Long id, String cookie_id, String os, String browser_language, String location) {
        this.id = id;
        this.cookie_id = cookie_id;
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

    public String getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(String cookie_id) {
        this.cookie_id = cookie_id;
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
