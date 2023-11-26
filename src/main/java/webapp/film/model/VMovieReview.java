package webapp.film.model;

public class VMovieReview {
	private int movie_id;
	private String review;
	
	public VMovieReview() {
		super();
	}

	public VMovieReview(int movie_id, String review) {
		this();
		this.movie_id = movie_id;
		this.review = review;
	}
	
	// Свойства
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
