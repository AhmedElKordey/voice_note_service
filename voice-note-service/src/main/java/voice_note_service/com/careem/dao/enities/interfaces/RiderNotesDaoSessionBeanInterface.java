/**
 *
 */
package voice_note_service.com.careem.dao.enities.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;

/**
 * @author AhmedTalaat
 *
 */
public interface RiderNotesDaoSessionBeanInterface {
	long getNoteCountsStatusForTrip(int tripId, int statusCode, int noteId);

	void addRiderNotes(int noteId, int tripId, List<RiderTripsDto> riderTrips);

	RiderNotesDto addRiderNote(RiderNotesDto riderNote);

	List<RiderNotesDto> getAllUnReadedNotesForRiderTrip(int riderTripId);

	RiderNotesDto updateStatusOfNotes(RiderNotesDto riderNote, int status);

	RiderNotesDto getRiderNoteById(int riderNoteId);
}
