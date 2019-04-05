package driver;

import java.util.Scanner;

import orchestration.Orchestration;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;

public class UnblockerDriver implements DriverInterface {
	public void execute(Scanner scanner) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(scanner.nextInt());
		// TODO: in case channel name has a space in it
		SubscriptionManager.getInstance().unblock(subscriber, scanner.next());
	}
}
