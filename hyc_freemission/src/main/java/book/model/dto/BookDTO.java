package book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

//	@Builder(builderMethodName = "bookDTOBuilder")
	private String bookNo;
	private String bookName;
	private String writer;
	private String publisher;
	private String inventory;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("책 번호: ");
		builder.append(bookNo);
		builder.append(",책 이름: ");
		builder.append(bookName);
		builder.append(",저자: ");
		builder.append(writer);
		builder.append(",출판사: ");
		builder.append(publisher);
		builder.append(",남은개수: ");
		builder.append(inventory);
		

		return builder.toString();
	}
}
