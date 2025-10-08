package com.hotelservice.services.implementations;

import com.hotelservice.entities.Hotel;
import com.hotelservice.repositories.HotelRepository;
import com.hotelservice.services.interfaces.HotelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService {

    @Autowired
    private HotelRepository hotelRepository ;
    @Override
    public Hotel addNewHotel(Hotel hotel) {
        System.out.println("Received Hotel ==> " + hotel );
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> retrivedHotels = hotelRepository.findAll() ;
        return retrivedHotels;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        System.out.println("Received Hotel Id ==> " + hotelId );
        Hotel retrivedHotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new EntityNotFoundException("Hotel With Hotel Id ==> " + hotelId + " Not found ")
        );
        return retrivedHotel ;
    }

    @Override
    public Hotel updateHotelById(String hotelId) {
        return null;
    }

    @Override
    public String deleteHotelById(String hotelId) {
        System.out.println("Received Hotel Id ==> " + hotelId );
        hotelRepository.deleteById(hotelId);
        return "Hotel With Hotel Id ==> " + hotelId + " Deleted Successfully ";
    }
}
