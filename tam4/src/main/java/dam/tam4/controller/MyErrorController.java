package dam.tam4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController{

	@GetMapping("/error")
	public ModelAndView handleError(HttpServletRequest httpRequest) {
		ModelAndView errorPage = new ModelAndView("errorPage");
		Integer httpErrorCode = getErrorCode(httpRequest);
		System.out.println("\nError: " + httpErrorCode + "\n");
		httpRequest.getSession().setAttribute("errorCode", httpErrorCode);
		return errorPage;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	private Integer getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest
				.getAttribute("javax.servlet.error.status_code");
	}
}
