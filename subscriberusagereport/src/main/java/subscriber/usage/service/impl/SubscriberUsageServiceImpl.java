package subscriber.usage.service.impl;

import subscriber.usage.dao.impl.SubscriberUsageDAOImpl;
import subscriber.usage.data.AggregatedUsageData;
import subscriber.usage.dto.UsageDTO;
import subscriber.usage.service.SubscriberUsageService;

public class SubscriberUsageServiceImpl implements SubscriberUsageService {

	//Setter Injection is used
	private SubscriberUsageDAOImpl SubscriberUsageDAO;

	@Override
	public AggregatedUsageData getAggregatedUsage(String subscriberID) {
		// TODO Auto-generated method stub
		return SubscriberUsageDAO.getUsageBySubscriberId(subscriberID);
	}

	@Override
	public boolean saveUsage(UsageDTO usageDTO) {
		// TODO Auto-generated method stub
		return SubscriberUsageDAO.saveUsageRecord(usageDTO);

	}

	public SubscriberUsageDAOImpl getSubscriberUsageDAO() {
		return SubscriberUsageDAO;
	}

	public void setSubscriberUsageDAO(SubscriberUsageDAOImpl subscriberUsageDAO) {
		SubscriberUsageDAO = subscriberUsageDAO;
	}

}
