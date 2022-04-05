package service;

import dao.Book;
import db.BookRepository;
import dto.BookDTO;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(){
        bookRepository = new BookRepository();
    }

    public BookDTO getBookById(Integer id, String lang){
          Book book = bookRepository.getBookById(id);
          if (book != null){
              BookDTO bookDTO = new BookDTO();
              bookDTO.setAuthor(book.getId()+"");
              bookDTO.setCost(book.getCost());
              bookDTO.setGenre(book.getGenre());
              bookDTO.setName(lang.equals("uz") ? book.getNameUz() : book.getNameRu());
              bookDTO.setId(book.getId());

              return bookDTO;
          }
          return null;
    }
}
