INSERT INTO clients (nom, prenom, email, no_telephone, rue, code_postal, ville) VALUES
('Hanks', 'Tom', 'tom.hanks@example.com', '+1-555-123-4567', '123 Hollywood Blvd', '90001', 'Los Angeles'),
('Streep', 'Meryl', 'meryl.streep@example.com', '+1-555-987-6543', '456 Broadway', '10001', 'New York'),
('DiCaprio', 'Leonardo', 'leo.dicaprio@example.com', '+1-555-789-0123', '789 Sunset Blvd', '90028', 'Hollywood');
insert into genres (no_genre, libelle)
values (1, 'Collaboratif'), (2, 'Cartes'), (3, 'Plateau'), (4, 'Strategie')
,(5, 'Jeu de rôle'),(6, 'Educatif');
INSERT INTO JEUX (titre, reference, description, tarif_journee, ageMin, duree)
VALUES 
('Monopoly', 'MONO001', 'Jeu de société classique de gestion immobilière', 3.50, 8, 120),
('Cluedo', 'CLUE001', 'Jeu de déduction pour résoudre un meurtre mystérieux', 3.00, 8, 60),
('Welcome', 'WELC001', 'Jeu de société de construction de quartier', 2.50, 10, 25),
('Skyjo', 'SKYJ001', 'Jeu de cartes stratégique et familial', 2.00, 8, 30),
('Donjon & Dragon', 'D&D001', 'Jeu de rôle fantastique', 5.00, 12, 240),
('Catan', 'CATA001', 'Jeu de stratégie et de développement', 3.50, 10, 90);
insert into jeux_genres (no_jeu, no_genre)
values (1, 3), (2, 3), (3, 3), (4, 2), (5, 5), (6, 4);
insert into utilisateurs ( email,  mot_de_passe, role)
values ('bob', '{bcrypt}$2a$10$8IkbsSIu7.OzSwmIWXhMvexDoLDaY2XUAfBcqmYqFtHpnYmBkWpxq',
'EMPLOYE'), ('jane', '{bcrypt}$2a$10$8IkbsSIu7.OzSwmIWXhMvexDoLDaY2XUAfBcqmYqFtHpnYmBkWpxq',
'ADMIN')