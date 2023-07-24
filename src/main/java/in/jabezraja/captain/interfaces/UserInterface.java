package in.jabezraja.captain.interfaces;

import java.util.Set;

import in.jabezraja.captain.model.User;

public interface UserInterface extends Base {

	public abstract Set<User> findAll();

	public abstract User findById(int id);

}
