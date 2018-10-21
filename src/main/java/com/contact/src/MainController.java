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
	public List<ContactDetail> getPage(@RequestParam(name = "p", defaultValue = "1") int pageNumber){
		return paginationService.getPage(pageNumber);
	}

	@GetMapping("/contact/{id}")
	public ContactDetail show(@PathVariable String id){
		Long contactId = Long.parseLong(id);
		return paginationService.show(contactId);
	}

	@PostMapping("/contact/search")
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

	@PutMapping("/contact/{id}")
	public ContactDetail update(@PathVariable String id, @RequestBody Map<String, String> body){
		String name = body.get("name");
		String email = body.get("email");
		return paginationService.update(Long.parseLong(id),
				name,
				email);
	}

	@DeleteMapping("contact/{id}")
	public boolean delete(@PathVariable String id){
		Long contactId = Long.parseLong(id);
		return paginationService.delete(contactId);
	}

	@RequestMapping(value = "/contacts/create", method = RequestMethod.GET)
	public boolean addmultiple(){
      for(int i=0;i<1000000;i++)
	  {
		  String name = "prav"+i;
		  String email = "prave@gm"+i;
		  paginationService.add(name,email);

	  }
		return true;
	}

}
