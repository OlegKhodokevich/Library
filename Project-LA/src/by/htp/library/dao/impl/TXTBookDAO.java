package by.htp.library.dao.impl;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.creator.BookCreator;
import by.htp.library.dao.creator.impl.BookCreatorImpl;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.reader.impl.DataReaderImpl;
import by.htp.library.dao.validator.ValidatorBookByParam;

public class TXTBookDAO implements BookDAO {

	private static final String FILE_SOURCE_USER_NAME = "data/dataUsers.txt";

	private static final String UNDEFINITED_NAME = "undefined";
	private static final String DELIMITER = "/";

	@Override
	public Optional<Book> getInfoBook(String nameBook, String autor) throws DAOLibraryException {
		String bookString = UNDEFINITED_NAME;

		DataReaderImpl dataReaderImpl = new DataReaderImpl();
		List<String> listBook = dataReaderImpl.readAllLegalBook(FILE_SOURCE_USER_NAME);
		bookString = listBook.stream()
				.filter(s -> ValidatorBookByParam.validateStringBookByNameAndAutor(s, nameBook, autor)).findFirst()
				.orElse("undefined");

		Optional<Book> book = null;
		if (!bookString.equals(UNDEFINITED_NAME)) {
			BookCreator bookCreator = new BookCreatorImpl();
			book = Optional.ofNullable(bookCreator.createBookFromString(bookString));
		}
		

		return book;
	}

	@Override
	public Book getInfoAllBook() throws DAOLibraryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(Book book) throws DAOLibraryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editeBook(String nameBook, String autor, Book substituteDook) throws DAOLibraryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(String nameBook, String autor) throws DAOLibraryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeBookKeeper(Book book, String bookKeeper) throws DAOLibraryException {
		// TODO Auto-generated method stub
		return false;
	}

}
