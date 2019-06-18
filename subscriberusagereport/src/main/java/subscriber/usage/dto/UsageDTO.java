package subscriber.usage.dto;

public class UsageDTO {

	String subscriberId;
	Double amount;
	String timestamp;

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		System.out.println(timestamp);
		this.timestamp = timestamp;
	}

}
