package javawizards.surveywzrd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant existsOrCreate(Participant participant){
        if (participantRepository.existsByCookieId(participant.getCookieId())) {
            return participantRepository.findByCookieId(participant.getCookieId());
        } else {
            Participant participant1 = new Participant();
            participant1.setCookieId(UUID.randomUUID().toString());
            return participantRepository.save(participant1);
        }
    }
}
