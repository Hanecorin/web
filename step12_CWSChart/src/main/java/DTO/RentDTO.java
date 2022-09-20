package DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentDTO {
	
	private int rentNo;
	private String rentDate;
	private int bookNo;
	private String bookName;
	private int customerId;
	private String customerName;

	@Builder(builderMethodName = "RentDTOBuilder")
	public RentDTO(int rentNo, String rentDate, int bookNo, String bookName, int customerId, String customerName) {

		this.rentNo = rentNo;
		this.rentDate = rentDate;
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.customerId = customerId;
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 대여 정보_");
		builder.append(" 대여 번호:" + rentNo);
		builder.append(" 대여 일:" + rentDate);
		builder.append(" 대여 책번호:" + bookNo);
		builder.append(" 대여 책이름:" + bookName);
		builder.append(" 대여 고객번호:" + customerId);
		builder.append(" 대여 고객이름:" + customerName);
		return builder.toString();
	}

}