package com.bankmisr.irrigationservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlotRequest {
    @JsonProperty("plotlocation")
    private String location;
    @JsonProperty("plotDesc")
    private String desc;
    @JsonProperty("plotNum")
    private Integer plotNum;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPlotNum() {
        return plotNum;
    }

    public void setPlotNum(Integer plotNum) {
        this.plotNum = plotNum;
    }

    @Override
    public String toString() {
        return "PlotRequest{" +
                "location='" + location + '\'' +
                ", desc='" + desc + '\'' +
                ", plotNum=" + plotNum +
                '}';
    }

}
