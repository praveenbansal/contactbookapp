# contactbookapp

Rest EndPoints Usage 
For listing all Contacts:
https://contactbook1.herokuapp.com/contacts ( this will list by default 10 entries of first page)

For listing contacts for particular page no.
https://contactbook1.herokuapp.com/contacts?page=20

To search to Contact based on name or email or any.
POST Request        https://contactbook1.herokuapp.com/contacts
Body Raw Json   :    {
   "name": "praveen"
    "email": "praveenbansal09@gmail.com"
}

 To create Contact 
https://contactbook1.herokuapp.com/contact
POST Request        https://contactbook1.herokuapp.com/contact
Body Raw Json   :    {
   "name": "praveen"
    "email": "praveenbansal09@gmail.com"
}

To update Contact
https://contactbook1.herokuapp.com/contact
PUT Request        https://contactbook1.herokuapp.com/contact?id=5
Body Raw Json   :    {
   "name": "praveen"
    "email": "praveenbansal09@gmail.com"
}

To delete Contact
Delete Request     https://contactbook1.herokuapp.com/contact?id=5



Mysql Migration:

CREATE TABLE contact_detail (
  id bigint(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user VARCHAR(500) NOT NULL,
  email VARCHAR(500) NOT NULL
);

ALTER TABLE `contact_detail` ADD UNIQUE ( email(200) );



