package com.fedex.location.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtil implements Report {

	@Override
	public void PieChart(String path, List<Object[]> data) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		
	for (Object[] objects : data) {
		//dataset.setValue(objects[0].toString(), new Double((double) objects[1]).toString());
		dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		
	}
		
		JFreeChart createPieChart3D = ChartFactory.createPieChart3D("Location Type Report",dataset );
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path +"/pieChart.jpeg"), createPieChart3D, 300, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	


	
}
