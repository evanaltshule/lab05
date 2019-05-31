//Evan Altshule and George Kripac
import java.util.*;


public interface Subject
{
	public void registerUserTag(String tag, User user);

	public void removeUserTag(String tag, User user);

	public void notifyUsers(Post p);
}
