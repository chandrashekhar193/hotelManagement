package com.chandrashekhar.hotelManagement.DTO;


import com.chandrashekhar.hotelManagement.entity.Hotel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HotelDto {

    private Long id;


    private String name;


    private String location;

    private String about;


    public  Hotel hotelDtoToEntity(HotelDto  hotelDto){
        Hotel hotelEntity=new Hotel();
//        hotelEntity.setId(hotelDto.getId());
        hotelEntity.setName(hotelDto.getName());
        hotelEntity.setLocation(hotelDto.getLocation());
        hotelEntity.setAbout(hotelDto.getAbout());

        return hotelEntity;
    }
    public  HotelDto hotelEntityToDto(Hotel  hotel){
        HotelDto hotelDto=new HotelDto();
       hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setLocation(hotel.getLocation());
        hotelDto.setAbout(hotelDto.getAbout());
        return  hotelDto;
    }

}
