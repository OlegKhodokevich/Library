package by.htp.library.dao.reader;

import java.util.List;

import by.htp.library.dao.exception.DAOLibraryException;

public interface DataReader {
	List<String> readAllUser(String fileName) throws DAOLibraryException;
	
	List<String> readAllBook(String fileName) throws DAOLibraryException;
	
	public List<String> getNumberID(String fileName) throws DAOLibraryException; 
}
