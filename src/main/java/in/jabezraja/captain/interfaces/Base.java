package in.jabezraja.captain.interfaces;

public interface Base {
	public abstract <T> T findAll();

	public abstract void create();

	public abstract void update();

	public abstract void delete();

	public abstract <T> T findById(int id);
}
