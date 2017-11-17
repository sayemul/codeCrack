package com.simple.autosuggest;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XYLineChartExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XYLineChartExample() {
		super("XY Line Chart Example with JFreechart");

		JPanel chartPanel = createChartPanel();

		add(chartPanel, BorderLayout.CENTER);

		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private JPanel createChartPanel() {
		String chartTitle = "Execution Chart";
		String xAxisLabel = "Number";
		String yAxisLabel = "Time";

		XYDataset dataset = createDataset();

		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset,
				PlotOrientation.VERTICAL, false, false, false);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.DARK_GRAY);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		plot.setRenderer(renderer);
		// saveImage(chart);
		return new ChartPanel(chart);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Object 1");

		series1.add(1.0, 2.0);
		series1.add(2.0, 3.0);
		series1.add(3.0, 2.5);
		series1.add(3.5, 2.8);
		series1.add(4.2, 6.0);

		dataset.addSeries(series1);

		return dataset;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new XYLineChartExample().setVisible(true);
			}
		});
	}

	public void saveImage(JFreeChart chart) {
		File imageFile = new File("D:\\XYLineChart.png");//path of the file where you want to save the image
		int width = 640;
		int height = 480;

		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
