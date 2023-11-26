package webapp.film.model;

public class VMovieCustomer {
	private int customerId;
	private int movieId;
	private String title;
	private String description;
	private float price;
	private String dateBuy;

	public VMovieCustomer() {
		super();
	}
	
	public VMovieCustomer(int customerId, int movieId, String title, String description, float price, String dateBuy) {
		this();
		this.customerId = customerId;
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.dateBuy = dateBuy;
	}
	
	// Свойства
	
		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		public int getMovieId() {
			return movieId;
		}

		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		
		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}
		
		public String getDateBuy() {
			return dateBuy;
		}

		public void setDateBuy(String dateBuy) {
			this.dateBuy = dateBuy;
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

}
