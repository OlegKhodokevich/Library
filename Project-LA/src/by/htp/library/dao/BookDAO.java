package by.htp.library.dao;

import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOLibraryException;

public interface BookDAO {
	Optional<Book> getInfoBook(String nameBook, String autor) throws DAOLibraryException;
	
	Book getInfoAllBook() throws DAOLibraryException;
	
	boolean addBook(Book book) throws DAOLibraryException;
	
	boolean editeBook(String nameBook, String autor, Book substituteDook) throws DAOLibraryException;

	boolean deleteBook(String nameBook, String autor) throws DAOLibraryException;
	
	boolean changeBookKeeper(Book book, String bookKeeper) throws DAOLibraryException;
	
	
}