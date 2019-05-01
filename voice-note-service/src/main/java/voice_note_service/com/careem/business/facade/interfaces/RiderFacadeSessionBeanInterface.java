/**
 *
 */
package voice_note_service.com.careem.business.facade.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
public interface RiderFacadeSessionBeanInterface {
	// Get all available trips
	List<TripDto> getAllAvalibleTrips(int riderId);

	// Join Trip
	String joinTrip(int tripId, int riderId);

	// Display all notifications
	List<NoteDto> getAllUnReadedNotes(int riderTripId);

	// Read Notification
	RiderNotesDto readNote(int riderNoteId);
}
