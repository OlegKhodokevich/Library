package by.htp.library.service;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.service.exception.ServiceLibraryException;

public interface LibraryService {

	Optional<Book> getInfoBook(String nameBook, String autor) throws ServiceLibraryException;

	List<Book> getInfoAllBook() throws ServiceLibraryException;

	List<Book> getInfoAllBookByAutor(String autor) throws ServiceLibraryException;

	boolean addBook(Book book) throws ServiceLibraryException;

	boolean editeBook(String nameBook, String autor, Book substituteDook) throws ServiceLibraryException;

	boolean deleteBook(String nameBook, String autor) throws ServiceLibraryException;

	boolean changeBookKeeper(String nameBook, String autor, String newBookKeeper) throws ServiceLibraryException;

}
