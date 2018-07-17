-- One large Cypher query to load the database
CREATE (Scott:Person {name:'Scott Christopher', born:1965})
CREATE (Mike:Person {name:'Michael Blevins', born:1945})
CREATE (Carol:Person {name:'Carol Maureen', born:1945})
CREATE (Courtney:Person {name:'Courtney Janice', born:1966})
CREATE (Jeremy:Person {name:'Jeremy Douglas', born:1969})
CREATE (Zane:Person {name:'Michael Zane', born:1973})
CREATE (Kelly:Person {name:'Kelly Hadley Leigh', born:1977})
CREATE (Jesse:Person {name:'Jesse Lucas', born:1977})
CREATE (Gabe:Person {name:'Gabriel Josiah', born:1979})
CREATE (Esme:Person {name:'Esme Alexis', born:1981})
CREATE (Gail:Person {name:'Gail Ann', born:1942})
CREATE (Steve:Person {name:'Steven Lester', born:1950})
CREATE
	(Mike)-[:MARRIED {married:1964, divorced:1973}]->(Carol),
	(Mike)-[:MARRIED {married:1972, divorced:1992}]->(Gail),
	(Steve)-[:MARRIED {married:1976}]->(Carol),
	(Mike)-[:FATHER]->(Scott),
	(Mike)-[:FATHER]->(Courtney),
	(Mike)-[:FATHER]->(Jeremy),
	(Mike)-[:FATHER]->(Zane),
	(Mike)-[:FATHER]->(Kelly),
	(Carol)-[:MOTHER]->(Scott),
	(Carol)-[:MOTHER]->(Courtney),
	(Carol)-[:MOTHER]->(Jeremy),
	(Carol)-[:MOTHER]->(Jesse),
	(Carol)-[:MOTHER]->(Gabe),
	(Carol)-[:MOTHER]->(Esme),
	(Gail)-[:MOTHER]->(Zane),
	(Gail)-[:MOTHER]->(Kelly),
	(Steve)-[:FATHER]->(Jesse),
	(Steve)-[:FATHER]->(Gabe),
	(Steve)-[:FATHER]->(Esme)
CREATE (Iowa:University {name:'University of Iowa', location:'Iowa City, IA'})
CREATE (IowaLS:University {name:'University of Iowa Law School', location:'Iowa City, IA'})
CREATE (Elon:University {name:'Elon University', location:'Elon, NC'})
CREATE (NCState:University {name:'North Carolina State University', location:'Raleigh, NC'})
CREATE (Drake:University {name:'Drake Law School', location:'Des Moines, IA'})
CREATE (STU:University {name:'University of Saint Thomas', location:'Saint Paul, MN'})
CREATE (UMN:University {name:'University of Minnesota', location:'Minneapolis, MN'})
CREATE (NW:University {name:'Northwestern University', location:'Evanston, IL'})
CREATE (SJLS:University {name:'St Johns Law School', location:'New York, NY'})
CREATE (UVA:University {name:'University of Virginia', location:'Charlottesville, VA'})
CREATE (DUB:University {name:'University of Dubuque', location:'Dubuque, IA'})
CREATE (WIU:University {name:'Western Illinois University', location:'Macomb, IL'})
CREATE
	(Mike)-[:GRADUATED]->(NW),
	(Mike)-[:GRADUATED]->(SJLS),
	(Carol)-[:GRADUATED]->(DUB),
	(Gail)-[:GRADUATED]->(UVA),
	(Scott)-[:GRADUATED]->(Iowa),
	(Scott)-[:ATTENDED]->(STU),
	(Scott)-[:ATTENDED]->(UMN),
	(Courtney)-[:GRADUATED]->(Iowa),
	(Jeremy)-[:GRADUATED]->(Iowa),
	(Jeremy)-[:ATTENDED]->(Drake),
	(Jeremy)-[:GRADUATED]->(IowaLS),
	(Zane)-[:GRADUATED]->(Elon),
	(Kelly)-[:ATTENDED]->(NCState),
	(Kelly)-[:ATTENDED]->(Iowa),
	(Esme)-[:ATTENDED]->(WIU)


-- One example query to do off the data loaded
match path=(s {name:'Michael Blevins'})-[*]->(u:University {name:'Western Illinois University'}) return path