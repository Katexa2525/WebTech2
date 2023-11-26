package webapp.film.model;

public class Movie {
	private int movie_id;
	private String title;
	private String description;
	private int release_year;
	private int duration;
	private float price;
	private String special_features;
	private float average_rating;

	public Movie() {
		super();
	}

	public Movie(int movie_id, String title, String description, int release_year, int duration, float price, String special_features, float average_rating) {
		this();
		this.movie_id = movie_id;
		this.title=title;
		this.description = description;
		this.release_year = release_year;
		this.duration = duration;
		this.price = price;
		this.special_features = special_features;
		this.average_rating = average_rating;
	}
	
	// конструктор для добавления записи
	public Movie(String title, String description, int release_year, int duration, float price, String special_features, float average_rating) {
		this();
		this.title=title;
		this.description = description;
		this.release_year = release_year;
		this.duration = duration;
		this.price = price;
		this.special_features = special_features;
		this.average_rating = average_rating;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getRelease_year() {
		return release_year;
	}
	
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	public float getAverage_rating() {
		return average_rating;
	}
	
	public void setAverage_rating(float average_rating) {
		this.average_rating = average_rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + movie_id + ", description=" + description + ", special_features="+ special_features + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
