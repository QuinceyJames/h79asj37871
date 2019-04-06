package subscribers;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;
import states.subscriber.StateFactory;
import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori, rblack43
 * third instance of a concrete subscriber
 */
public class DefaultSubscriber extends AbstractSubscriber {

	/**
	 *
	 * (non-Javadoc)
	 * 
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected DefaultSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
}
