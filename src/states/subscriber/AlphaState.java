package states.subscriber;

import events.AbstractEvent;
import events.EventMessage;

public class AlphaState extends AbstractState {

	protected AlphaState() {
		super();
	}

	public void handleEvent(AbstractEvent event, String channelName) {
		System.out.println("Event handled at Alpha State.\n");
		// TODO figure out what goes in here
	}

	// TODO: make a toString()
}
