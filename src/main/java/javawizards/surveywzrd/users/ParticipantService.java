package javawizards.surveywzrd.users;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant existsOrCreate(Participant participant){
        if (participantRepository.existsByCookieId(participant.getCookieId())) {
            return participantRepository.findByCookieId(participant.getCookieId());
        } else {
            participant.setCookieId(UUID.randomUUID().toString());
            return participantRepository.save(participant);
        }
    }

    public Participant addHeaderInformationToParticipant(Participant participant, HttpServletRequest req){
        String userAgentHeader = req.getHeader("User-Agent");
        String ipAddress = req.getHeader("X-Forward-For");

        if(ipAddress== null){

            ipAddress = req.getRemoteAddr();
        }

        try {
            UserAgentParser parser = new UserAgentService().loadParser();
            final Capabilities capabilities = parser.parse(userAgentHeader);
            final String browser = capabilities.getBrowser();
            final String browserType = capabilities.getBrowserType();
            final String browserMajorVersion = capabilities.getBrowserMajorVersion();
            final String deviceType = capabilities.getDeviceType();
            final String platform = capabilities.getPlatform();
            final String platformVersion = capabilities.getPlatformVersion();

            participant.setOs(platform);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return participant;


    }
}
