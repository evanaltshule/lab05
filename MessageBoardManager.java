//Evan Altshule and George Kripac
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;

public class MessageBoardManager implements Subject
{
	private ArrayList<Post> posts;
	private LinkedHashMap<String, ArrayList<User>> map;

	public MessageBoardManager()
	{

	}

	public void registerUserTag(String tag, User user)
	{
		System.out.println("^^^^^ Adding tag: "+ tag + " for User ID: " +user + "^^^^^");
		if(map.containsKey(tag.toLowerCase())){
			ArrayList<User> users = map.get(tag.toLowerCase());
			if(users == null){
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
			(map.get(tag.toLowerCase())).remove(user);
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
			(iterator.next()).update(p);
		}
		
	}

	public void addPost(Post p)
	{
		if(posts.contains(p)){
			System.out.println("Already been posted!")
		}
		else{
			posts.add(p);
			System.out.println("+++ Adding Post to MessageBoard +++");
			System.out.println(p.print());
			System.out.println("\n++++++++++++++++++++++++++++++++++++\n");
		}
	}

	public void addReply(Post reply)
	{}

	public void displayTagMessages(String tag)
	{
		System.out.println("##### Displaying posts with tag: " + tag + " #####");
		if (map.containsKey(tag))
		{
			for (Post post : posts)
			{
				if (post.getTags().contains(tag))
				{
					post.print();
				}
			}
		}
		System.out.println("##############################");
	}

	public void displayKeywordMessages(String keyword)
	{
		System.out.println("##### Displaying posts with keyword: " + keyword + " #####");
		for (Post post : posts)
		{
			if (post.getMessage().contains(keyword))
			{
				post.print();
			}
		}
		System.out.println("##############################");
	}

	public void displayThread(int postID)
	{
		System.out.println("##### Displaying thread for PostID: " + postID + " #####");
		while (postID != -1)
		{
			Post post = getPost(postID);


		System.out.println("##############################");
	}

	private void displayThreadHelper()
	{
	
	}

	public void displayUserPosts(User user)
	{}

	private Post getPost(int postID)
	{
		for (Post post : posts)
		{
			if (post.getPostID() == postID)
			{
				return Post;
			}
		}
		System.out.println("ERROR: postID does not exist");
		return null;
	}
}
