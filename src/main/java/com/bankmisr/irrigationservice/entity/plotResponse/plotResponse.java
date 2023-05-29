package com.bankmisr.irrigationservice.entity.plotResponse;

import com.bankmisr.irrigationservice.entity.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class plotResponse extends Response {

    @JsonProperty(value = "plotDescription")
    private String plotDesc;


    public plotResponse(String plotDesc, Integer responseCode, String responseMessage) {
        super(responseCode, responseMessage);
        this.plotDesc = plotDesc;
    }

    public plotResponse(int noDataFound, String patientNotFound) {
        super(noDataFound, "error not found");
        this.plotDesc = plotDesc;
    }
}
