# creating DataBase and use DB container
# create database bookseller;
use bookseller;

# tables creation
# Parent tables
create table authors(id int AUTO_INCREMENT,
                     firstname varchar(20),
                     lastname varchar(20),
                     initials char(2),
                     birth_date date,
                     gender char(1) check(gender='M' or gender='F' or gender='U') default 'U',
                     contact_details varchar(100),
                     other_details varchar(100),
                     primary key(id));

create table book_categories(code int AUTO_INCREMENT,
                             category_description varchar(20),
                             primary key(code));

#Phone in format of +37360000000
create table customers(id int AUTO_INCREMENT,
                       idnp char(13),
                       name varchar(20),
                       address varchar(20),
                       phone char(12),
                       email varchar(30) check(email like '%@%.com'),
                       primary key(id));


#Parent-Children tables
create table books(id int AUTO_INCREMENT,
                   author_id int,
                   book_category_code int,
                   isbn varchar(17),
                   publication_date date,
                   date_aquired date,
                   title varchar(50),
                   recommended_price decimal(6, 2),
                   comments varchar(100),
                   primary key(id),
                   foreign key(author_id) references authors(id) on delete cascade,
                   foreign key(book_category_code) references book_categories(code) on delete cascade);



create table orders(id int AUTO_INCREMENT,
                    customer_id int,
                    order_date date,
                    order_value decimal(7,2),
                    primary key(id),
                    foreign key(customer_id) references customers(id) on delete set null);


create table order_items(id int AUTO_INCREMENT,
                         order_id int,
                         book_id int,
                         item_Agreed_Price decimal(6, 2),
                         item_comment varchar(100),
                         primary key(id),
                         foreign key (order_id) references orders(id) on delete cascade,
                         foreign key (book_id) references books(id) on delete set null);






#contacts tables
#Parent
create table ref_contact_types(code int AUTO_INCREMENT,
                               contact_type_description varchar(20),
                               primary key(code));

#Parent-Children
create table contacts(id int AUTO_INCREMENT,
                      contact_type_code int,
                      firstname varchar(20),
                      lastname varchar(20),
                      work_phone char(12),
                      cell_phone char(12),
                      other_details varchar(100),
                      primary key(id),
                      foreign key(contact_type_code) references ref_contact_types(code));

#filling tables with data
#insert data into `authors`
insert into authors (id, firstname, lastname, initials, birth_date, gender, contact_details, other_details)
values
(1, 'John', 'Doe', 'JD', '1970-01-01', 'M', 'john.doe@gmail.com', 'Some details here'),
(2, 'Jane', 'Smith', 'JS', '1980-02-02', 'F', 'jane.smith@mail.com', 'Some details here');

#insert data into `book_categories`
insert into book_categories (code, category_description)
values
(1, 'Fiction'),
(2, 'Non-Fiction');

#insert data into `customers`
insert into customers (id, idnp, name, address, phone, email)
values
(1, '1234567890123', 'Alice Brown', '123 Main St', '+37360000001', 'alice.brown@yahoo.com'),
(2, '9876543210987', 'Bob Johnson', '456 Elm St', '+37360000002', 'bob.johnson@hotmail.com');

#insert data into `books`
insert into books (id, author_id, book_category_code, isbn, publication_date, date_aquired, title, recommended_price, comments)
values
(1, 1, 1, '978-3-16-148410-0', '2020-01-01', '2021-01-01', 'The Great Adventure', 19.99, 'Bestseller'),
(2, 2, 2, '978-1-23-456789-7', '2019-01-01', '2021-01-02', 'Science for Beginners', 29.99, 'Excellent for students'),
(3, 2, 1, '123-4-56-789098-7', '2019-9-10', '2019-9-10', 'Java for Beginners', 999.99, 'Excellent for true javers');

#insert data into `orders`
insert into orders (id, customer_id, order_date, order_value)
values
(1, 1, '2021-01-03', 49.98),
(2, 2, '2021-01-04', 29.99);

-- insert data into `order_items`
insert into order_items (id, order_id, book_id, item_agreed_price, item_comment)
values
(1, 1, 1, 19.99, 'Gift wrapped'),
(2, 1, 2, 29.99, ''),
(3, 2, 2, 29.99, 'Include a bookmark');

#insert data into `ref_contact_types`
insert into ref_contact_types (code, contact_type_description)
values
(1, 'Author'),
(2, 'Supplier');

#insert data into `contacts`
insert into contacts (id, contact_type_code, firstname, lastname, work_phone, cell_phone, other_details)
values
(1, 1, 'John', 'Doe', '+37360000003', '+37360000004', 'Contact for book signings'),
(2, 2, 'Supply', 'Company', '+37360000005', '+37360000006', 'Bulk order contact');