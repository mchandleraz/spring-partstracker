package partstracker;

// import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ContainerController {

	 @Autowired
	 ContainerService containerService;

	// private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value="/containers", method=RequestMethod.GET)
	public ResponseEntity<List<Container>> listAllContainers() {

		List<Container> containers = containerService.findAllContainers();

		if (containers.isEmpty()) {
			return new ResponseEntity<List<Container>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Container>>(containers, HttpStatus.OK);

	}

	@RequestMapping(value="/containers", method=RequestMethod.POST)
	public ResponseEntity<Void> createContainer(@RequestBody Container container, UriComponentsBuilder ucBuilder) {

		if (containerService.containerExists(container)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		containerService.addContainer(container.getLabel());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/containers/{label}").buildAndExpand(container.getLabel()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

}