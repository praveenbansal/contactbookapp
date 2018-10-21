package com.contact.src;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by praveen on 10/21/18.
 */
@Service
public class ContactDetailService
{
	private final static int PAGESIZE = 3;

	@Autowired
	ContactDetailRepository repository;

	ContactDetailService()
	{

	}

	public ContactDetail show(Long id)
	{
		return repository.findOne(id);
	}

	public ContactDetail add(String name,String email)
	{
		return repository.save(new ContactDetail(name,
				email));

	}

	public ContactDetail update(Long id,String name,String email)
	{
		ContactDetail contactDetail = repository.findById(id);

		return repository.save(contactDetail);
	}

	public boolean delete(Long id)
	{
		ContactDetail contactDetail = repository.findById(id);
		repository.delete(contactDetail);
		return true;
	}

	public List<ContactDetail> search(String name,String email)
	{
		if(name !=null && email !=null)
		{
			return repository.findByUserContainingOrEmailContaining(name,
					email);
		}
		else if(name !=null)
		{
			return repository.findByUser(name);
		}
		else
		{
			return repository.findByEmail(email);
		}
	}

	public List<ContactDetail> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "id");

		return repository.findAll(request).getContent();
	}
}
