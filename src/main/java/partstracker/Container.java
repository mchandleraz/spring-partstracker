package partstracker;

public class Container {

	private final long id;
	private final String label;

	public Container(long id, String label) {
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

}