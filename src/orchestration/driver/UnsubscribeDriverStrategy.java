package orchestration.driver;

import java.util.Scanner;

import pubSub.local.SubscriberDiscoveryProxy;
import pubSub.local.SubscriptionManagerProxy;
import pubSub.server.IChannel;
import subscribers.ISubscriber;

/**
 * A Package-Protected concrete implementation of {@link DriverInterface} that
 * unsubscribes a {@link ISubscriber Subscriber} from a {@link IChannel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class UnsubscribeDriverStrategy implements IDriverStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * orchestration.driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		ISubscriber subscriber = SubscriberDiscoveryProxy.getInstance().findUsingID(scanner.nextInt());
		SubscriptionManagerProxy.getInstance().unSubscribe(scanner.next(), subscriber);
	}
}
