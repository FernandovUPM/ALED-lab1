package es.upm.aled.lab1.measurements;

import java.util.List;
import java.util.ArrayList;


public class FilterThreshold implements Filter{

	private float threshold;
	private int[] channels;
	
	public FilterThreshold(float threshold, int[] channels) {
		this.channels = channels;
		this.threshold = threshold;
	}
	


	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] medidas = eeg.getMeasurements();
		List<Measurement> arrayFiltrado = new ArrayList<Measurement>();
		for(int i = 0; i < medidas.length; i++) {
			int contador = 0;
			for(int k = 0; k < channels.length; k++) {
				if(medidas[i].getChannel(channels[k]) >= threshold)
					contador++;
			}
			if (contador == channels.length)
				arrayFiltrado.add(medidas[i]);
		}
		
		Measurement[] filtrado = new Measurement[arrayFiltrado.size()]; 
		for(int l = 0; l < arrayFiltrado.size(); l++) {
			filtrado[l]=arrayFiltrado.get(l);
		}
		return new EEGModel(filtrado);
	}
}
