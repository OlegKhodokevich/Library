package by.htp.library.main;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.impl.TXTUserDAO;

public class MainRun {
	public static void main(String[] args)  {
		User expectedUser = new User(3, "Khodokevich_Oleg1", "112aaa", "Oleg1", StatusUser.ADMIN, AgeTypeUser.PARENT);
		TXTUserDAO txtUserDAO = new TXTUserDAO();
//		txtUserDAO.registration(expectedUser);
		User actualUser = new User(3, "Khodokevich_Oleg", "111aaa", "Oleg", StatusUser.ADMIN, AgeTypeUser.PARENT);

//		txtUserDAO.editUser("Khodokevich_Oleg", "111aaa", expectedUser);
//		try {
//			System.out.println(txtUserDAO.registration(expectedUser));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(txtUserDAO.removeUser("Khodokevich_Oleg1", "112aaa"));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(txtUserDAO.removeUser("Khodokevich_Oleg1", "112aaa"));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(txtUserDAO.removeUser("Khodokevich_Oleg", "111aaa"));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(txtUserDAO.registration(actualUser));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println(txtUserDAO.registration(actualUser));
//		} catch (DAOLibraryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	Integer integer = 7;
	integer = 8;
	System.out.println(integer);
	}

}
