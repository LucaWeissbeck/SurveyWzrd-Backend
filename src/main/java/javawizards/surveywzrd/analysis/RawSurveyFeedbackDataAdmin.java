package javawizards.surveywzrd.analysis;

public class RawSurveyFeedbackDataAdmin extends RawSurveyFeedbackData{
    String locationCity;
    String locationCountry;

    public RawSurveyFeedbackDataAdmin(Long id, String timestamp,
                                      Long answerOptionID, String valueName, String locationCity, String locationCountry) {
        super(id, timestamp, answerOptionID, valueName);
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;
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
