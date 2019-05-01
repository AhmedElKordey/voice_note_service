insert into vns.rider(Name , Mobile , email) values ('RIDER_1' , '010' , 'RIDER_1@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_2' , '011' , 'RIDER_2@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_3' , '012' , 'RIDER_3@gmail.com');
insert into vns.rider(Name , Mobile , email) values ('RIDER_4' , '015' , 'RIDER_4@gmail.com');

select * from vns.rider;

insert into vns.cap(Name , Mobile , email) values ('CAP_1' , '010' , 'CAP_1@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_2' , '011' , 'CAP_2@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_3' , '012' , 'CAP_3@gmail.com');
insert into vns.cap(Name , Mobile , email) values ('CAP_4' , '015' , 'CAP_4@gmail.com');

select * from vns.cap;

insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_A' , 'Place_B' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 1);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_C' , 'Place_D' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 2);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_E' , 'Place_F' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 3);
insert into vns.trip(FromPlace , ToPlace , FromTime , ToTime , CapId) values ('Place_G' , 'Place_H' , '2019-05-01 12:00:00' , '2019-05-01 16:00:00' , 4);

select * from vns.trip;

insert into vns.notes(Note , Tripid) values ('NOTE_1' , 1);
insert into vns.notes(Note , Tripid) values ('NOTE_2' , 2);
insert into vns.notes(Note , Tripid) values ('NOTE_3' , 1);

select * from vns.notes;

insert into vns.rider_trips (riderid , tripid) values ( 1 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 2 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 3 , 1 );
insert into vns.rider_trips (riderid , tripid) values ( 4 , 1 );

select * from vns.rider_trips;

insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 1 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 2 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 3 , 1 , 1 );
insert into vns.rider_notes (rider_trip_id , noteid , tripid ) values ( 4 , 1 , 1 );

select * from vns.rider_notes;

Update vns.rider_notes set NoteStatus = 1 where id = 1;
Update vns.rider_notes set NoteStatus = 2 where id = 2;

select * from vns.rider_notes;