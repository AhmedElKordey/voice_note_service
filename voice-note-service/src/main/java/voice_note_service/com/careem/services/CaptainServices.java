package voice_note_service.com.careem.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import voice_note_service.com.careem.business.facade.CaptainFacadeSessionbean;
import voice_note_service.com.careem.dto.entities.NoteDto;

@Path("/captain")
public class CaptainServices {

	private CaptainFacadeSessionbean captainFacadeSessionbean = new CaptainFacadeSessionbean();

	@GET
	@Path("/test-service")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it now !";
	}

	@GET
	@Path("/get-notes")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<NoteDto> getNotes() {
		return captainFacadeSessionbean.getAllCaptinTripNotes(1);
	}

	@POST
	@Path("/add-note")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public int addNote(@QueryParam("note") String noteContext, @QueryParam("tripId") int tripId) {
		NoteDto note = new NoteDto();
		note.setNotes(noteContext);
		note.setTripId(tripId);
		return captainFacadeSessionbean.addNote(note);
	}
}
