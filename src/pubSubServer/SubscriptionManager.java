package pubSubServer;

import subscribers.AbstractSubscriber;

/**
 * @author kkontog, ktsiouni, mgrigori MUST IMPLEMENT the Singleton Design
 *         Pattern and already implements the Proxy Design Pattern exposes the
 *         subscribe, and unsubscribe methods to the clients
 */
public class SubscriptionManager {

	private ChannelPoolManager cpManager;

	private static SubscriptionManager instance = null;

	private SubscriptionManager() {
	}

	public static SubscriptionManager getInstance() {
		if (instance == null)
			instance = new SubscriptionManager();
		return instance;
	}

	/**
	 * Completes the subscription of the provided ISubscriber to the appropriate
	 * AbstractChannel specified by the channelName
	 * 
	 * @param channelName the name of the AbstractChannel to which the ISubscriber
	 *                    wants to subscribe
	 * @param subscriber  the reference to an ISubscriber object
	 */
	public void subscribe(String channelName, AbstractSubscriber subscriber) {
		AbstractChannel channel = cpManager.findChannel(channelName);
		channel.subscribe(subscriber);
		System.out.println(subscriber + "subscribes to Channel " + channel.getChannelTopic() + ".");
	}

	/**
	 * Completes the unsubscription of the provided ISubscriber from the specified,
	 * by the channelName, AbstractChannel
	 * 
	 * @param channelName the name of the AbstractChannel from which the ISubscriber
	 *                    wants to unsubscribe
	 * @param subscriber  the reference to an ISubscriber object
	 */
	public void unSubscribe(String channelName, AbstractSubscriber subscriber) {
		AbstractChannel channel = cpManager.findChannel(channelName);
		channel.unsubscribe(subscriber);
		System.out.println(subscriber + "unsubscribes from " + channelName);
	}
	
	public boolean unblock(AbstractSubscriber subscriber, String channelName) {
		return ChannelAccessControl.getInstance().unBlockSubscriber(subscriber, channelName);
	}
	
	public boolean block(AbstractSubscriber subscriber, String channelName) {
		return ChannelAccessControl.getInstance().blockSubcriber(subscriber, channelName);
	}
}
