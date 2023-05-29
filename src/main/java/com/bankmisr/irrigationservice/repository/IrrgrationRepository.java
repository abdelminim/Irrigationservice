package com.bankmisr.irrigationservice.repository;

import com.bankmisr.irrigationservice.entity.PlotRequest;
import com.bankmisr.irrigationservice.model.plot;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IrrgrationRepository {
    private final Log logger = LogFactory.getLog(IrrgrationRepository.class);
    @Autowired
    private EntityManager entityManager;

    public plot getPlotById(Integer plotNum) {
        logger.info("savePatient object : "+plotNum);
        List<plot> plotList = entityManager.createQuery("FROM plot p WHERE p.plotNumber = :plotNum",
                plot.class).setParameter("plotNum", plotNum).getResultList();
        if (!plotList.isEmpty()) {
            return plotList.get(0);
        }
        return null;
    }

    public plot savePlot(plot plot) {
        logger.info("savePlot object : "+plot.getPlotDescription());
        if (!ObjectUtils.isEmpty(plot) && !entityManager.contains(plot)) {
            entityManager.persist(plot);
                plot pat = entityManager.find(plot.class, plot.getId());
            logger.info(String.format("save %s from savePatient ",pat.getPlotNumber()));
            return pat;
        }
        return null;
    }

    public List<plot> getAllPlots() {
        List<plot> plotList = entityManager.createQuery("FROM plot p ")
                .getResultList();

        return plotList;
    }
}
