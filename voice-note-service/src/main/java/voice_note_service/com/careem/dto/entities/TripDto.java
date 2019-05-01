/**
 *
 */
package voice_note_service.com.careem.dto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.generic.GenericDTO;

/**
 * @author AhmedTalaat
 */
@XmlRootElement
@Entity
@Table(name = JPAConstants.TABLE_NAME_TRIP)
@NamedQueries({ @NamedQuery(name = TripDto.NANED_QUERY_GET_ALL_TRIPS, query = TripDto.QUERY_GET_ALL_TRIPS) })
public class TripDto extends GenericDTO {
	private static final long serialVersionUID = -2200848783062693413L;

	public static final String NANED_QUERY_GET_ALL_TRIPS = "getAllTrips";
	static final String QUERY_GET_ALL_TRIPS = "Select t from TripDto t";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "FromPlace")
	private String fromPlace;

	@Column(name = "ToPlace")
	private String toPlace;

	@Column(name = "FromTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromTime;

	@Column(name = "ToTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date toTime;

	@Column(name = "CapId")
	private Integer capId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public Integer getCapId() {
		return capId;
	}

	public void setCapId(Integer capId) {
		this.capId = capId;
	}

}
