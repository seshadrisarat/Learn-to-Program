
public class City {
	int id;
	String name;
	
	public City(int id,String name)
	{
		this.setId(id);
		this.setName(name);
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
}
