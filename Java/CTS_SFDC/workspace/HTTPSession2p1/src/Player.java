  

public class Player {
    private Long playerId;
    private String name;
    private String username;
    private String password;
    private String country;
    private String skill;
    private String team;
    
    
	public Player(Long playerId, String name, String username,String password, String country, String skill, String team) {
		this.playerId = playerId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.country = country;
		this.skill = skill;
		this.team = team;
		
	}

	public Player(String name, String username, String country,
			 String skill, String team) {
		this.name = name;
		this.username = username;
		this.skill = skill;
		this.country = country;
		this.team = team;
	}
	
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}

	


    
}

