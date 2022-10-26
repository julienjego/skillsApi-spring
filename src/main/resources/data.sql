DROP TABLE IF EXISTS `person` CASCADE;

CREATE TABLE `person` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birth_date` date DEFAULT NULL
);

INSERT INTO `person` (`first_name`, `last_name`, `birth_date`) VALUES 
('John','Doe','1958-10-02'),
('Jane','Donuts','1980-05-14'),
('Bob','Tile','1965-04-25'),
('James','Bond','1945-03-15'),
('Dan','George','1968-06-25');

DROP TABLE IF EXISTS `skills` CASCADE;

CREATE TABLE `skills` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `skill` varchar(45) DEFAULT NULL UNIQUE,
  `person_id` int NOT NULL,
  CONSTRAINT `FK_personId` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
);

INSERT INTO `skills` (`skill`, `person_id`)VALUES 
('Java',1),
('Bootstrap',2),
('Node.js',3),
('JS',4),
('HTML',4),
('CSS',4),
('Python',5),
('MySQL',3),
('Postman',2),
('Maven',2);

