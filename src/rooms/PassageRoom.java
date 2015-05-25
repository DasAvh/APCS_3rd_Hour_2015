package rooms;

public class PassageRoom extends Room
{
	/*
	 * Not Used in final game, functions as general room
	 */
	//Fields
	private PassageRoom teleport;
	
	public PassageRoom(String[] data, int id, String name) 
	{
		super(data, id, name);
	}

	public void setTeleport(PassageRoom otherRoom)
	{
		
	}
}//End
