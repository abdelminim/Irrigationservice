package com.bankmisr.irrigationservice.service;

import com.bankmisr.irrigationservice.entity.request.InquirePlotDataRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "UMOSSService/UMOSSService")
public interface SensorClient {
    @PostMapping("/api/InquireDisabilityData")
    public MockServiceSumulateSensor InquirePlotDataService (@RequestBody InquirePlotDataRequest request);

}
