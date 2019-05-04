Delete from vns.rider where id < 100;
ALTER TABLE vns.rider AUTO_INCREMENT = 1;
insert into vns.rider(Name , Mobile , email) values ('RIDER_1' , '010' , 'RIDER_1@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_2' , '011' , 'RIDER_2@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_3' , '012' , 'RIDER_3@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_4' , '015' , 'RIDER_4@gmail.com');

select * from vns.rider;

Delete from vns.cap where id < 100;
ALTER TABLE vns.cap AUTO_INCREMENT = 1;
insert into vns.cap(Name , Mobile , email) values ('CAP_1' , '010' , 'CAP_1@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_2' , '011' , 'CAP_2@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_3' , '012' , 'CAP_3@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_4' , '015' , 'CAP_4@gmail.com');

select * from vns.cap;

Delete from vns.trip where id < 100;
ALTER TABLE vns.trip AUTO_INCREMENT = 1;
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_A' , 'Place_B' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 1);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_C' , 'Place_D' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 2);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_E' , 'Place_F' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 3);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_G' , 'Place_H' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 4);

select * from vns.trip;

Delete from vns.notes where id < 100;
ALTER TABLE vns.notes AUTO_INCREMENT = 1;
INSERT INTO notes (`NoteTitle`,`TimeStamp`,`TripId`,`NotePath`) VALUES ('NOTE_1','2019-05-03 20:01:33',1,'src/test/resources');
INSERT INTO notes (`NoteTitle`,`TimeStamp`,`TripId`,`NotePath`) VALUES ('NOTE_2','2019-05-03 20:01:33',2,'src/test/resources');
INSERT INTO notes (`NoteTitle`,`TimeStamp`,`TripId`,`NotePath`) VALUES ('NOTE_3','2019-05-03 20:01:33',1,'src/test/resources');

select * from vns.notes;

Delete from vns.rider_trips where id < 100;
ALTER TABLE vns.rider_trips AUTO_INCREMENT = 1;
insert into vns.rider_trips (riderid , tripid) values ( 1 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 2 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 3 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 4 , 1 );

select * from vns.rider_trips;

Delete from vns.rider_notes where id < 100;
ALTER TABLE vns.rider_notes AUTO_INCREMENT = 1;
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 1 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 2 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 3 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 4 , 1 , 1 );

select * from vns.rider_notes;

Update vns.rider_notes set NoteStatus = 1 where id = 1;
Update vns.rider_notes set NoteStatus = 2 where id = 2;

select * from vns.rider_notes;