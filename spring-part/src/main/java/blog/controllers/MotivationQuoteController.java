package blog.controllers;

import blog.model.MotivationQuote;
import blog.model.RemoteClient;
import blog.motivationQuoteService.MotivationQuoteProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author Marek Turis
 */
@Controller
@RequestMapping("/motivation-quotes")
public class MotivationQuoteController {

	@Inject
	private MotivationQuoteProvider motivationQuoteProvider;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String quotes(Model model, HttpServletRequest request) throws IOException {
		RemoteClient remoteObjectRetriever = new RemoteClient();
		List<MotivationQuote> motivationQuotes = remoteObjectRetriever.getMore("http://localhost:8081/blog/quote", MotivationQuote.class);
		model.addAttribute("motivationQuotes", motivationQuotes);
		return "all-quotes";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String addQuote(@ModelAttribute("newQuote") MotivationQuote quote, HttpServletRequest request, Model model) throws IOException {
		RemoteClient remoteObjectRetriever = new RemoteClient();
		boolean success = remoteObjectRetriever.doPost("http://localhost:8081/blog/quote", quote);

		if (success) {
			return "redirect:motivation-quotes";
		}

		model.addAttribute("isError", true);
		return "all-quotes";
	}
}
