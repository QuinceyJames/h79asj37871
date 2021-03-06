package events;

/**
 * the enumeration of available options that can be used to create an Event
 * using the
 * {@link EventFactory#createEvent(EventType, publishers.IPublisher, String, String)}
 * method
 * 
 * for every new @link {@link AbstractEvent} subclass created, a new entry
 * should be added here
 *
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 * 
 * 
 */
public enum EventType {
	ALPHA_EVENT, BETA_EVENT, GAMMA_EVENT, DEFAULT_EVENT;
}
