package blog.model;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Turis
 */
@Named
public class MotivationQuoteProviderImpl implements MotivationQuoteProvider {

	private List<MotivationQuote> quotes = new ArrayList<MotivationQuote>();

	public MotivationQuoteProviderImpl() {
		quotes.add(new MotivationQuote("The Way Get Started Is To Quit Talking And Begin Doing.", "Walt Disney"));
		quotes.add(new MotivationQuote("The Pessimist Sees Difficulty In Every Opportunity. The Optimist Sees The Opportunity In Every Difficulty.", "Winston Churchill"));
		quotes.add(new MotivationQuote("Don’t Let Yesterday Take Up Too Much Of Today.", "Will Rogers"));
	}

	public List<MotivationQuote> getAll() {
		return quotes;
	}

	public MotivationQuote get(int position) {
		if (quotes.size() <= position) {
			return null;
		}

		return quotes.get(position);
	}

	public void add(MotivationQuote motivationQuote) {
		quotes.add(motivationQuote);
	}
}
