package subscriber.usage.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import subscriber.usage.dao.SubscriberUsageDAO;
import subscriber.usage.data.AggregatedUsageData;
import subscriber.usage.dto.UsageDTO;


public class SubscriberUsageDAOImpl implements SubscriberUsageDAO {

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
  
	
	@Override
	public AggregatedUsageData getUsageBySubscriberId(String subscriberID) {
		try {
			
		
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SUB_USAGE WHERE ID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
      		
      	@SuppressWarnings("unchecked")
		List<UsageDTO> usageList = jdbcTemplate.queryForObject(
                sql, new Object[] { subscriberID }, new SubscriberUsageRowMapper());
    
      	AggregatedUsageData  aggregatedUsageData = new AggregatedUsageData();
      	aggregatedUsageData.setUsageResponseList(usageList);
      	return aggregatedUsageData;
		}catch(Exception ex)
		{
			return null;
		}
		
	}

	@Override
	public boolean saveUsageRecord(UsageDTO usageDTO) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO SUB_USAGE " + "(ID, AMOUNT, TRANSACTION_TIME) VALUES (?, ?, ?)";

		jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			jdbcTemplate.update(sql,
					new Object[] { usageDTO.getSubscriberId(), usageDTO.getAmount(), usageDTO.getTimestamp() });
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}
	
	 public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	  

}
