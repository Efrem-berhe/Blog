package blog.model;

import java.util.List;

/**
 * @author Marek Turis
 */
public interface MotivationQuoteProvider {
	List<MotivationQuote> getAll();
	MotivationQuote get(int position);
	void add(MotivationQuote motivationQuote);
}
