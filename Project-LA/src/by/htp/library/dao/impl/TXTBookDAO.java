package by.htp.library.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.Creator;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.validator.ValidatorBookByParam;

public class TXTBookDAO implements BookDAO {

	private static final String FILE_SOURCE_BOOKS = "data/dataLibrary.txt";
	private static final String DELIMITER = "/";

	@Override
	public Optional<Book> getInfoBook(String nameBook, String autor) throws DAOLibraryException {
		List<String> listBookString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);

		Optional<Book> book = null;
		for (int i = 0; i < listBookString.size(); i++) {
			if (ValidatorBookByParam.validateStringBookByNameAndAutor(listBookString.get(i), nameBook, autor)) {
				book = Optional.ofNullable(Creator.BOOK_CREATOR.createBookFromString(listBookString.get(i)));
			}
		}

		return book;
	}

	@Override
	public List<Book> getInfoAllBookByAutor(String autor) throws DAOLibraryException {
		List<String> listBookString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);
		List<String> listBookByAutorString = new ArrayList<String>();
		List<Book> listBook = new ArrayList<Book>();

		listBookByAutorString = listBookString.stream()
				.filter(s -> ValidatorBookByParam.validateStringBookByNameAndAutor(s, "", autor))
				.collect(Collectors.toList());

		for (int i = 0; i < listBookByAutorString.size(); i++) {
			listBook.add(Creator.BOOK_CREATOR.createBookFromString(listBookByAutorString.get(i)));
		}

		return listBook;
	}

	@Override
	public List<Book> getInfoAllBook() throws DAOLibraryException {		
		List<Book> listBook = new ArrayList<Book>();
		
		List<String> listBookString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);
		
		for (int i = 0; i < listBookString.size(); i++) {
			listBook.add(Creator.BOOK_CREATOR.createBookFromString(listBookString.get(i)));
		}

		return listBook;
	}

	@Override
	public boolean addBook(Book book) throws DAOLibraryException {
		boolean result = false;

		String nameBook = book.getNameBook();
		String autor = book.getAutor();

		List<String> listBookString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);

		int numberLastBook = listBookString.size();
		book.setId(numberLastBook + 1);

		if (getInfoBook(nameBook, autor) == null) {
			int numberOfLastbook = listBookString.size();
			book.setId(numberOfLastbook + 1);

			Creator.DATA_WRITER.writeBookInTXT(book, FILE_SOURCE_BOOKS);

			result = true;
		}

		return result;
	}

	@Override
	public boolean editeBook(String nameBook, String autor, Book substituteBook) throws DAOLibraryException {
		boolean result = false;

		List<String> listBooksString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);

		for (int i = 0; i < listBooksString.size(); i++) {
			if (ValidatorBookByParam.validateStringBookByNameAndAutor(listBooksString.get(i), nameBook, autor)) {
				substituteBook.setId(i + 1);
				
				String substituteBookString = Creator.PARSER_BOOK_PARAM_TO_STRING
						.parseBookParamToStringForTXT(substituteBook);
				
				listBooksString.set(i, substituteBookString);
				result = true;
			}
		}
		if (result) {
			Creator.DATA_WRITER.writeAllBookInTXT(listBooksString, FILE_SOURCE_BOOKS);			
		}
		return result;
	}

	@Override
	public boolean deleteBook(String nameBook, String autor) throws DAOLibraryException {
		boolean result = false;

		List<String> listBooksString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);		

		OUT: for (int i = 0; i < listBooksString.size(); i++) {
			if (!result
					&& ValidatorBookByParam.validateStringBookByNameAndAutor(listBooksString.get(i), nameBook, autor)) {
				
				listBooksString.remove(i);
				
				i = i - 1;
				result = true;
				continue OUT;
			}
			if (result) {
				String[] booksParam = Creator.PARSER_BOOK_PARAM_FROM_STRING
						.parseBookParamFromString(listBooksString.get(i));
				booksParam[0] = String.valueOf(i + 1);

				StringBuilder book = new StringBuilder();
				book.append(booksParam[0]);
				book.append(DELIMITER);
				book.append(booksParam[1]);
				book.append(DELIMITER);
				book.append(booksParam[2]);
				book.append(DELIMITER);
				book.append(booksParam[3]);
				book.append(DELIMITER);
				book.append(booksParam[4]);
				book.append(DELIMITER);
				book.append(booksParam[5]);
				book.append(DELIMITER);
				book.append(booksParam[6]);
				book.append(DELIMITER);
				book.append(booksParam[7]);

				listBooksString.set(i, book.toString());
			}
		}
		
		if (result) {
			Creator.DATA_WRITER.writeAllBookInTXT(listBooksString, FILE_SOURCE_BOOKS);
		}

		return result;
	}

	@Override
	public boolean changeBookKeeper(String nameBook, String autor, String newBookKeeper) throws DAOLibraryException {
		boolean result = false;

		List<String> listBooksString = Creator.DATA_READER.readAllBook(FILE_SOURCE_BOOKS);

		for (int i = 0; i < listBooksString.size(); i++) {
			if (ValidatorBookByParam.validateStringBookByNameAndAutor(listBooksString.get(i), nameBook, autor)) {
				String [] paramBook = Creator.PARSER_BOOK_PARAM_FROM_STRING.parseBookParamFromString(listBooksString.get(i));
				paramBook [7] = newBookKeeper; //23/Zusak M./The Book Thief/novel/2016/paper/all/home
				
				StringBuilder book = new StringBuilder();
				book.append(paramBook[0]);
				book.append(DELIMITER);
				book.append(paramBook[1]);
				book.append(DELIMITER);
				book.append(paramBook[2]);
				book.append(DELIMITER);
				book.append(paramBook[3]);
				book.append(DELIMITER);
				book.append(paramBook[4]);
				book.append(DELIMITER);
				book.append(paramBook[5]);
				book.append(DELIMITER);
				book.append(paramBook[6]);
				book.append(DELIMITER);
				book.append(paramBook[7]);				
				
				listBooksString.set(i, book.toString());
				result = true;
			}
		}
		if (result) {
			Creator.DATA_WRITER.writeAllBookInTXT(listBooksString, FILE_SOURCE_BOOKS);
		}
		
		return result;
	}

}
