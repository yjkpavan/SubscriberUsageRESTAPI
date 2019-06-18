package subscriber.usage.service;

import subscriber.usage.data.AggregatedUsageData;
import subscriber.usage.dto.UsageDTO;

public interface SubscriberUsageService {
	
	AggregatedUsageData getAggregatedUsage(String subscriberID);
	
	boolean saveUsage(UsageDTO usageDTO);

}
