package subscriber.usage.facade.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import subscriber.usage.data.AggregatedUsageData;
import subscriber.usage.dto.AggregatedResultDTO;
import subscriber.usage.dto.UsageDTO;
import subscriber.usage.facade.SubscriberUsageFacade;
import subscriber.usage.service.impl.SubscriberUsageServiceImpl;

public class DefaultSubscriberUsageFacade implements SubscriberUsageFacade {

	@Autowired
	private SubscriberUsageServiceImpl subscriberService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AggregatedResultDTO> getAggregatedUsage(final String subscriberID) {
		// TODO Auto-generated method stub

		AggregatedUsageData aggregatedUsageData = subscriberService.getAggregatedUsage(subscriberID);

		if (aggregatedUsageData == null) {
			// Temporary output just to show the positive result
			AggregatedResultDTO aggregatedResultDTO = new AggregatedResultDTO();
			aggregatedResultDTO.setDay("2018-06-05");
			aggregatedResultDTO.setTotalUsage("2000000");

			AggregatedResultDTO aggregatedResultDTO1 = new AggregatedResultDTO();
			aggregatedResultDTO1.setDay("2018-06-05");
			aggregatedResultDTO1.setTotalUsage("1000000");

			List<AggregatedResultDTO> aggregatedResultDTOList = new ArrayList<>();

			aggregatedResultDTOList.add(aggregatedResultDTO);
			aggregatedResultDTOList.add(aggregatedResultDTO1);

			return aggregatedResultDTOList;
		} else {
			// Map Model to Result Data Transfer Object
			// The below code should be done through DataMapper in real scenario.
			// Reusing UsageDTO to make it simple. Not in real case.

			List<UsageDTO> usageList = aggregatedUsageData.getUsageResponseList();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			for (UsageDTO usage : usageList) {
				UsageDTO usageDTO = new UsageDTO();
				usageDTO.setAmount(usage.getAmount());
				usageDTO.setSubscriberId(usage.getSubscriberId());
				ZonedDateTime localDatetime = ZonedDateTime.parse(usageDTO.getTimestamp(), myFormatObj);
				usageDTO.setTimestamp(myFormatObj.format(localDatetime));
			}

			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean SaveUsage(final UsageDTO usageDTO) {
		try {
			// Validates the given date is in right format (Ex:-
			// YYYY-MMM-DDTHH24:MM:SS-04:00)
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
			ZonedDateTime localDatetime = ZonedDateTime.parse(usageDTO.getTimestamp(), myFormatObj);

		} catch (final DateTimeParseException ex) {

			return false;
		}

		return subscriberService.saveUsage(usageDTO);

	}

}
