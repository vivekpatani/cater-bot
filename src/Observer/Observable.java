package Observer;

public interface Observable {
	public void addObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void removeAllObservers();

	public void notifyObservers(Object... obj);

	public void notifyObservers();
}
