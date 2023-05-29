package com.bankmisr.irrigationservice.service;

import com.bankmisr.irrigationservice.entity.Response;
import com.bankmisr.irrigationservice.entity.ResponseCodes;
import com.bankmisr.irrigationservice.entity.plotResponse.plotConfiguredMockResponse;
import com.bankmisr.irrigationservice.entity.request.InquirePlotDataRequest;
import org.springframework.stereotype.Service;

@Service
public class MockServiceSumulateSensor {

    public static Response InquirePlotDataService(InquirePlotDataRequest inquirePlotDataRequest) {
        Double plotSize = inquirePlotDataRequest.getPlotSize();
        Integer plotHeat = inquirePlotDataRequest.getPlotHeatDegree();
        Boolean coveredFlag = inquirePlotDataRequest.getPlotCoveredFlag();

        if(coveredFlag && plotSize>100 && plotHeat>35)
            return new plotConfiguredMockResponse(250,ResponseCodes.success,"area need amount 250 for Irrigation process");


        if(!coveredFlag || plotSize < 100 )
            return new plotConfiguredMockResponse(250,ResponseCodes.success,"area need amount 300 for Irrigation process");

                return new plotConfiguredMockResponse(Integer.parseInt(ResponseCodes.DATA_MIS_MATCHED.toString()));

    }

}
