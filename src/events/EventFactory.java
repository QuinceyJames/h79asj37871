package events;

import publishers.AbstractPublisher;

/**
 * @author kkontog, ktsiouni, mgrigori
 *
 */
public class EventFactory {

	/**
	 * This is an implementation of the Factory Method design pattern Creates an
	 * instance of any of the subclasses derived from the top level class
	 * AbstractEvent
	 * 
	 * @param eventType        a member of the {@link EventType} enumeration
	 * @param eventPublisherId a number generated by invoking the
	 *                         {@link AbstractPublisher#hashCode()} on the
	 *                         {@link AbstractPublisher} instance issuing the event
	 * @param payload          an object of type {@link EventMessage}
	 * @return
	 */
	public static AbstractEvent createEvent(EventType eventType, int eventPublisherId, EventMessage payload) {
		switch (eventType) {
		case AlphaEvent:
			return new AlphaEvent(EventIDMaker.getNewEventID(), eventPublisherId, payload);
		case BetaEvent:
			return new BetaEvent(EventIDMaker.getNewEventID(), eventPublisherId, payload);
		case GammaEvent:
			return new GammaEvent(EventIDMaker.getNewEventID(), eventPublisherId, payload);
		default: 
			return new DefaultEvent(EventIDMaker.getNewEventID(), eventPublisherId, payload);
		}
	}

}
