package voice_note_service.com.careem.services;

import voice_note_service.com.careem.business.facade.CaptainFacadeSessionbean;
import voice_note_service.com.careem.dto.entities.NoteDto;

public class temp {

	public static void main(String[] args) {
		CaptainFacadeSessionbean captainFacadeSessionbean = new CaptainFacadeSessionbean();

		NoteDto note = new NoteDto();
		note.setNotes("TEST_NOTE_2");
		note.setTripId(1);

		captainFacadeSessionbean.getAllCaptinTripNotes(1).forEach(i -> System.out.println(i.getNotes()));

		int note_Id = captainFacadeSessionbean.addNote(note);
		System.out.println(note_Id);
	}

}
