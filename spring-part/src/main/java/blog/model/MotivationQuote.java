package blog.model;

/**
 * @author Marek Turis
 */
public class MotivationQuote {
	private String quote;
	private String author;

	public MotivationQuote(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}

	public MotivationQuote() {
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
