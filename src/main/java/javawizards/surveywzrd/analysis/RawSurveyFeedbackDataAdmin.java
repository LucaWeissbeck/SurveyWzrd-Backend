package javawizards.surveywzrd.analysis;

public class RawSurveyFeedbackDataAdmin extends RawSurveyFeedbackData{
    private String locationCity;
    private String locationCountry;
    private Long participantID;

    public RawSurveyFeedbackDataAdmin(Long id, String timestamp,
                                      Long answerOptionID, String valueName, String locationCity, String locationCountry, Long participantID) {
        super(id, timestamp, answerOptionID, valueName);
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;
        this.participantID = participantID;
    }

    public Long getParticipantID() {
        return participantID;
    }

    public void setParticipantID(Long participantID) {
        this.participantID = participantID;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }
}
