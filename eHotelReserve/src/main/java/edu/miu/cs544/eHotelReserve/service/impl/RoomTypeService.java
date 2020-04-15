package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.repository.IRoomTypeRepository;
import edu.miu.cs544.eHotelReserve.rest.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;

@Component("roomTypeService")
public class RoomTypeService implements IRoomTypeService{
	
//	private IRoomTypeRepository roomTypeRepository;
	
	String baseUrl = "http://localhost:8000/MemberRest/hotel/admin/roomTypes";
	String baseUrlExtended = baseUrl + "/";
	@Autowired
	RestHttpHeader restHelper;
	
//	
//	@Autowired
//	public RoomTypeService(IRoomTypeRepository roomTypeRepository) {
//		this.roomTypeRepository = roomTypeRepository;
//	}

	@Override
	public List<RoomType> findAll() {
		
		RestTemplate restTemplate= restHelper.getRestTemplate();
		HttpEntity httpEntity= new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<RoomType[]> responseEntity=restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, RoomType[].class);
 		List<RoomType> items = Arrays.asList(responseEntity.getBody());
 		return items;
	}

	@Override
	public RoomType save(RoomType category) {
//		return roomTypeRepository.save(category);
		return null;
	}

	@Override
	public RoomType findById(Long cId) {
		return null;//roomTypeRepository.findById(cId).orElse(null);
	}

	@Override
	public void delete(Long cId) {
		//roomTypeRepository.deleteById(cId);
	}

}
