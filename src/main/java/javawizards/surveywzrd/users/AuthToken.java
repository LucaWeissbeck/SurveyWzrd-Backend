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
    private String auth_key;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administrator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Administrator admin;
}
