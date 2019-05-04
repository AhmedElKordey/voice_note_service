/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.init.InitDtos;

/**
 * @author AhmedTalaat
 *
 */
public class NoteDaoSessionBeanTest extends InitDtos {
	private NoteDaoSessionBean noteDao = new NoteDaoSessionBean();

	@Test
	public final void getNotesByTripIdNotEmpty() {
		Assert.assertNotEquals(noteDao.getNotesByTripId(1).size(), 0);
	}

	@Test
	public final void getNotesByTripIdNotNull() {
		Assert.assertNotNull(noteDao.getNotesByTripId(1));
	}

	@Test
	public final void addNote() throws IOException {
		Assert.assertNotEquals(noteDao.addNote(initNoteDto()), 0);
	}

	@Test
	public final void getNoteById() {
		NoteDto note = noteDao.getNoteById(1);
		Assert.assertEquals(note.getId(), Integer.valueOf(1));
	}
}
