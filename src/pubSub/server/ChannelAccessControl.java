
package pubSub.server;

import java.util.HashMap;
import java.util.TreeSet;

import subscribers.ISubscriber;

/**
 * A Package-Protected class that keeps track of which
 * {@link subscribers.ISubscriber Subscribers} are blocked from a
 * {@link Channel}. It MUST implement the Singleton design pattern Class that
 * acts as an access control module that allows for the blocking and unblocking
 * of specific subscribers for specific channels
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class ChannelAccessControl {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ChannelAccessControl INSTANCE = null;

	/**
	 * A map of Channels to a set of {@link subscribers.ISubscriber
	 * Subscribers} that are blocked
	 */
	private final HashMap<String, TreeSet<ISubscriber>> blackList = new HashMap<>();

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private ChannelAccessControl() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	protected static ChannelAccessControl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelAccessControl(); // Create a new instance if null

		return INSTANCE;
	}

	/**
	 * Blocks the provided subscriber from accessing the designated channel
	 * 
	 * @param subscriber  an instance of any implementation of
	 *                    {@link ISubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return true if the {@link ISubscriber Subscriber} was not previously
	 *         blocked on this channel. Otherwise it returns false.
	 */
	protected boolean blockSubcriber(ISubscriber subscriber, String channelName) {
		if (subscriber == null)
			return false;

		TreeSet<ISubscriber> blockedSubscribers;
		blockedSubscribers = blackList.getOrDefault(channelName, new TreeSet<ISubscriber>());

		boolean result = blockedSubscribers.add(subscriber); // Checks if the subscriber was already blocked
		blackList.put(channelName, blockedSubscribers); // Adds blocked subscriber in map in case it was newly created

		// TODO: move this print statement out and make it depend on the true/false
		System.out.println(String.format("%s is blocked on Channel '%s'", subscriber, channelName));

		return result;
	}

	/**
	 * unblocks the provided subscriber from accessing the designated channel
	 * 
	 * @param subscriber  an instance of any implementation of
	 *                    {@link ISubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return true if the {@link ISubscriber Subscriber} was previously
	 *         blocked. Otherwise return false.
	 */
	protected boolean unBlockSubscriber(ISubscriber subscriber, String channelName) {
		if (subscriber == null)
			return false;

		TreeSet<ISubscriber> blockedSubscribers = blackList.get(channelName);
		if (blockedSubscribers == null)
			return false;

		// TODO: move this print statement out and make it depend on the true/false
		System.out.println(String.format("%s is un-blocked on Channel '%s'", subscriber, channelName));
		return blockedSubscribers.remove(subscriber); // remove the block and print
	}

	/**
	 * checks if the provided subscriber is blocked from accessing the specified
	 * channel
	 * 
	 * @param subscriber  an instance of any implementation of
	 *                    {@link ISubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return true if blocked false otherwise
	 */
	protected boolean checkIfBlocked(ISubscriber subscriber, String channelName) {
		if (subscriber == null)
			return false;

		TreeSet<ISubscriber> blockedSubscribers = blackList.get(channelName);
		if (blockedSubscribers == null)
			return false;

		return blockedSubscribers.contains(subscriber);
	}

}
