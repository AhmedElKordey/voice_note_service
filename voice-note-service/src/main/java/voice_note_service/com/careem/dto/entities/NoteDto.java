/**
 *
 */
package voice_note_service.com.careem.dto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.generic.GenericDTO;

/**
 * @author AhmedTalaat
 */

@Entity
@Table(name = JPAConstants.TABLE_NAME_NOTES)
@NamedQueries({
		@NamedQuery(name = NoteDto.NAMED_QUERY_GET_ALL_NOTES_FOR_SPECIFIC_TRIP, query = NoteDto.QUERY_GET_ALL_NOTES_FOR_SPECIFIC_TRIP),
		@NamedQuery(name = NoteDto.NAMED_QUERY_GET_NOTE_BY_ID, query = NoteDto.QUERY_GET_NOTE_BY_ID) })
@XmlRootElement(name = "NoteDto")
public class NoteDto extends GenericDTO {
	private static final long serialVersionUID = -135250093734954247L;

	public static final String NAMED_QUERY_GET_ALL_NOTES_FOR_SPECIFIC_TRIP = "getAllNotesForSpecificTrip";
	static final String QUERY_GET_ALL_NOTES_FOR_SPECIFIC_TRIP = "Select n FROM NoteDto n where n.tripId =:"
			+ JPAConstants.TRIP_ID;

	public static final String NAMED_QUERY_GET_NOTE_BY_ID = "getNoteById";
	static final String QUERY_GET_NOTE_BY_ID = "Select n FROM NoteDto n where n.id =:" + JPAConstants.NOTE_ID;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "NoteTitle")
	private String noteTitle;

	@Column(name = "NotePath")
	private String notePath;

	@Column(name = "Note")
	private byte[] note;

	@Column(name = "TripId")
	private Integer tripId;

	@Transient
	private long sentCount;

	@Transient
	private long recivedCount;

	@Transient
	private long readCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public long getSentCount() {
		return sentCount;
	}

	public void setSentCount(long sentCount) {
		this.sentCount = sentCount;
	}

	public long getRecivedCount() {
		return recivedCount;
	}

	public void setRecivedCount(long recivedCount) {
		this.recivedCount = recivedCount;
	}

	public long getReadCount() {
		return readCount;
	}

	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNotePath() {
		return notePath;
	}

	public void setNotePath(String notePath) {
		this.notePath = notePath;
	}

	public byte[] getNote() {
		return note;
	}

	public void setNote(byte[] note) {
		this.note = note;
	}
}
