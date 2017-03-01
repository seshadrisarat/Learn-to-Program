
public class Player {

	private int id;
	private String name;
	private String country;
	private Skill skill;
	private Team team;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Player(int id, String name, String country, Skill skill, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.skill = skill;
		this.team = team;
	}
	
	
}
