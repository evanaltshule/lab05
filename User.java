//Evan Altshule and George Kripac

import java.util.*;

public class User implements Observer
{
	private static int users = 1;
	private int userID;
	private ArrayList<String> subscribed;
	private ArrayList<Post> posts;

	public User()
	{
		userID = users;
		users++;
	}

	public int getUserID
	{
		return userID;
	}

	@Override
	public void update(Post p)
	{
		System.out.println("***** Updating UserID: " + userID + " *****");
		p.print();
	}
}
