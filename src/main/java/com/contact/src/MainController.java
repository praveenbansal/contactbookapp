package com.contact.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController
{

	@Autowired
	ContactDetailService paginationService;


	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<ContactDetail> getPage(@RequestParam(name = "page", defaultValue = "1") int pageNumber){
		return paginationService.getPage(pageNumber);
	}

	@GetMapping("/contact")
	public ContactDetail show(@RequestParam(name = "id") String id){
		Long contactId = Long.parseLong(id);
		return paginationService.show(contactId);
	}

	@PostMapping("/contacts")
	public List<ContactDetail> search(@RequestBody Map<String, String> body){
		String name = body.get("name");
		String email = body.get("email");
		return paginationService.search(name,email);
	}

	@PostMapping("/contact")
	public ContactDetail create(@RequestBody Map<String, String> body){
		String user = body.get("name");
		String email = body.get("email");

			return paginationService.add(user,email);

	}

	@PutMapping("/contact")
	public ContactDetail update(@RequestParam(name = "id") String id, @RequestBody Map<String, String> body){
		String name = body.get("name");
		String email = body.get("email");
		return paginationService.update(Long.parseLong(id),name,email);
	}

	@DeleteMapping("contact")
	public boolean delete(@RequestParam(name = "id") String id){
		Long contactId = Long.parseLong(id);
		return paginationService.delete(contactId);
	}

}
