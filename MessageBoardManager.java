//Evan Altshule and George Kripac
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageBoardManager implements Subject
{

	private ArrayList<Observer> observers;
	private Post post;
	private LinkedHashMap<String, ArrayList<User>> map;

	public MessageBoardManager()
	{
		obervers = new ArrayList<Observer>;
	}

	public void registerUserTag(String tag, User user)
	{

	}

	public void addPost(Post p)
	{}

	public void addReply(Post reply)
	{}

	public void displayTagMessages(String tag)
	{}

	public void displayKeywordMessages(String keyword)
	{}

	public void displayThread(int postID)
	{}

	public void displayUserPosts(User user)
	{}
}
