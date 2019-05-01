package voice_note_service.com.careem.dao.enities.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.NoteDto;

public interface NoteDaoSessionBeanInterface {
	List<NoteDto> getNotesByTripId(int tripId);

	int addNote(NoteDto note);
}
