package by.htp.library.dao;

import by.htp.library.bean.creator.BookCreator;
import by.htp.library.bean.creator.UserCreator;
import by.htp.library.bean.creator.impl.BookCreatorImpl;
import by.htp.library.bean.creator.impl.UserCreatorImpl;
import by.htp.library.dao.impl.TXTBookDAO;
import by.htp.library.dao.impl.TXTUserDAO;
import by.htp.library.dao.parser.ParserBookParamFromString;
import by.htp.library.dao.parser.ParserBookParamToString;
import by.htp.library.dao.parser.ParserUserParamFromString;
import by.htp.library.dao.parser.ParserUserParamToString;
import by.htp.library.dao.parser.impl.ParserBookParamFromStringImpl;
import by.htp.library.dao.parser.impl.ParserBookParamToStringImpl;
import by.htp.library.dao.parser.impl.ParserUserParamFromStringImpl;
import by.htp.library.dao.parser.impl.ParserUserParamToStringImpl;
import by.htp.library.dao.reader.DataReader;
import by.htp.library.dao.reader.impl.DataReaderImpl;
import by.htp.library.dao.writer.DataWriter;
import by.htp.library.dao.writer.impl.DataWriterImp;

public class Creator {
	public static final BookCreator BOOK_CREATOR = new BookCreatorImpl();
	public static final UserCreator USER_CREATOR = new UserCreatorImpl();
	public static final BookDAO BOOK_DAO = new TXTBookDAO();
	public static final UserDAO USER_DAO = new TXTUserDAO();
	public static final ParserBookParamFromString PARSER_BOOK_PARAM_FROM_STRING = new ParserBookParamFromStringImpl();
	public static final ParserBookParamToString PARSER_BOOK_PARAM_TO_STRING = new ParserBookParamToStringImpl();
	public static final ParserUserParamFromString PARSER_USER_PARAM_FROM_STRING = new ParserUserParamFromStringImpl();
	public static final ParserUserParamToString PARSER_USER_PARAM_TO_STRING = new ParserUserParamToStringImpl();
	public static final DataWriter DATA_WRITER = new DataWriterImp();
	public static final DataReader DATA_READER = new DataReaderImpl();
	
	
	
}
