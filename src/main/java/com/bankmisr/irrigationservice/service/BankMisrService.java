package com.bankmisr.irrigationservice.service;

import com.bankmisr.irrigationservice.entity.PlotRequest;
import com.bankmisr.irrigationservice.entity.Response;
import com.bankmisr.irrigationservice.entity.ResponseCodes;
import com.bankmisr.irrigationservice.entity.plotResponse.plotResponse;
import com.bankmisr.irrigationservice.entity.request.InquirePlotDataRequest;
import com.bankmisr.irrigationservice.model.plot;
import com.bankmisr.irrigationservice.repository.IrrgrationRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankMisrService {
        private final Log logger = LogFactory.getLog(BankMisrService.class);
        @Autowired
        private IrrgrationRepository irrgrationRepository;

        public plotResponse createNewPlot(PlotRequest plotRequest) {
            logger.info("inside createNewPlot  : "+plotRequest.getPlotNum());
            plot isPlotExit =irrgrationRepository.getPlotById(plotRequest.getPlotNum());
            if(isPlotExit!=null)
                return new plotResponse(ResponseCodes.dataDuplicated, "plot num can't be duplicated");
            plot plot = new plot();
            plot.setPlotNumber(plotRequest.getPlotNum());
            plot.setPlotLocation(plotRequest.getLocation());
            plot.setPlotDescription(plotRequest.getDesc());

            plot = irrgrationRepository.savePlot(plot);
            logger.info("exit createNewPlot saved plot desc : "+plot.getPlotDescription());
            return new plotResponse("new plot added successfully : "+plot.getPlotDescription(),200,"success");
        }

        public Response editPlot(Integer plotNum, PlotRequest plotRequest) {
            logger.info("begin editPlot  : "+plotRequest.getPlotNum());
            plot isPlotExit =irrgrationRepository.getPlotById(plotNum);
            if(isPlotExit==null)
                return new plotResponse(ResponseCodes.noDataFound, "plot not found");

            isPlotExit.setPlotDescription(plotRequest.getDesc());
            isPlotExit.setPlotLocation(plotRequest.getLocation());
            isPlotExit.setPlotNumber(plotRequest.getPlotNum());

            irrgrationRepository.savePlot(isPlotExit);
            logger.info("end editPlot  : "+plotRequest.getPlotNum());
            return new Response(200, "edit successfully");
        }


        public List<plot> getAllPlots() {
            return irrgrationRepository.getAllPlots();
        }

        public Response configurePlotIrrigation(InquirePlotDataRequest inquirePlotDataRequest) {
            logger.info("begin configurePlotIrrigation : "+inquirePlotDataRequest.getPlotNumber());
            plot isPlotExit =irrgrationRepository.getPlotById(inquirePlotDataRequest.getPlotNumber());
            if(isPlotExit!=null)
                return new plotResponse(ResponseCodes.noDataFound, "plot data doesn't exit ");

            Response mockedResponse = MockServiceSumulateSensor.InquirePlotDataService(inquirePlotDataRequest);
            logger.info("exit configurePlotIrrigation : "+inquirePlotDataRequest.getPlotNumber());
        return mockedResponse;
        }

        // next to include unit tests in our Java REST web service, that you can ensure that your code is
        // reliable, maintainable, and scalable

    }
