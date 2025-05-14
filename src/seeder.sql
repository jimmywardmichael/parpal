USE parpal_db;



CREATE TABLE IF NOT EXISTS users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       handicap INTEGER NOT NULL,
                       is_18 BOOLEAN NOT NULL,
                       name VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       is_org BOOLEAN NOT NULL
);




INSERT INTO users (id, email, handicap,  is_18, name, password, username, is_org) VALUES (1, 'Twoods@gmail.com', -5,  true,'Tiger Woods', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC' ,'twoods',  false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (2, 'Mjordan@gmail.com', 6,  true,'Michael Jordan', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'mj23' , false);

INSERT INTO users (id, email, handicap,  is_18, name, password, username, is_org) VALUES (3, 'Rmacilroy@gmail.com', -3, true,'Rory Mcilroy', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'roryboy' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (4, 'Apalmer@gmail.com', -12, true,'Arnold Palmer', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'teaboy' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (5, 'Smcgavin@gmail.com', -2, true,'Shooter McGavin', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'McGavin#1' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (6, 'Hgilmore@gmail.com', 3, true,'Happy Gilmore', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'grandmasboy' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (7, 'sammick@gmail.com', 15,  true,'Sam Mickelson', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'sammickelson' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (8, 'akendrick@gmail.com', 21, true,'Anna Kendrick', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'akendrick' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (9, 'shanebacon@gmail.com', 10, true,'Shane Bacon', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'sbacon' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (10, 'benhogan@gmail.com', 8, false,'Ben Hogan', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'benhogan' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (11, 'realhuman@gmail.com', 19, false, 'Hugh Mann', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'realhumanman' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (12, 'Chubbs@gmail.com', -6, true,'Chubbs Peterson', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'chubbs' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (13, 'Tywebb@gmail.com', -3,  true, 'Ty Webb', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'tywebb' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (14, 'Randyquaid@gmail.com', -8,  true, 'Randy Quaid', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'randyq' , false);

INSERT INTO users (id, email, handicap, is_18, name, password, username, is_org) VALUES (15, 'Tinacarlisle@gmail.com', 12, true, 'Tina Carlisle', '$2a$10$bfNTMcGx.0gfOV0BIPcu7OdrddLn8kanY0Txr0nPr6DmbXK3b08kC', 'tinacar', false);


INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (1, 'Reverand Greeen Golf Club', '2023-03-17 07:22:00', '2023-03-17 11:22:00', 'Set in a rolling country side, the course traverses lake fronts, river edges and hills.', false, 'The Golden Gate Open', 1);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (2, ' The Grove XXIII ', '2023-03-18 07:33:00', '2023-03-18 11:33:00', 'Open, rugged and windswept terrain spotted with plenty of obstacles. Sculpted along two miles of Florida shoreline.', true, 'MJ\'s March Madness Celebration', 2);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (3, 'The Club at Ravenswood', '2023-03-20 08:42:00', '2023-03-20 11:42:00', 'This Irish Course nestled just inland. Interspersed with four meandering streams. It''s Fescues of greens and golden browns is a course with real bite.', true, 'The Golf Club Championship', 4);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (4, 'The Royal Ethalwind', '2023-03-21 08:25:00', '2023-03-21 12:25:00', 'A lush, parkland-style course with manicured fairways and fast greens. Water hazards come into play on nearly every hole, demanding accuracy and finesse.', true, 'The Royals Championship', 5);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (5, 'Vaquero Valley Golf Course', '2023-03-24 09:45:00', '2023-03-24 12:45:00', 'Fore! Get ready to tee off on Jordy\'s 21st birthday at Vaquero Valley Golf Course. Swing into a day of celebration with 18 holes of fun and festivities. The course is waiting, so don\'t be a bunker and join us for a round of drinks and a slice of cake. ', true, 'Jody\'s 21th Birthday Party', 6);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (6, 'The Links at Nefyn', '2023-03-26 07:33:00', '2023-03-26 11:33:00', 'A links course on the rugged north coast of Wales. The front nine features rolling hills and views of the sea, while the back nine takes golfers through dunes and heathland.', true, 'The Welsh Open', 1);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (7, 'The Ocean Course at Kiawah Island', '2023-03-29 07:33:00', '2023-03-29 11:33:00', 'A challenging seaside course with wide fairways and punishing bunkers. The course is exposed to the elements, making wind a constant factor in play.', true, 'The Kiawah Classic', 2);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (8, 'The Belfry', '2023-04-01 08:15:00', '2023-04-01 11:15:00', 'One of the most iconic courses in the world, the Belfry has hosted the Ryder Cup four times. The course is known for its tight fairways and fast greens, as well as its famous par-5 10th hole.', true, 'The Belfry Open', 3);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (9, 'Pebble Beach Golf Links', '2023-04-04 08:24:00', '2023-04-04 11:24:00', 'One of the most famous courses in the world, Pebble Beach is set on the California coast and offers stunning views of the Pacific Ocean. The course is known for its small greens and challenging bunkers.', true, 'The Pebble Beach Invitational', 4);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (10, 'St. Andrews Links', '2023-04-08 08:22:00', '2023-04-08 10:22:00', 'The home of golf, St. Andrews Links is steeped in history and tradition. The course features iconic holes such as the Road Hole and the Swilcan Bridge. Host of the Open Championship.', true, 'The St. Andrews Classic', 5);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (11, 'Augusta National Golf Club', '2023-04-13 08:15:00', '2023-04-13 11:15:00', 'One of the most exclusive clubs in the world, Augusta National hosts the Masters Tournament each year. The course is known for its pristine condition, challenging greens, and iconic holes such as Amen Corner.', true, 'The Masters Tournament', 6);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (12, 'The Ocean Club Golf Course', '2023-04-02 07:33:00', '2023-04-02 10:33:00', 'A stunning golf course with pristine fairways, dramatic elevation changes and breathtaking views of the Atlantic Ocean.', true, 'The Bahamian Open', 7);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (13, 'St. Andrews Links', '2023-04-06 07:33:00', '2023-04-06 10:33:00', 'Known as the "Home of Golf", this historic course is the birthplace of the sport. The course features iconic landmarks such as the Swilcan Bridge and Hell Bunker.', true, 'The British Open', 8);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (14, 'Augusta National Golf Club', '2023-04-09 08:45:00', '2023-04-09 12:45:00', 'One of the most prestigious courses in the world, Augusta National is known for its lush fairways, fast greens, and iconic landmarks.', true, 'The Augusta Open', 1);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (15, 'Emerald Isle Golf Club', '2023-05-12 08:24:00', '2023-05-12 11:24:00', 'A beautiful links course located in the heart of Ireland. The course features rolling hills, deep bunkers, and wide fairways.', true, 'The Irish Open', 6);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (16, 'Dragons Breath Golf Resort', '2023-06-01 07:35:00', '2023-06-01 10:35:00', 'Nestled in the Misty Mountains. The course features narrow fairways, steep cliffs, and breathtaking views of the surrounding countryside.', true, 'The Dragons Challenge', 1);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (17, 'Amazon Rainforest Golf Course', '2023-06-15 08:45:00', '2023-06-15 11:45:00', 'A highly technical course located deep in the heart of the Amazon rainforest. The course features dense vegetation, narrow fairways and high cover.', true, 'The Amazon Open', 2);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (18, 'Diamond Desert Golf Club', '2023-07-02 08:23:00', '2023-07-02 11:23:00', 'A scorching course located in the heart of the Sahara Desert. The course features rolling sand dunes, deep bunkers, and sweeping cross winds.', true, 'The Diamond Classic', 3);

INSERT INTO events (id, course, date_time_end, date_time_start, description, is_18, title, host_id) VALUES (19, 'Northern Lights Golf Course', '2023-08-01 08:45:00', '2023-08-01 12:45:00', 'This course located deep in the Arctic Circle. The course features snow-covered fairways, frozen water hazards, and stunning views of the Northern Lights. The signature hole is a par 5 that requires golfers to hit over a frozen lake.', true, 'The Aurora Borealis Open', 4);