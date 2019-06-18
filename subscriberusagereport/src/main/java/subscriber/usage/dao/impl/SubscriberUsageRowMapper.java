package subscriber.usage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import subscriber.usage.dto.UsageDTO;

public class SubscriberUsageRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UsageDTO usageModel = new UsageDTO();
		usageModel.setAmount(rs.getDouble("AMOUNT"));
		usageModel.setSubscriberId(rs.getString("ID"));
		usageModel.setTimestamp(rs.getString("TRANSACTION_DATE")); 
		return usageModel;
	}

}
