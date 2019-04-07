package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;

/**
 * An implementation of a concrete {@link AbstractStrategy}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class DefaultStrategy extends AbstractStrategy {

	/**
	 * Protected constructor for {@link DefaultStrategy}. To create this object use
	 * {@link StrategyFactory#createStrategy(StrategyName)}
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected DefaultStrategy() {
		super();
	}

	/* (non-Javadoc)
	 * 
	 * @see strategies.publisher.AbstractStrategy#doPublish(events.AbstractEvent, publishers.AbstractPublisher)
	 */
	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		List<AbstractChannel> channelList = ChannelDiscovery.getInstance().listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			outputList.add(channel.getChannelTopic()); //add the channel without parameters
		}

		ChannelEventDispatcher.getInstance().postEvent(event, outputList);
	}
}
