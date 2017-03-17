package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Marek Turis
 */
@Controller
@RequestMapping("/area")
public class ExampleController {
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String list(Model model) {
		return "it workds";
	}
}
