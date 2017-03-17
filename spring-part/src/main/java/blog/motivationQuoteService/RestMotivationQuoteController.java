package blog.motivationQuoteService;

import blog.model.MotivationQuote;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Marek Turis
 */
@RestController
@RequestMapping("/quote")
public class RestMotivationQuoteController {
	@Inject
	private MotivationQuoteProvider motivationQuoteProvider;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final List<MotivationQuote> getAll() {
		return motivationQuoteProvider.getAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final MotivationQuote getQuote(@PathVariable("id") int id) {
		return motivationQuoteProvider.get(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public final void createWeapon(@Valid @RequestBody MotivationQuote quote) {
		motivationQuoteProvider.add(quote);
	}
}
