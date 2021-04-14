package javawizards.surveywzrd.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javawizards.surveywzrd.surveys.Survey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="auth_tokens")
public class AuthToken {

    @Column(name = "auth_key")
    @Id
    private String authKey;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administrator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Administrator admin;

    public AuthToken() {
    }

    public AuthToken(String authKey, Administrator admin) {
        this.authKey = authKey;
        this.admin = admin;
    }

    public AuthToken(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }
}
