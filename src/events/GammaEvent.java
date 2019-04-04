package events;

import publishers.AbstractPublisher;

public class GammaEvent extends AbstractEvent {
	public GammaEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
