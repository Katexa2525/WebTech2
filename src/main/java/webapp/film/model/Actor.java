package webapp.film.model;

// Класс модели для сохранения инфы по актерам
public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	
	public Actor() {
		super();
	}
	
	// конструктор класса с тремя параметрами
	public Actor(int actorId, String firstName, String lastName) {
		this();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//конструктор класса с двумя параметрами
	public Actor(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Свойства
	
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
