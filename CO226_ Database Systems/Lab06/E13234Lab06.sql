-- (02)
-- 01.
	SELECT PerformerName, ActivityName FROM Activities NATURAL JOIN Performers;

-- 02.
	CREATE VIEW Act_perf AS SELECT PerformerName, ActivityName FROM Activities NATURAL JOIN Performers;
	
-- 03.
	SELECT * FROM Act_perf;
	
-- 04.
	INSERT INTO Performers VALUES(8, 'Kamal Arachchi', 'Kandy', 'Margaritaville', 'FL', 25543, 4);
	SELECT * FROM Act_perf;
	
	
mysql> select * from Act_perf;
+----------------+---------------------------+
| PerformerName  | ActivityName              |
+----------------+---------------------------+
| Harry Chapin   | Doctors without Borders   |
| Billy Joel     | Greenpeace                |
| James Taylor   | Music in Schools          |
| Harry Connick  | Save the Whales           |
| Tony Bennett   | USO for Troops            |
| Jimmy Buffett  | Doctors without Borders   |
| Kamal Arachchi | Home for Aging Rock Stars |
+----------------+---------------------------+
7 rows in set (0.12 sec)

Yes result is changed. When view is called then the query executed and give the result.

-- 05.
	SELECT PerformerName,ArenaName,ConcertDate, TicketPrice * ArenaCapacity * 0.8 * 0.9 AS Total_Income
    FROM  Concerts c, Arenas a,Performers p
	WHERE p.PerformerID=c.PerformerID AND a.ArenaID = c.ArenaID;
	
-- (03)
-- (a)
	DELIMITER //
	CREATE TRIGGER deletePerformer
	BEFORE DELETE 
	ON Performers
	FOR EACH ROW
	begin
	WHEN ( 2 >( SELECT count(ActivityID)
	FROM Performers
	WHERE  PerformerID = old.PerformerID) )
	
	SIGNAL SQLSTATE ”45000” SET MESSAGE TEXT = ”Salary	Violation Occurred”
	end; //
	DELIMITER ;
	
-- (04)
	DELIMITER //
	CREATE PROCEDURE spInsertConcert(performer_id varchar(50), arena_id varchar(50), concert_date varchar(50),ticket_price varchar(50))
		BEGIN
		if(performer_id not in (select PerformerID from Concerts where ConcertDate = concert_date) and
			arena_id not in (select ArenaID from Concerts where ConcertDate = concert_date)) then
			INSERT INTO Concerts (PerformerID, ArenaID, ConcertDate, TicketPrice) VALUES (performer_id, arena_id, concert_date, ticket_price);
		end if;
		END //
	DELIMITER ;
	
