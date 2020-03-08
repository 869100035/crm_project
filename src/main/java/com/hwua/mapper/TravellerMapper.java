package com.hwua.mapper;

import com.hwua.pojo.Traveller;
import org.springframework.stereotype.Component;

@Component
public interface TravellerMapper {
    Traveller findTravellerByOrderId(String id)throws Exception;
}
