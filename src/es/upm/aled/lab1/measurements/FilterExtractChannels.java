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
		// TODO
		this.validChannels = validChannels;
		}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] originalMeasurements = eeg.getMeasurements();
		Measurement[] newMeasurements = new Measurement[originalMeasurements.length];
		
		for (int i = 0; i < originalMeasurements.length; i++) {
			Measurement originalM = originalMeasurements[i];
			float[] extractedValues = new float[validChannels.length];
			for (int j= 0; j < validChannels.length; j++){
				int canalDeseado = validChannels[j];
				extractedValues[j] = originalM.getChannel(canalDeseado);
			}
			newMeasurements[i] = new Measurement(extractedValues);
		}
		return new EEGModel(newMeasurements);
    }

}
