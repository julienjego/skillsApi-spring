DROP TABLE IF EXISTS `person` CASCADE;

CREATE TABLE `person` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birth_date` date DEFAULT NULL
);

INSERT INTO `person` VALUES 
(1,'John','Doe','1958-10-02'),
(2,'Jane','Donuts','1980-05-14'),
(3,'Bob','Tile','1965-04-25'),
(4,'James','Bond','1945-03-15'),
(5,'Dan','George','1968-06-25');

DROP TABLE IF EXISTS `skills` CASCADE;

CREATE TABLE `skills` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `skill` varchar(45) DEFAULT NULL,
  `person_id` int NOT NULL,
  CONSTRAINT `FK_personId` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
);

INSERT INTO `skills` VALUES 
(1,'Java',1),
(2,'Bootstrap',2),
(3,'Node.js',3),
(4,'JS',4),
(5,'HTML',4),
(6,'CSS',4),
(7,'Python',5),
(8,'MySQL',3),
(9,'Postman',2),
(10,'Maven',2);

