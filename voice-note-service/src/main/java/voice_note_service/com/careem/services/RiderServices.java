/**
 *
 */
package voice_note_service.com.careem.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import voice_note_service.com.careem.business.facade.RiderFacadeSessionbean;
import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
@Path("/rider")
public class RiderServices {
	private RiderFacadeSessionbean riderFacadeSessionbean = new RiderFacadeSessionbean();

	@GET
	@Path("/get-available-trips")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<TripDto> getTrips(@QueryParam("riderId") int riderId) {
		return riderFacadeSessionbean.getAllAvalibleTrips(riderId);
	}

	@POST
	@Path("/join-trip")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String joinTrip(@QueryParam("tripId") int tripId, @QueryParam("riderId") int riderId) {
		return riderFacadeSessionbean.joinTrip(tripId, riderId);
	}

	@GET
	@Path("/get-notes")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<NoteDto> getAllUnReadedNotes(@QueryParam("riderId") int riderTripId) {
		return riderFacadeSessionbean.getAllUnReadedNotes(riderTripId);
	}

	@GET
	@Path("/read-note")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public RiderNotesDto readNote(@QueryParam("noteId") int noteId, @QueryParam("tripId") int tripId,
			@QueryParam("riderId") int riderId) {
		return riderFacadeSessionbean.readNote(noteId, tripId, riderId);
	}

}
