package javawizards.surveywzrd.surveys;

import javax.persistence.*;

@Entity
@Table(name="surveys")
public class Survey {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "description")
    private String description;
    @Column(name= "expiry_date")
    private String expiryDate;
    @Column(name= "question")
    private String question;
    @Column(name= "multi_select")
    private boolean multiSelect;

    public Survey() {

    }

    public Survey
            (String name, String description, String expiryDate, String question, boolean multiSelect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expiryDate = expiryDate;
        this.question = question;
        this.multiSelect = multiSelect;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
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
}
