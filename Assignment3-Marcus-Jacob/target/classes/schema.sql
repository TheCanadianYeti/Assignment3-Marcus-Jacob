CREATE TABLE mission (
	id LONG PRIMARY KEY AUTO_INCREMENT,
	agent VARCHAR(50),
	title VARCHAR(50),
	gadget1 VARCHAR(50),
	gadget2 VARCHAR(50)
);

INSERT INTO mission
	(agent, title, gadget1, gadget2)
VALUES
	('Johnny English','Rescue the Queen',
	'Exploding Cigar','Voice Controlled Rolls Royce'),
	
	('Natasha Romanova','Kill Iron Man',
	'Armored Suit','Industructible Pole'),

    ('Austin Powers','Stop Dr. Evil',
    'Shagadelic Spy Camera','Mini Cooper Ejector Seat');