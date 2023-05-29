package com.bankmisr.irrigationservice.entity.plotResponse;

import com.bankmisr.irrigationservice.entity.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class plotConfiguredMockResponse extends Response {

    @JsonProperty(value = "amount")
    private Integer plotIrrigationAmount;


    public plotConfiguredMockResponse(Integer plotIrrigationAmount, Integer responseCode, String responseMessage) {
        super(responseCode, responseMessage);
        this.plotIrrigationAmount = plotIrrigationAmount;
    }

    public plotConfiguredMockResponse(int noDataFound) {
        super(noDataFound, "error Irrigation not defined");
    }
}
