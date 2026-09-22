package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	int[] validChannels;
	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] medidas = eeg.getMeasurements();
		Measurement[] filtrado = new Measurement[medidas.length];
		for(int i= 0; i < medidas.length; i++) {
			float[] canales = new float[validChannels.length];
			int indice = 0;
			for(int k = 0; k < validChannels.length; k++) {
				canales[indice++] =  medidas[i].getChannel(validChannels[k]);
		}
			
			filtrado[i] = new Measurement(canales);
		}
		return new EEGModel(filtrado);
		
	}
}

