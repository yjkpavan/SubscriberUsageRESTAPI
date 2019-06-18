package subscriber.usage.facade;

import java.util.List;

import subscriber.usage.dto.AggregatedResultDTO;
import subscriber.usage.dto.UsageDTO;


public interface SubscriberUsageFacade {
	
	
	/**
	 * Get aggregated usage by {@code subscriberID}
	 *
	 * @param subscriberID
	 *           Subscriber ID
	 * @return returns a list of AggregatedResultDTO
	 */
	List<AggregatedResultDTO> getAggregatedUsage(String subscriberID) ;
	
	
	/**
	 * Save usage 
	 *
	 * @param usageDTO
	 *           Usage Details of a given user
	 * @return returns boolean success/fail
	 */
	boolean SaveUsage(UsageDTO usageDTO);
	

}
