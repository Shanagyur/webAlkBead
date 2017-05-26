use requestregistry;

INSERT INTO Settlements(ID, Zip, City, Street, StreetNumber) VALUES 
	(1, 1111, 'Budapest', 'Alma utca', '1A'),
	(2, 2222, 'Pilis', 'Szilva utca', '5B'),
	(3, 3333, 'Miskolc', 'Eper utca', '9C');
	
INSERT INTO Details(Email, FirstName, LastName, Settlement) VALUES 
	('rozi@mail.hu', 'Retek', 'Rozi', 1),
	('pista@mail.hu', 'Bamba', 'Pista', 2),
	('anna@mail.hu', 'Lusta', 'Anna', 3);
	
INSERT INTO Users(Username, Password, Enabled, DetailsID) VALUES 
	('user', 'user', true, 1),
	('user1', 'user1', true, 2),
	('user2', 'user2', true, 3);
	
INSERT INTO UserRoles(ID, Username, Role) VALUES 
	(1, 'user', 'STUDENT_USER'),
	(2, 'user1', 'ADMIN_USER'),
	(3, 'user2', 'TEACHER_USER');
	
INSERT INTO Templates(Name, Description) VALUES 
	('Megajánlott jegy', 'Megajánlott jegy igénylése'),
	('Aláírás pótlás', 'Aláírás pórlására való igény'),
	('Pótvizsga', 'Pótvizsgára való igény');
	
INSERT INTO Requests(ID, UserID, TemplateName, Comment, Status) VALUES 
	(1, 'user', 'Megajánlott jegy', '4-es', 'Accepted'),
	(2, 'user', 'Aláírás pótlás', '', 'Pending'),
	(3, 'user', 'Pótvizsga', 'megtagadva', 'Denieded');
