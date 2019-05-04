/**
 *
 */
package voice_note_service.com.careem.business.facade;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import voice_note_service.com.careem.init.InitDtos;

/**
 * @author AhmedTalaat
 *
 */
public class CaptainFacadeSessionbeanTest extends InitDtos {
	private CaptainFacadeSessionbean captainFacade = new CaptainFacadeSessionbean();

	@Test
	public final void getAllCaptinTripNotes() {
		Assert.assertNotEquals(captainFacade.getAllCaptinTripNotes(1).size(), 0);
	}

	@Test
	public final void addNote() throws IOException {
		Assert.assertNotEquals(captainFacade.addNote(initNoteDto()), 0);
	}
}
