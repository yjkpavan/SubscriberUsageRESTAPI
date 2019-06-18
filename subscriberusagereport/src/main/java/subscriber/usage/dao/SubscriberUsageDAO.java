package subscriber.usage.dao;

import subscriber.usage.data.AggregatedUsageData;
import subscriber.usage.dto.UsageDTO;

public interface SubscriberUsageDAO {
	
	AggregatedUsageData getUsageBySubscriberId(String subscriberID);
	
	boolean saveUsageRecord(UsageDTO usageDTO);

}
