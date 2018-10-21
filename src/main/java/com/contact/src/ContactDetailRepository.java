package com.contact.src;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailRepository
		extends JpaRepository<ContactDetail, Long>, PagingAndSortingRepository<ContactDetail, Long>
{

	// custom query to search to blog post by title or content
	List<ContactDetail> findByUserContainingOrEmailContaining(String name,
			String email);

	List<ContactDetail> findByUser(String user);

	List<ContactDetail> findByEmail(String email);

	ContactDetail findById(Long id);

	void deleteById(Long id);
}