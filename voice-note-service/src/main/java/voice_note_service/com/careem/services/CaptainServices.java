package voice_note_service.com.careem.services;

import java.util.List;

import javax.ws.rs.Consumes;
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
		return "Iam Working !";
	}

	@GET
	@Path("/get-notes")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<NoteDto> getNotes(@QueryParam("tripId") int tripId) {
		return captainFacadeSessionbean.getAllCaptinTripNotes(tripId);
	}

	@POST
	@Path("/add-note")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public int addNote(NoteDto note) {
		return captainFacadeSessionbean.addNote(note);
	}
}
