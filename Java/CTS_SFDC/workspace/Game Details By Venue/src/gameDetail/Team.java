package gameDetail;


public class Team {
	private Integer id;
	private String name;
	
	
	
	public Team(int id, String name) {
		this.id= id;
		this.name= name;
		
		
	}
	public Team() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

