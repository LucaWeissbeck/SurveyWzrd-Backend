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
    @Column(name = "platform")
    private String platform;
    @Column(name = "platformVersion")
    private String platformVersion;
    @Column(name = "deviceType")
    private String deviceType;
    @Column(name = "browser")
    private String browser;
    @Column(name = "browserType")
    private String browserType;
    @Column(name = "browser_language")
    private String browser_language;

    @Column(name = "location")
    private String location;

    public Participant() {
    }

    public Participant(Long id, String cookieId, String platform, String platformVersion, String deviceType, String browser, String browserType, String browser_language, String location) {
        this.id = id;
        this.cookieId = cookieId;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.deviceType = deviceType;
        this.browser = browser;
        this.browserType = browserType;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }
}
