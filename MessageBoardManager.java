//Evan Altshule and George Kripac
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashSet;

public class MessageBoardManager implements Subject
{

	private ArrayList<Observer> observers;
	private Post post;
	private LinkedHashMap<String, ArrayList<User>> map;

	public MessageBoardManager()
	{
		obervers = new ArrayList<Observer>();
	}

	public void registerUserTag(String tag, User user)
	{
		System.out.println("^^^^^ Adding tag: "+ tag + " for User ID: " +user + "^^^^^");
		if(map.containsKey(tag.toLowerCase())){
			ArrayList<User> users = map.get(tag.toLowerCase());
			if(users == NULL){
				users = new ArrayList<User>();
				users.add(user);
				map.put(tag.toLowerCase(), users);
			}
			else{
				users.add(user);
			}
		}
		else{
			ArrayList<User> users = new ArrayList<User>();
			users.add(user);
			map.put(tag.toLowerCase(), users);
		}
	}

	public void removeUserTag(String tag, User user)
	{
		if(map.containsKey(tag.toLowerCase())){
			System.out.println("^^^^^ Removing tag: " + tag + " for User ID: " + user.getUserID() + " ^^^^^");
			(map.get(tag.toLowerCase())).remove(User);
		}
	}

	public void notifyUsers(Post p)
	{
		ArrayList<String> tags = p.getTags();
		HashSet<User> usersToNotify = new HashSet<User>();
		ArrayList<User> users;
		for(String tag: tags){
			if(map.containsKey(tag)){
				for(User user: map.get(tag)){
					usersToNotify.add(user);
				}
			}
			}
		Iterator<User> iterator = usersToNotify.iterator();
		while(iterator.hasNext()){
			(iterator.next()).update();
		}
		}
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
