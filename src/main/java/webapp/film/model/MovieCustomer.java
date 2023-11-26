package webapp.film.model;


public class MovieCustomer {
	private int customerId;
	private int movieId;
	private float price;
	private String dateBuy;

	public MovieCustomer() {
		super();
	}
	
	public MovieCustomer(int customerId, int movieId, float price, String dateBuy) {
		this();
		this.customerId = customerId;
		this.movieId = movieId;
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

}
