/**
 *
 */
package voice_note_service.com.careem.dto.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author AhmedTalaat
 *
 */
public class NoteDtoTest {
	private NoteDto note = new NoteDto();

	@Test
	public final void id() {
		int id = 1;
		note.setId(id);
		Assert.assertEquals(note.getId(), Integer.valueOf(id));
	}

	@Test
	public final void noteTitle() {
		String title = "noteTitle";
		note.setNoteTitle(title);
		Assert.assertEquals(note.getNoteTitle(), title);
	}

	@Test
	public final void notePath() {
		String notePath = "src/test/java";
		note.setNotePath(notePath);
		Assert.assertEquals(note.getNotePath(), notePath);
	}

	@Test
	public final void note() throws IOException {
		String soundFilePath = "src/test/resources";
		String soundFileName = "audio.mp3";

		File f = new File(soundFilePath, soundFileName);
		byte[] soundFileByteArray = new byte[(int) f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(soundFileByteArray);

		note.setNote(soundFileByteArray);
		fis.close();
		Assert.assertArrayEquals(note.getNote(), soundFileByteArray);
	}

	@Test
	public final void tripId() {
		int tripId = 1;
		note.setTripId(tripId);
		Assert.assertEquals(note.getTripId(), Integer.valueOf(tripId));
	}

}
