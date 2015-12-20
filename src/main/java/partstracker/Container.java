package partstracker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Container {

	private final String label;
	private final long id;

	public Container(@JsonProperty("label") String label) {
		this.label = label;
		this.id = this.createId();
	}

	public String getLabel() {
		return label;
	}

	public long getId() {
		return id;
	}

	private long createId() {
		long id = ContainerService.findAllContainers().size() + 1;
		return id;
	}

}