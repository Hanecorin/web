package DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	

	private int customerId;
	private String customerName;
	private String phoneNumber;

	@Builder(builderMethodName = "CustomerDTOBuilder")
	public CustomerDTO(int customerId, String customerName, String phoneNumber) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("고객 정보_");
		builder.append(" 번호:" + customerId);
		builder.append(" 이름:" + customerName);
		builder.append(" 연착처:" + phoneNumber);
		return builder.toString();
	}

}