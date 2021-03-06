package events;

import publishers.IPublisher;

/**
 * A concrete implementation of {@link AbstractEvent}. This
 * class was added simply to demonstrate that our PubSub system can handle
 * different types of {@link AbstractEvent Events}
 *
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class AlphaEvent extends AbstractEvent {

	/**
	 * Constructor for {@link AlphaEvent}. To create this object use
	 * {@link EventFactory#createEvent(EventType, IPublisher, String, String)}
	 * 
	 * @see AbstractEvent#AbstractEvent(long, IPublisher, EventMessage)
	 */
	protected AlphaEvent(long eventID, IPublisher eventPublisher, EventMessage eventMessage) {
		super(eventID, eventPublisher, eventMessage);
	}
}
