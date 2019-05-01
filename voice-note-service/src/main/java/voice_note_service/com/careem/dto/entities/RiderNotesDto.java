package voice_note_service.com.careem.dto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.generic.GenericDTO;

/**
 * @author AhmedTalaat
 */
@XmlRootElement
@Entity
@Table(name = JPAConstants.TABLE_NAME_RIDER_NOTES)
@NamedQueries({
		@NamedQuery(name = RiderNotesDto.NAMED_QUERY_GET_COUNT_OF_EACH_NOTE_STATUS, query = RiderNotesDto.QUERY_GET_COUNT_OF_EACH_NOTE_STATUS) })
public class RiderNotesDto extends GenericDTO {
	private static final long serialVersionUID = 6275863402231394279L;

	public static final String NAMED_QUERY_GET_COUNT_OF_EACH_NOTE_STATUS = "getCountOfEachNoteGrouppedByStatusCode";
	static final String QUERY_GET_COUNT_OF_EACH_NOTE_STATUS = "select count(r) from RiderNotesDto r where r.tripId =:"
			+ JPAConstants.TRIP_ID + " and r.noteStatus =:" + JPAConstants.NOTE_STAATUS + " and r.noteId =:"
			+ JPAConstants.NOTE_ID;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "Rider_Trip_Id")
	private Integer riderTripID;

	@Column(name = "NoteId")
	private Integer noteId;

	@Column(name = "NoteStatus")
	private Integer noteStatus;

	@Column(name = "TripId")
	private Integer tripId;

	public Integer getId() {
		return id;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRiderTripID() {
		return riderTripID;
	}

	public void setRiderTripID(Integer riderTripID) {
		this.riderTripID = riderTripID;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public Integer getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(Integer noteStatus) {
		this.noteStatus = noteStatus;
	}

}
