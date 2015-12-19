package partstracker;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public  String greeting() {
		return "Welcome";
	}

}