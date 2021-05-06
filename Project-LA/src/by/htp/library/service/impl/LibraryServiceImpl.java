package by.htp.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOProvider;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.service.LibraryService;
import by.htp.library.service.exception.ServiceLibraryException;

public class LibraryServiceImpl implements LibraryService {

	private static final DAOProvider PROVIDER = DAOProvider.getInstance();
	private static final BookDAO BOOK_DAO = PROVIDER.getBookDAO();

	@Override
	public Optional<Book> getInfoBook(String nameBook, String autor) throws ServiceLibraryException {
		Optional<Book> book = null;

		try {
			book = BOOK_DAO.getInfoBook(nameBook, autor);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return book;
	}

	@Override
	public List<Book> getInfoAllBook() throws ServiceLibraryException {
		List<Book> listBooks = new ArrayList<Book>();

		try {
			listBooks = BOOK_DAO.getInfoAllBook();
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return listBooks;
	}

	@Override
	public List<Book> getInfoAllBookByAutor(String autor) throws ServiceLibraryException {
		List<Book> listBooks = new ArrayList<Book>();

		try {
			listBooks = BOOK_DAO.getInfoAllBookByAutor(autor);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return listBooks;
	}

	@Override
	public boolean addBook(Book book) throws ServiceLibraryException {
		boolean result = false;

		try {
			result = BOOK_DAO.addBook(book);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}

		return result;
	}

	@Override
	public boolean editeBook(String nameBook, String autor, Book substituteDook) throws ServiceLibraryException {
		boolean result = false;

		try {
			result = BOOK_DAO.editeBook(nameBook, autor, substituteDook);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return result;
	}

	@Override
	public boolean deleteBook(String nameBook, String autor) throws ServiceLibraryException {
		boolean result = false;

		try {
			result = BOOK_DAO.deleteBook(nameBook, autor);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return result;
	}

	@Override
	public boolean changeBookKeeper(String nameBook, String autor, String newBookKeeper) throws ServiceLibraryException {
		boolean result = false;

		try {
			result = BOOK_DAO.changeBookKeeper(nameBook, autor, newBookKeeper);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return result;
	}

}
