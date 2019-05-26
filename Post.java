//Evan Altshule and George Kripac

public class Post
{
	private ArrayList<String> tags;
	private String message;
	private ArrayList<String> replies;
	private User user;
	private int postID;
	private int parentID;


	public Post(ArrayList<String> tags, String message, User user, int parentID)
	{
		this.tags = tags;
		this.message = message;
		this.user = user;
		this.parentID = parentID;
	}

	public ArrayList<String> getTags(){
		return tags;
	}

	public String getMessage(){
		return message;
	}

	public User getUser(){
		return user;
	}

	public int getPostID(){
		return postID;
	}

	public int getParentID(){
		return parentID;
	}



