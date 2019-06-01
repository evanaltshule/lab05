//Evan Altshule and George Kripac

import java.util.*;

public class User implements Observer
{
	private static int users = 0;
	private int userID;
	private ArrayList<String> subscribed = new ArrayList<String>();
	private ArrayList<Post> posts = new ArrayList<Post>();

	public User()
	{
		users++;
		userID = users;
	}

	public int getUserID
	{
		return userID;
	}

	public ArrayList<String> subscribed()
	{
		return subscribed;
	}

	public ArrayList<Post> getPosts()
	{
		return posts;
	}

	@Override
	public void update(Post p)
	{
		System.out.println("***** Updating UserID: " + userID + " *****");
		p.print();
		System.out.println("******************************");
	}
}
