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

	public void addTag(String tag)
	{
		subscribed.add(tag);
	}

	public void removeTag(String tag)
	{
		subscribed.remove(tag);
	}

	public void addPost(Post post)
	{
		if (!posts.contains(post))
		{
			posts.add(post);
		}
	}

	public int getUserID()
	{
		return userID;
	}

	public ArrayList<String> getTags()
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
		System.out.println("******************************\n");
	}
}
