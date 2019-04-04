package states.subscriber;


/**
 * @author kkontog, ktsiouni, mgrigori
 * creates new States
 * contributes to the State design pattern
 * implements the FactoryMethod design pattern   
 */
public class StateFactory {

	
	/**
	 * creates a new {@link IState} using an entry from the {@link StateName} enumeration
	 * @param stateName a value from the {@link StateName} enumeration specifying the state to be created 
	 * @return the newly created {@link IState} instance 
	 */
	public static IState createState(StateName stateName) {
		switch(stateName) {
			case ALPHA_STATE : 
				return new AlphaState();
			case BETA_STATE :
				return new BetaState();
			case GAMMA_STATE :
				return new GammaState();
			default :
				return new DefaultState();
		}
	}
	
	
}
