//Evan Altshule and George Kripac
import java.util.ArrayList;

public class Post
{
	private ArrayList<String> tags;
	private String message;
	private ArrayList<Post> replies;
	private User user;
	private static int posts = 1;
	private int postID;
	private int parentID;


	public Post(ArrayList<String> tags, String message, User user, int parentID)
	{
		replies = new ArrayList<Post>();
		//this.tags = new ArrayList<String>(tags);
		this.tags = new ArrayList<String>();
		for(int i = 0; i < tags.size(); i++) {
			this.tags.add(tags.get(i));
		}
		this.message = message;
		this.user = user;
		this.parentID = parentID;
		this.postID = posts;
		posts++;
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

	public ArrayList<Post> getReplies(){
		return replies;
	}

	public void addReply(Post p){
		replies.add(p);
	}

	public void print(){
		System.out.println("--");
		System.out.println("Post ID: " + postID);
		System.out.print("Tags: ");
		{
			for (String tag : tags)
			{
				System.out.print(tag + " ");
			}
			System.out.println();
		}
		System.out.println("Posted by User ID: " + user.getUserID());
		if (parentID != -1)
		{
			System.out.println("Re: to Post ID: " + parentID);
		}
		System.out.println("Message: " + message);
		System.out.println("--");
	}
}
