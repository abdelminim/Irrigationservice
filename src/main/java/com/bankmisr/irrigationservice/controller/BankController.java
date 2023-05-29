package com.bankmisr.irrigationservice.controller;


import com.bankmisr.irrigationservice.entity.PlotRequest;
import com.bankmisr.irrigationservice.entity.Response;
import com.bankmisr.irrigationservice.entity.request.InquirePlotDataRequest;
import com.bankmisr.irrigationservice.model.plot;
import com.bankmisr.irrigationservice.service.BankMisrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/irrigation/")
public class BankController {

    @Autowired
    private BankMisrService bankMisrService;

    @GetMapping("greeting")
    public String sayHello() {
        return "hello from greeting irrigation";
    }
    @PostMapping("savePlot")
    public Response createNewPlot(@RequestBody PlotRequest plotRequest) {
        return bankMisrService.createNewPlot(plotRequest);
    }
    @PutMapping(path ="editPlot/{plotId}")
    public Response editPlot(@PathVariable Integer plotId,@RequestBody PlotRequest plotRequest) {
        return bankMisrService.editPlot(plotId,plotRequest);
    }
    @GetMapping("getAllPlots")
    public List<plot> getAllPlots() {
        return bankMisrService.getAllPlots();
    }

    /* Configure a plot of land may need restTemplete or feignClient send request include plotDataSpecification to
       sensor devices that would collect data on the current conditions in the plot of land and transmit it to
       central control system for Irrigation process */


    @PostMapping("ConfigurePlotIrrigationCycle")
    public Response configurePlotIrrigationCycle(@RequestBody InquirePlotDataRequest inquirePlotDataRequest) {
        return bankMisrService.configurePlotIrrigation(inquirePlotDataRequest);
    }





}
