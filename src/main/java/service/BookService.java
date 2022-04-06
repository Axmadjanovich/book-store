package service;

import dao.Author;
import dao.Book;
import db.AuthorRepository;
import db.BookRepository;
import dto.BookDTO;

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(){
        this.authorRepository = new AuthorRepository();
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
              Author author = authorRepository.getAuthorById(book.getAuthorId());
              if (author != null){
                  bookDTO.setAuthor(author.getFirstName()+" "+author.getLastName());
              }
              return bookDTO;
          }
          return null;
    }
}
