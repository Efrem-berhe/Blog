package blog.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Marek Turis
 */
public class MotivationQuote {
	@NotNull
	private String quote;
	@NotNull
	private String author;
	@Min(1900)
	@Max(2050)
	private int yearSaid;

	public MotivationQuote(String quote, String author, int year) {
		this.quote = quote;
		this.author = author;
		this.yearSaid = year;
	}

	public MotivationQuote() {
	}

	public int getYearSaid() {
		return yearSaid;
	}

	public void setYearSaid(int yearSaid) {
		this.yearSaid = yearSaid;
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
