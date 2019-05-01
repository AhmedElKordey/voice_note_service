package voice_note_service.com.careem.dao.enities;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import voice_note_service.com.careem.dao.enities.interfaces.NoteDaoSessionBeanInterface;
import voice_note_service.com.careem.dao.generic.GenericDao;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.NoteDto;

@Stateless
@Local(NoteDaoSessionBeanInterface.class)
public class NoteDaoSessionBean extends GenericDao implements NoteDaoSessionBeanInterface {

	@Override
	public List<NoteDto> getNotesByTripId(int tripId) {
		try {
			init();
			List<NoteDto> noteList = new ArrayList<>();
			noteList.addAll(
					entityManager.createNamedQuery(NoteDto.NAMED_QUERY_GET_ALL_NOTES_FOR_SPECIFIC_TRIP, NoteDto.class)
							.setParameter(JPAConstants.TRIP_ID, tripId).getResultList());
			close();
			return noteList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addNote(NoteDto note) {
		try {
			int noteId = 0;
			init();
			noteId = persistEntity(note).getId();
			close();
			return noteId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public NoteDto getNoteById(int noteId) {
		NoteDto note = new NoteDto();
		try {
			init();
			note = entityManager.createNamedQuery(NoteDto.NAMED_QUERY_GET_NOTE_BY_ID, NoteDto.class)
					.setParameter(JPAConstants.NOTE_ID, noteId).getSingleResult();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return note;
	}

}
