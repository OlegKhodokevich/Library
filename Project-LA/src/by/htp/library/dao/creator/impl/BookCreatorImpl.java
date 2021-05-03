package by.htp.library.dao.creator.impl;

import java.time.Year;

import by.htp.library.bean.Book;
import by.htp.library.bean.TypeBookProtecred;
import by.htp.library.dao.Creator;
import by.htp.library.dao.creator.BookCreator;
import by.htp.library.dao.exception.DAOLibraryException;

public class BookCreatorImpl implements BookCreator {

	public Book createBookFromString(String bookString) throws DAOLibraryException {

		int id;
		String autor;
		String nameBook;
		String genreOfBook;
		Year year;
		String mediaType;
		TypeBookProtecred typeBook;
		String bookKeeper;

		Book book = null;

		String[] paramBook = Creator.PARSER_BOOK_PARAM_FROM_STRING.parseBookParamFromString(bookString);

		if (paramBook.length == 8) {
			id = Integer.valueOf(paramBook[0]);
			autor = paramBook[1];
			nameBook = paramBook[2];
			genreOfBook = paramBook[3];
			year = Year.of(Integer.valueOf(paramBook[4]));
			mediaType = paramBook[5];
			typeBook = TypeBookProtecred.valueOf(paramBook[6].toUpperCase());
			bookKeeper = paramBook[7];

			book = new Book(id, autor, nameBook, genreOfBook, year, mediaType, typeBook, bookKeeper);
		} else if (paramBook.length == 7) {
			autor = paramBook[0];
			nameBook = paramBook[1];
			genreOfBook = paramBook[2];
			year = Year.of(Integer.valueOf(paramBook[3]));
			mediaType = paramBook[4];
			typeBook = TypeBookProtecred.valueOf(paramBook[5]);
			bookKeeper = paramBook[6];

			book = new Book(autor, nameBook, genreOfBook, year, mediaType, typeBook, bookKeeper);
		}

		return book;
	}
}
