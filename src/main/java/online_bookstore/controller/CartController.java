package online_bookstore.controller;

import lombok.RequiredArgsConstructor;
import online_bookstore.Repository.Cart;
import online_bookstore.Repository.CartRepository;
import online_bookstore.DTO.BookDTO;
import online_bookstore.DTO.MemberDTO;
import online_bookstore.Repository.MemberDAOImp;
import online_bookstore.Service.BookInfoServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartRepository cartRepository;
    private final MemberDAOImp memberRepository;
    private final BookInfoServiceImp bookInfoServiceImp;

    @RequestMapping("/cart/?type=buy")
    public String CartBuy() {return "cartMember/cartBuyPossible";}

    @RequestMapping("/cart/?type=rent")

    public String CartRent() {return "CartMember/CartRentPossible";}

    @PostMapping("/api/cart")
    public Cart createCart(@RequestBody MemberDTO memberdto, @RequestBody String book_id){
        Cart cart = new Cart(  book_id , memberdto);
        return cartRepository.save(cart);
    }

    @GetMapping("/api/cart/{member_Num}")
    public ArrayList<BookDTO> getCart(@PathVariable int member_Num){

        MemberDTO member = memberRepository.getMemberDTObyMemberNum(member_Num);
        List<Cart> cartList = cartRepository.findCartBymemberIsOrderByIdAsc(member);
        ArrayList<BookDTO> cartBookList = new ArrayList<>();
        for(int i=0; i<cartList.size();i++ ){
            String book_Id = cartList.get(i).getBook_Id();
            ArrayList<BookDTO> bookDTOList = bookInfoServiceImp.booksearchbyId(book_Id);
            cartBookList.add(bookDTOList.get(0));
        }
      return cartBookList;
}

     @DeleteMapping("/api/cart/{id}")
     public Long deleteCart(@PathVariable Long id){
        cartRepository.deleteById(id);
        return id;
     }

}
