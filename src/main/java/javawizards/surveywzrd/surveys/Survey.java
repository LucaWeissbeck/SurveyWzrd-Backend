package javawizards.surveywzrd.surveys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javawizards.surveywzrd.users.Administrator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Paris")
    private Date expiryDate;
    @Column(name = "question")
    private String question;
    @Column(name = "multi_select")
    private boolean multiSelect;
    @Column(name = "company_Name")
    private String companyName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administrator_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Administrator administrator;

    public Survey() {
    }

    public Survey
            (String name, String description, Date expiryDate, String question, boolean multiSelect, String companyName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expiryDate = expiryDate;
        this.question = question;
        this.multiSelect = multiSelect;
        this.companyName = companyName;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
