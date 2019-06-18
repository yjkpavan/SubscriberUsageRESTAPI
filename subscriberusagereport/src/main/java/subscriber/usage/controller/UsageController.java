package subscriber.usage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import subscriber.usage.dto.AggregatedResultDTO;
import subscriber.usage.dto.ResultDTO;
import subscriber.usage.dto.SubscriberDTO;
import subscriber.usage.dto.UsageDTO;
import subscriber.usage.facade.impl.DefaultSubscriberUsageFacade;


/**
 * Usage Controller process user usage requests.
 */
@RestController
public class UsageController {
	
	@Resource //Injection by type
	DefaultSubscriberUsageFacade subscriberUsageFacade;
	
	@RequestMapping(value = "/getAggregatedUsage", method = RequestMethod.GET)
	public List<AggregatedResultDTO> getAggregatedUsage(@RequestBody final SubscriberDTO subsciberDTO)
	{
		return subscriberUsageFacade.getAggregatedUsage(subsciberDTO.getSubscriberId());		
		
	}
	
	@RequestMapping(value = "/reportUsagePost", method = RequestMethod.POST, consumes =
		{ MediaType.APPLICATION_JSON_VALUE})
	public ResultDTO reportUsagePost( @RequestBody
			final UsageDTO usage)
	{
		if(subscriberUsageFacade.SaveUsage(usage))
		{
			ResultDTO resultDTO = new ResultDTO();
			resultDTO.setStatus("Success");
			return resultDTO;
		}
		else
		{
			ResultDTO resultDTO = new ResultDTO();
			resultDTO.setStatus("Failed");
			return resultDTO;
		}
	}

}
