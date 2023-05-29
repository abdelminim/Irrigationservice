package com.bankmisr.irrigationservice.entity.request;

import com.bankmisr.irrigationservice.entity.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquirePlotDataRequest extends Response {


    @JsonProperty("plotNumber")
    private Integer plotNumber;
    @JsonProperty("plotSize")
    private Double plotSize;

    @JsonProperty("plotHeatDegree")
    private Integer plotHeatDegree;
    @JsonProperty("plotCoveredFlag")
    private Boolean plotCoveredFlag;

    //other specification for plot


}
