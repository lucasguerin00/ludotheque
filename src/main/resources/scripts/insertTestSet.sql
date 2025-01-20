INSERT INTO clients (nom, prenom, email, no_telephone, rue, code_postal, ville) VALUES
('Dupont', 'Jean', 'jean.dupont@example.com', '+33-1-01-01-01-01', '10 rue de Paris', '75001', 'Paris'),
('Martin', 'Claire', 'claire.martin@example.com', '+33-1-02-02-02-02', '20 avenue des Champs', '75008', 'Paris'),
('Durand', 'Pierre', 'pierre.durand@example.com', '+33-1-03-03-03-03', '30 boulevard St-Germain', '75005', 'Paris'),
('Lemoine', 'Sophie', 'sophie.lemoine@example.com', '+33-1-04-04-04-04', '40 rue de la République', '69001', 'Lyon'),
('Bernard', 'François', 'francois.bernard@example.com', '+33-1-05-05-05-05', '50 place Bellecour', '69002', 'Lyon'),
('Robert', 'Alice', 'alice.robert@example.com', '+33-1-06-06-06-06', '60 rue de la Liberté', '13001', 'Marseille'),
('Roux', 'Michel', 'michel.roux@example.com', '+33-1-07-07-07-07', '70 rue de la Canebière', '13002', 'Marseille'),
('Lefevre', 'Juliette', 'juliette.lefevre@example.com', '+33-1-08-08-08-08', '80 rue de la République', '31000', 'Toulouse'),
('Blanc', 'David', 'david.blanc@example.com', '+33-1-09-09-09-09', '90 place du Capitole', '31001', 'Toulouse'),
('Pires', 'Isabelle', 'isabelle.pires@example.com', '+33-1-10-10-10-10', '100 rue des Pyrénées', '59000', 'Lille'),
('Guerin', 'Lucas', 'lucasguerin3@gmail.com', '+33-6-80-15-28-46', '88 rue Paul Bellamy', '44000', 'Nantes'),
('Pallois', 'Nicolas', 'nico.pallois@exemple.com', '+33-11-10-10-10-10', 'FC Nantes', '44000', 'Nantes');

INSERT INTO JEUX (titre, reference, description, tarif_journee, ageMin, duree) VALUES
('Monopoly', 'MON123', 'Jeu de société où les joueurs achètent et vendent des propriétés pour accumuler de l argent.', 15.50, 8, 60),
('Scrabble', 'SCR456', 'Jeu de mots où les joueurs créent des mots à partir de lettres tirées au hasard.', 12.00, 10, 45),
('Clue', 'CLU789', 'Jeu de déduction dans lequel les joueurs essaient de résoudre un meurtre.', 18.00, 12, 50),
('Risk', 'RIS101', 'Jeu de stratégie où les joueurs s affrontent pour prendre le contrôle du monde.', 20.00, 12, 120),
('Jenga', 'JEN202', 'Jeu d adresse où les joueurs retirent des blocs de bois sans faire tomber la tour.', 10.00, 6, 30),
('Catan', 'CAT303', 'Jeu de stratégie où les joueurs collectent des ressources pour construire des colonies et des routes.', 25.00, 10, 90),
('Ticket to Ride', 'TTR404', 'Jeu de stratégie où les joueurs collectent des cartes pour construire des lignes de chemin de fer.', 22.00, 8, 60),
('Pandemic', 'PAN505', 'Jeu coopératif où les joueurs travaillent ensemble pour éradiquer des maladies mondiales.', 30.00, 12, 45),
('7 Wonders', '7W607', 'Jeu de civilisation où les joueurs développent leur empire à travers des cartes représentant des bâtiments et des ressources.', 17.50, 10, 40),
('Twister', 'TWI708', 'Jeu d adresse où les joueurs doivent placer leurs mains et pieds sur des couleurs sans tomber.', 8.00, 6, 20);

insert into genres (no_genre, libelle)
values (1, 'Collaboratif'), (2, 'Cartes'), (3, 'Plateau'), (4, 'Strategie'),(5, 'Jeu de rôle'),(6, 'Educatif');