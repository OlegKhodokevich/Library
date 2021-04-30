package by.htp.library.dao.reader;

import java.util.List;

import by.htp.library.dao.exception.DAOLibraryException;

public interface DataReader {
	List<String> readAllLegalUser(String fileName) throws DAOLibraryException;
	
	List<String> readAllLegalBook(String fileName) throws DAOLibraryException;
}
