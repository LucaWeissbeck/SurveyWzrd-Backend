package javawizards.surveywzrd.reactconfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReactRouteForwarder {

        //@RequestMapping( method = {RequestMethod.OPTIONS, RequestMethod.GET}, path = {"/login", "/overview", "/", "/survey/**"} )
    @RequestMapping(value = { "/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}" })
        public String forwardAngularPaths() {
            return "forward:/index.html";
        }
    }


