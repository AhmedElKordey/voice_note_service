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
import javax.xml.bind.annotation.XmlRootElement;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.generic.GenericDTO;

/**
 * @author AhmedTalaat
 *
 * @Description this class represent all trips joined per each rider
 */

@Entity
@Table(name = JPAConstants.TABLE_NAME_RIDER_TRIPS)
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = RiderTripsDto.NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_TRIP, query = RiderTripsDto.QUERY_GET_ALL_RIDER_TRIPS_PER_TRIP),
		@NamedQuery(name = RiderTripsDto.NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_RIDER, query = RiderTripsDto.QUERY_GET_ALL_RIDER_TRIPS_PER_RIDER),
		@NamedQuery(name = RiderTripsDto.NAMED_QUERY_GET_RIDER_TRIP_BY_TRIP_RIDER_IDS, query = RiderTripsDto.QUERY_GET_RIDER_TRIP_BY_TRIP_RIDER_IDS) })
public class RiderTripsDto extends GenericDTO {
	private static final long serialVersionUID = -1524126714686579361L;

	public static final String NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_TRIP = "getAllRiderTripsPerTrip";
	static final String QUERY_GET_ALL_RIDER_TRIPS_PER_TRIP = "Select rt FROM RiderTripsDto rt where rt.tripId =:"
			+ JPAConstants.TRIP_ID;

	public static final String NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_RIDER = "getAllRiderTripsPerRider";
	static final String QUERY_GET_ALL_RIDER_TRIPS_PER_RIDER = "Select rt FROM RiderTripsDto rt where rt.riderId =:"
			+ JPAConstants.RIDER_ID;

	public static final String NAMED_QUERY_GET_RIDER_TRIP_BY_TRIP_RIDER_IDS = "getRiderTripsByRiderTripIds";
	static final String QUERY_GET_RIDER_TRIP_BY_TRIP_RIDER_IDS = "Select  rt FROM RiderTripsDto rt where rt.riderId =:"
			+ JPAConstants.RIDER_ID + " and rt.tripId =:" + JPAConstants.TRIP_ID;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "RiderId")
	private Integer riderId;

	@Column(name = "TripId")
	private Integer tripId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRiderId() {
		return riderId;
	}

	public void setRiderId(Integer riderId) {
		this.riderId = riderId;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
}
