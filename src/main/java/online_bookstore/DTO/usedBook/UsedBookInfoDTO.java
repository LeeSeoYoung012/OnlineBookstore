package online_bookstore.DTO.usedBook;

import java.util.List;

import lombok.Getter;
import online_bookstore.DTO.BookDTO;
import online_bookstore.Entity.Member;

@Getter
public class UsedBookInfoDTO {
	private Long id;
	private String book_Id;
	private String book_Title;
	private Member member;
	private int salePrice;
	private int inStatus;
	private int outStatus;
	private int saleStatus;
	private String cover;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private List<String> imageUrl;
	private String description;
	
	public UsedBookInfoDTO(UsedBookDTO usedbook, BookDTO book) {
		this.id=usedbook.getId();
		this.book_Id=usedbook.getBook_Id();
		this.book_Title=usedbook.getBook_Title();
		this.member=usedbook.getMember();
		this.salePrice=usedbook.getPrice();
		this.description=usedbook.getDescription();
		this.inStatus=usedbook.getInStatus();
		this.outStatus=usedbook.getOutStatus();
		this.saleStatus=usedbook.getSaleStatus();
		this.imageUrl=usedbook.getImageUrl();
		this.cover=book.getBook_Cover();
		this.title=book.getBook_Title();
		this.author=book.getBook_Author();
		this.publisher=book.getBook_Publisher();
		this.price=book.getBook_Price();
    }
}
