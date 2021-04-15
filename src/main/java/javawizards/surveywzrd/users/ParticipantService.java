package javawizards.surveywzrd.users;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ResourceLoader resourceLoader;


    public Participant existsOrCreate(Participant participant){
        if (participantRepository.existsByCookieId(participant.getCookieId())) {
            return participantRepository.findByCookieId(participant.getCookieId());
        } else {
            participant.setCookieId(UUID.randomUUID().toString());
            return participantRepository.save(participant);
        }
    }

    public Participant addHeaderInformationToParticipant(Participant participant, HttpServletRequest req){

        final Resource geoipDatabase = resourceLoader.getResource("classpath:GeoLite2-City.mmdb");

        String userAgentHeader = req.getHeader("User-Agent");
        String ipAddress = req.getHeader("X-Forwarded-For");

        if(ipAddress== null){

            ipAddress = req.getRemoteAddr();
        }
        System.out.println(ipAddress);


        DatabaseReader dbReader = null;

        try {
            InputStream database = geoipDatabase.getInputStream();

            dbReader = new DatabaseReader.Builder(database)
                    .build();


            InetAddress ip = InetAddress.getByName(ipAddress);
            CityResponse response = dbReader.city(ip);

            String countryName = response.getCountry().getName();
            String cityName = response.getCity().getName();

            participant.setLocationCity(cityName);
            participant.setLocationCountry(countryName);

            /* System.out.println(countryName);
            System.out.println(cityName); */

        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }

        try {
            UserAgentParser parser = new UserAgentService().loadParser();
            final Capabilities capabilities = parser.parse(userAgentHeader);
            final String browser = capabilities.getBrowser();
            final String browserType = capabilities.getBrowserType();
            //final String browserMajorVersion = capabilities.getBrowserMajorVersion();
            final String deviceType = capabilities.getDeviceType();
            final String platform = capabilities.getPlatform();
            final String platformVersion = capabilities.getPlatformVersion();

            participant.setPlatform(platform);
            participant.setBrowser(browser);
            participant.setBrowserType(browserType);
            participant.setDeviceType(deviceType);
            participant.setPlatformVersion(platformVersion);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return participant;


    }
}
