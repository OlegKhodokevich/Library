package by.htp.library.dao.parser.impl;

import java.time.Year;

import by.htp.library.bean.Book;
import by.htp.library.bean.TypeBookProtecred;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserBookParamToString;

public class ParserBookParamToStringImpl implements ParserBookParamToString {

	private static final String DELIMITER = "/";

	@Override
	public String parseBookParamToStringForTXT(Book book) throws DAOLibraryException {
		int id = book.getId();
		String autor = book.getAutor();
		String nameBook = book.getNameBook();
		String genreOfBook = book.getGenreOfBook();
		Year year = book.getYear();
		String mediaType = book.getMediaType();
		TypeBookProtecred typeBook = book.getTypeBook();
		String bookKeeper = book.getBookKeeper();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(id);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(autor);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(nameBook);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(genreOfBook);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(year);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(mediaType);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(typeBook);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(bookKeeper);

		
		return stringBuilder.toString();
	}
}
