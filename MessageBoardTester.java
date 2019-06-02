//Evan Altshule and George Kripac

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;

public class MessageBoardTester {
	
	private MessageBoardManager messageBoard; 
	private User user1 = new User();
	private User user2 = new User();
	private User user3 = new User();

	@Before
	public void executeBeforeEachTest() {
		System.out.println("@Before: shown before each test");
	}
	
	@Test
	public void PostAndRepliesTest() {
		messageBoard = new MessageBoardManager();
		
		ArrayList<String> beerTags = new ArrayList<String>();
		beerTags.add("Busch");
		beerTags.add("COORS");
		beerTags.add("bud");
		beerTags.add("kona");
		
		Post post1 = new Post(beerTags, "Lets play beer die!", user1, -1);
		messageBoard.addPost(post1);
		Post post2 = new Post(beerTags, "Yes! I have coors light", user3, post1.getPostID());
		messageBoard.addPost(post2);
		Post post3 = new Post(beerTags, "I want to use bud light.", user2, post2.getPostID());
		messageBoard.addPost(post3);
		Post post4 = new Post(beerTags, "I hate Kona but love Busch light", user1, post2.getPostID());
		messageBoard.addPost(post4);
		//should not add (invalid parent ID)
		Post post5 = new Post(beerTags, "should not work", user2, 100);
		messageBoard.addReply(post5);
		
		ArrayList<String> fruitTags = new ArrayList<String>();
		fruitTags.add("apple");
		fruitTags.add("BANana");
		
		Post post6 = new Post(fruitTags, "Apples are better than bananas.", user3, -1);
		messageBoard.addPost(post6);
		Post post7 = new Post(fruitTags, "I respectfully disagree.", user1, post6.getPostID());
		messageBoard.addReply(post7);

		//create expected arraylist
		ArrayList<Post> expectedPosts = new ArrayList<Post>();
		expectedPosts.add(post1);
		expectedPosts.add(post2);
		expectedPosts.add(post3);
		expectedPosts.add(post4);
		expectedPosts.add(post6);
		expectedPosts.add(post7);
		
		ArrayList<Post> posts = new ArrayList<Post>();
		posts = messageBoard.getPosts();
		
		assertEquals(expectedPosts, posts);
		
		ArrayList<Post> replies = new ArrayList<Post>();
		for(int i = 0; i < messageBoard.getPosts().size(); i++) {
			if(messageBoard.getPosts().get(i).getParentID() != -1) {
				replies.add(messageBoard.getPosts().get(i));
			}
		}
		
		ArrayList<Post> expectedReplies = new ArrayList<Post>();
		expectedReplies.add(post2);
		expectedReplies.add(post3);
		expectedReplies.add(post4);
		expectedReplies.add(post7);
		assertEquals(expectedReplies, replies);
		
		assertEquals(posts.size(),expectedPosts.size());
		
		//should not add (duplicate)
		messageBoard.addPost(post4);
		assertEquals(expectedPosts.size(), posts.size());
		
	}
	

	
	@After
	public void executeAfterTest() {
		System.out.println("@After: shown after every test");
	}
	
	@AfterClass
	public static void executeAfterAllTests() {
		System.out.println("@AfterClass: shown once after all tests");
	}
	
	@BeforeClass
	public static void executeBeforeAllTests() {
		System.out.println("@BeforeClass: shown once before all tests");
	}
}
