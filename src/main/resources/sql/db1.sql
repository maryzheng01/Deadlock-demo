CREATE TABLE DEMO_JDBC_TYPE 
(
guid varchar(36) NOT NULL,
lastName varchar(255),
firstName varchar(255),
address varchar(255),
city nvarchar(300),
createdDate DATETIME,
budget  numeric(15,5),
name  char(40),
status  char(1),
active  bit,
message  nvarchar(4000)
);
 
INSERT INTO DEMO_JDBC_TYPE(guid, lastName, firstName, name, address, city, status, active, message)
VALUES('GUID_1','Zheng', 'Mary', 'Test Name', '100 street', 'Ballwin', 'A', 1, 'Test message');


INSERT INTO DEMO_JDBC_TYPE(guid, lastName, firstName, name, address, city, status, active, message)
VALUES('GUID_1','zheng', 'Terry', 'Demo Name', '200 street', 'Ballwin', 'A', 1, 'NA message');