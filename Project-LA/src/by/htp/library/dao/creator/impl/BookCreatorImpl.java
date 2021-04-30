package by.htp.library.dao.creator.impl;

import java.time.Year;

import by.htp.library.bean.Book;
import by.htp.library.bean.TypeBookProtecred;
import by.htp.library.dao.creator.BookCreator;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserBookParamFromString;
import by.htp.library.dao.parser.impl.ParserBookParamFromStringImpl;
import by.htp.library.dao.validator.ValidatorStingBook;

public class BookCreatorImpl implements BookCreator {
	
	public Book createBookFromString(String bookString) throws DAOLibraryException {
	if (!ValidatorStingBook.validateStringBook(bookString)) {
		throw new DAOLibraryException("Book could not be created");
	}
	
	int id;
	String autor;
	String nameBook;
	String genreOfBook;
	Year year;
	String mediaType;
	TypeBookProtecred typeBook;
	String bookKeeper;
	
	ParserBookParamFromString parserBookParamFromString = new ParserBookParamFromStringImpl();
	String[] paramBook = parserBookParamFromString.parseBookParamFromString(bookString);

	if (paramBook[0].matches("\\d+")) {
		id = Integer.valueOf(paramBook[0]);
	} else {
		id = 0;
	}
	autor = paramBook[1];
	nameBook = paramBook[2];
	genreOfBook = paramBook[3];
	year = Year.of(Integer.valueOf(paramBook[4]));
	mediaType = paramBook[5];
	
	switch (paramBook[6].toUpperCase()) {
	case "ALL": {
		typeBook = TypeBookProtecred.ALL;
		break;
	}
	case "NO_BABY": {
		typeBook = TypeBookProtecred.NO_BABY;
		break;
	}

	default: {
		typeBook = TypeBookProtecred.NO_BABY;
	}
	}
	bookKeeper =paramBook[7];

	Book book = new Book(id, autor, nameBook, genreOfBook, year, mediaType,
			typeBook, bookKeeper);

	return book;

}
}
