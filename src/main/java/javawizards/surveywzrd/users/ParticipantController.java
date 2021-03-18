package javawizards.surveywzrd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/participant")
public class ParticipantController {
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return new ResponseEntity<>((List<Participant>) participantRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Participant getParticipant(@PathVariable Long id) {
        return participantRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Participant addParticipant(@RequestBody Participant participant) {
        return participantRepository.save(participant);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Participant updateParticipant(@RequestBody Participant participant, @PathVariable Long id) {
        return participantRepository.findById(id)
                .map(participant1 -> {
                    participant1.setCookieId(participant.getCookieId());
                    participant1.setOs(participant.getOs());
                    participant1.setBrowser_language(participant.getBrowser_language());
                    participant1.setLocation(participant.getLocation());
                    return participantRepository.save(participant1);
                })
                .orElseGet(() -> {
                    participant.setId(id);
                    return participantRepository.save(participant);
                });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteParticipant(@PathVariable Long id) {
        participantRepository.deleteById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll() {
        participantRepository.deleteAll();

    }
}
