SET FOREIGN_KEY_CHECKS=0;
truncate table users ;
truncate table media ;
SET FOREIGN_KEY_CHECKS=1;

insert into organiser(id,name, email, password, phoneNumber,eventList,attendeesList) values
    (200, 'praise',  'praise@gmail.com', '$2a$10$HkEhXj19m3va5HFH5VOsqeJGySK5LDOY9CGsH0KA3w9A1jVmX7Xpa', '09028979349',100,300),
    (201, 'israel',  'israel@gmail.com', '$2a$10$HkEhXj19m3va5HFH5VOsqeJGySK5LDOY9CGsH0KA3w9A1jVmX7Xpa', '09164998141',101,301),
    (202, 'joy',     'joy@gmail.com', '$2a$10$HkEhXj19m3va5HFH5VOsqeJGySK5LDOY9CGsH0KA3w9A1jVmX7Xpa', '09123456712',102 ,302),
    (203, 'precious','precious@gmail.com', '$2a$10$HkEhXj19m3va5HFH5VOsqeJGySK5LDOY9CGsH0KA3w9A1jVmX7Xpa','081231216788',103,303);

insert into events(id,name,description,eventDateAndTime,location,organizerId) values
   (101,'wedding','real and p','2024-06-04T15:03:03.792009700','victoria island',200),
   (102, 'house warming','dad and mum','2024-06-04T15:03:03.792009700', 'ijebu',201),
   (103, 'anniversary', 'church anniversary','2024-06-04T15:03:03.792009700', 'usa',200),
   (100, 'graduation', 'semicolon graduation','2024-06-04T15:03:03.792009700','semicolon',202);


insert into attendees(id,name,phoneNumber,email,password,reservations) values
    (300,'king','09067879876','king@gmail.com','kingpassword',400)
    (301, 'samuel','07067645321','samuel@gmail.com','samuelpassword', 401)
    (302, 'freddie', '08083339462','freddie@gmail.com','freddiepassword',402)
    (303, 'david', '08136946731','david@gmail.com','semicolon','davidpassword',403);

insert into reservations(id,attendeeId,ticketId,reservationDateAndTime,reservationCategory)  values
    (400, 300, 500,'2024-06-04T15:03:03.792009700','RESERVED')
    (401, 300, 501,'2024-06-04T15:03:03.792009700','CANCELLED')
    (402, 302, 502,'2024-06-04T15:03:03.792009700','PENDING')
    (403, 301, 503,'2024-06-04T15:03:03.792009700','RESERVED');

insert into tickets(title,description,venueName,category,organizerId,price,reserveTicket,attendeeId,eventDateAndTime,id) values
    ('wedding','janet and eniola','inside the bush')
    ('birthday','praise byday','int the moon')
    ('graduation', 'my graduation','semicolon')
    ('anniversary', 'wedding anniversary',)