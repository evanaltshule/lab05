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
		posts = new ArrayList<Post>();
		map = new LinkedHashMap<String, ArrayList<User>>();
	}

	public ArrayList<Post> getPosts(){
		return posts;
	}

	public void registerUserTag(String tag, User user)
	{
		System.out.println("^^^^^ Adding tag: "+ tag + " for User ID: " +user.getUserID() + "^^^^^\n");
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
		for(String tag: tags){
			if(map.containsKey(tag)){
				for(User user: map.get(tag)){
					if(p.getUser() != user)
					usersToNotify.add(user);
				}
			}
		}
		ArrayList<User> users = new ArrayList<User>();
		Iterator<User> iterator = usersToNotify.iterator();
		while(iterator.hasNext()){
			users.add(iterator.next());
		}
		for(int i = users.size()-1; i >=0;i--){
			users.get(i).update(p);
		}
		
	}

	public void addPost(Post p)
	{
		if(posts.contains(p)){
			System.out.println("Already been posted!");
		}
		else{
			posts.add(p);
			System.out.println("+++ Adding Post to MessageBoard +++");
			p.print();
			System.out.println("++++++++++++++++++++++++++++++++++++\n");
			notifyUsers(p);
		}
	}

	public void addReply(Post reply)
	{	
		boolean foundParent = false;
		if(reply.getParentID() != -1) {
			for(int i = 0; i < posts.size(); i++) {
				if(reply.getParentID() == posts.get(i).getPostID()) {
					posts.get(i).addReply(reply);
					posts.add(reply);
					foundParent = true;
				}
			}
		}
		if(foundParent == true){
			System.out.println("+++ Adding Post to MessageBoard +++");
			reply.print();
			System.out.println("++++++++++++++++++++++++++++++++++++\n");
			notifyUsers(reply);
		}
		if(foundParent == false){
			System.out.println("ERROR: Parent does not exist!");
		}
	}

	public void displayTagMessages(String tag)
	{
		System.out.println("##### Displaying posts with tag: " + tag + " #####");
		tag = tag.toLowerCase();
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
		System.out.println("##############################\n");
	}

	public void displayKeywordMessages(String keyword)
	{
		System.out.println("##### Displaying posts with keyword: " + keyword + " #####");
		keyword = keyword.toLowerCase();
		for (Post post : posts)
		{
			if (post.getMessage().toLowerCase().contains(keyword))
			{
				post.print();
			}
		}
		System.out.println("##############################\n");
	}

	public void displayThread(int postID)
	{
		System.out.println("##### Displaying thread for PostID: " + postID + " #####");
		Post post = getPost(postID);
		if (post != null)
		{
			while (post.getParentID() != -1)
			{
				post = getPost(post.getParentID());
			}

			displayThreadHelper(post);
		}
		System.out.println("##############################\n");
	}

	private void displayThreadHelper(Post post)
	{
		post.print();
		for (Post tempPost : post.getReplies())
		{
			displayThreadHelper(tempPost);
		}
	}

	public void displayUserPosts(User user)
	{
		System.out.println("##### Displaying all posts for User ID: " + user.getUserID() + " #####");
		for (Post post : posts)
		{
			if(post.getUser() == user){
				post.print();
			}
		}
		System.out.println("##############################\n");
	}

	private Post getPost(int postID)
	{
		for (Post post : posts)
		{
			if (post.getPostID() == postID)
			{
				return post;
			}
		}
		System.out.println("ERROR: postID does not exist");
		return null;
	}
}