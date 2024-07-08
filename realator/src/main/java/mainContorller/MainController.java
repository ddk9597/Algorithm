package mainContorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import service.MainService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
	
	private final MainService service;
	
	@PostMapping("")
	public String main() {
		return "searchresult/searchResult";
	}
	
}
