/**
 *
 */
package voice_note_service.com.careem.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.CaptainDto;
import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.dto.entities.RiderDto;
import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;
import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
public abstract class InitDtos {
	public CaptainDto initCaptainDto() {
		CaptainDto captain = new CaptainDto();
		captain.setEmail("test@gmail.com");
		captain.setMobile("010123456789");
		captain.setName("Test");
		return captain;
	}

	public NoteDto initNoteDto() throws IOException {
		String soundFilePath = "src/test/resources";
		String soundFileName = "audio.mp3";

		File f = new File(soundFilePath, soundFileName);
		byte[] soundFileByteArray = new byte[(int) f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(soundFileByteArray);

		NoteDto note = new NoteDto();
		note.setNoteTitle("Test");
		note.setNotePath("src/test/resources");
		note.setNote(soundFileByteArray);
		note.setReadCount(0);
		note.setRecivedCount(0);
		note.setSentCount(0);
		note.setTripId(1);
		fis.close();
		return note;
	}

	public RiderDto initRiderDto() {
		RiderDto rider = new RiderDto();
		rider.setEmail("test@gmail.com");
		rider.setMobile("010123456789");
		rider.setName("Test");
		return rider;
	}

	public RiderNotesDto initRiderNotesDto() {
		RiderNotesDto riderNote = new RiderNotesDto();
		riderNote.setNoteId(1);
		riderNote.setNoteStatus(JPAConstants.SENT);
		riderNote.setRiderTripID(1);
		riderNote.setTripId(1);
		return riderNote;
	}

	public RiderTripsDto initRiderTripsDto() {
		RiderTripsDto riderTrips = new RiderTripsDto();
		riderTrips.setRiderId(1);
		riderTrips.setTripId(1);
		return riderTrips;
	}

	public TripDto initTripDto() throws ParseException {
		Date fromTime = new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2019");
		Date toTime = new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2019");
		TripDto trip = new TripDto();
		trip.setCapId(1);
		trip.setFromPlace("Test Place 1");
		trip.setFromTime(fromTime);
		trip.setToPlace("Test Place 2");
		trip.setToTime(toTime);

		return trip;
	}

}
