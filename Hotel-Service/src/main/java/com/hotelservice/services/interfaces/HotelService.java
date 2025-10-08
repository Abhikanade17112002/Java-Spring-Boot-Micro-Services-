package com.hotelservice.services.interfaces;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    //Get All Hotels
    List<Hotel> getAllHotels() ;
    //GET HOTEL BY ID
    Hotel getHotelById( String hotelId) ;
    // ADD NEW HOTEL
    Hotel addNewHotel( Hotel hotel ) ;
    //Update HotelById
    Hotel updateHotelById(String hotelId);
    //DELETE HOTEL BY ID
    String deleteHotelById(String hotelId);
}
