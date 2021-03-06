package edu.miu.cs544.eHotelReserve.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roomTypes")
public class RoomType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roomtype_id")
	private Long roomTypeId;
	
	@NotEmpty
	private String roomTypeName;
	
	@NotNull
	private Double price;
	
	@OneToMany(mappedBy = "roomType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Room> rooms;
	
	public RoomType() {} 

	public RoomType(String roomType_id, String roomName,
			 Double price, List<Room> rooms) {
		
		
		this.roomTypeName = roomName;
		this.price = price;
		this.rooms = rooms;
	}
	
	



	public RoomType(@NotEmpty(message = "{NotEmpty.validation}") String roomTypeName,
			@NotNull(message = "{NotNull.validation}") Double price) {
		super();
		this.roomTypeName = roomTypeName;
		this.price = price;
	}



	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	
	
}
