package by.htp.library.dao;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOLibraryException;

public interface BookDAO {
	Optional<Book> getInfoBook(String nameBook, String autor) throws DAOLibraryException;
	
	List<Book> getInfoAllBook() throws DAOLibraryException;
	
	List<Book> getInfoAllBookByAutor(String autor) throws DAOLibraryException;
	
	boolean addBook(Book book) throws DAOLibraryException;
	
	boolean editeBook(String nameBook, String autor, Book substituteDook) throws DAOLibraryException;

	boolean deleteBook(String nameBook, String autor) throws DAOLibraryException;
	
	boolean changeBookKeeper(String nameBook, String autor, String newBookKeeper) throws DAOLibraryException;
	
	
}