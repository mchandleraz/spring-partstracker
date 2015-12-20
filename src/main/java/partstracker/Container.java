package partstracker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Container {

	private final String label;

	public Container(@JsonProperty("label") String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}