package webapp.film.model;

//Класс модели для сохранения инфы по категориям фильмов
public class Category {
	private int categoryId;
	private String name;
	
	public Category() {
		super();
	}
	
	// конструктор класса с двумя параметрами
	public Category(int categoryId, String name) {
		this();
		this.categoryId = categoryId;
		this.name = name;
	}
	
	// конструктор класса с одним параметров
	public Category(String name) {
		this();
		this.name = name;
	}
	
	// Свойства
	
		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


}
