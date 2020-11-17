package viewmodel;

public class bookviewmodel {
	private Long id;
	private String name,description;
	private int unitprice;
	private String authorName;
	
	public bookviewmodel() {
		
	}
	
	public bookviewmodel(Long id, String name, String description, int unitprice, String authorName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
		this.authorName = authorName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
