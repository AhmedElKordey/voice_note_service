package voice_note_service.com.careem.business.facade;
/**
 *
 */

import java.util.ArrayList;
import java.util.List;

import voice_note_service.com.careem.business.facade.interfaces.CaptainFacadeSessionBeanInterface;
import voice_note_service.com.careem.dao.enities.NoteDaoSessionBean;
import voice_note_service.com.careem.dao.enities.RiderNotesDaoSessionBean;
import voice_note_service.com.careem.dao.enities.RiderTripsDaoSessionBean;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;

/**
 * @author AhmedTalaat
 */

public class CaptainFacadeSessionbean implements CaptainFacadeSessionBeanInterface {

	private NoteDaoSessionBean noteDaoSessionBean = new NoteDaoSessionBean();
	private RiderNotesDaoSessionBean riderNotesDaoSessionBean = new RiderNotesDaoSessionBean();
	private RiderTripsDaoSessionBean riderTripsDaoSessionBean = new RiderTripsDaoSessionBean();

	@Override
	public List<NoteDto> getAllCaptinTripNotes(int tripId) {
		List<NoteDto> notes = new ArrayList<>();
		// Get all notes related to specific trip
		notes.addAll(noteDaoSessionBean.getNotesByTripId(tripId));
		// for each one check count of sent , received and read flags
		notes.forEach(note -> {
			note.setSentCount(
					riderNotesDaoSessionBean.getNoteCountsStatusForTrip(tripId, JPAConstants.SENT, note.getId()));
			note.setRecivedCount(
					riderNotesDaoSessionBean.getNoteCountsStatusForTrip(tripId, JPAConstants.RECIVED, note.getId()));
			note.setReadCount(
					riderNotesDaoSessionBean.getNoteCountsStatusForTrip(tripId, JPAConstants.READ, note.getId()));
		});
		return notes;
	}

	@Override
	public int addNote(NoteDto note) {
		// add note
		int noteId = noteDaoSessionBean.addNote(note);
		int tripId = note.getTripId();

		// notify riders about this note
		// 1-get all riders related to this trip
		List<RiderTripsDto> riderTrips = new ArrayList<>();
		riderTrips.addAll(riderTripsDaoSessionBean.getAllRiderForSpecificTrip(tripId));

		// 2- add notes in riderNotes table
		riderNotesDaoSessionBean.addRiderNotes(noteId, tripId, riderTrips);

		return noteId;
	}

}
