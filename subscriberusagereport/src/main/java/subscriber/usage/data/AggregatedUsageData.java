package subscriber.usage.data;

import java.util.List;

import subscriber.usage.dto.UsageDTO;

public class AggregatedUsageData {
	
	List<UsageDTO> usageResponseList;

	public List<UsageDTO> getUsageResponseList() {
		return usageResponseList;
	}

	public void setUsageResponseList(List<UsageDTO> usageResponseList) {
		this.usageResponseList = usageResponseList;
	}
	
	

}
