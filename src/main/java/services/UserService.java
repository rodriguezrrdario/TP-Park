package services;

import java.util.List;

import model.User;
import persistence.commons.DAOFactory;

public class UserService {

	public List<User> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public User create(String username, String password, Integer coins, Double time, Integer atraccionPreferida) {
		User user = new User(-1, username, password, coins, time, false, atraccionPreferida);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUserDAO().insert(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}
}
