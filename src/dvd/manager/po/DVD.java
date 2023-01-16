package dvd.manager.po;

public class DVD {
	private String id;
	private String name;
	private String state;
	private String date;
	private String count;
	
	public DVD() {
		
	}
	
	public DVD(String id, String name, String state, String date, String count) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.date = date;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	

}
