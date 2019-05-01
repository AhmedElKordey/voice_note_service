/**
 *
 */
package voice_note_service.com.careem.business.facade.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.NoteDto;

/**
 * @author AhmedTalaat
 */
public interface CaptainFacadeSessionBeanInterface {
	List<NoteDto> getAllCaptinTripNotes(int tripId);

	int addNote(NoteDto note);
}
