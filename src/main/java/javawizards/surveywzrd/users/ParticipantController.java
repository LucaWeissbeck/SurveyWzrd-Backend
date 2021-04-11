package javawizards.surveywzrd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/participant")
public class ParticipantController {
    private final ParticipantRepository participantRepository;
    private final AuthTokenService authTokenService;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository, AuthTokenService authTokenService) {
        this.participantRepository = participantRepository;
        this.authTokenService = authTokenService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Participant>> getAllParticipants(@RequestHeader Map<String, String> headers)
            throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return new ResponseEntity<>((List<Participant>) participantRepository.findAll(), HttpStatus.OK);
        }
        throw new ServletException("You are not an owner. No access right.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Participant getParticipant(@PathVariable Long id) {
        return participantRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString()));

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
                    participant1.setPlatform(participant.getPlatform());
                    participant1.setBrowserLanguage(participant.getBrowserLanguage());
                    participant1.setLocationCountry(participant.getLocationCountry());
                    return participantRepository.save(participant1);
                })
                .orElseGet(() -> {
                    participant.setId(id);
                    return participantRepository.save(participant);
                });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteParticipant(@PathVariable Long id, @RequestHeader Map<String, String> headers)
            throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            participantRepository.deleteById(id);
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll(@RequestHeader Map<String, String> headers)
            throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            participantRepository.deleteAll();
        }
        throw new ServletException("You are not an owner. No access right.");
    }
}
