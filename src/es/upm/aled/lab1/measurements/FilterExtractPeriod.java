package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {

	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	private int min;
	private int max;
	
	public FilterExtractPeriod(int min, int max) {
		this.min= min;
		this.max=max;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] medidas = eeg.getMeasurements();
		if(medidas.length > min && medidas.length > max) {	
		Measurement[] filtrado = new Measurement[max-min+1];
		int k = 0;
		for (int i = min; i<=max; i++) {
			filtrado[k++] = medidas[i];
		}
		return new EEGModel(filtrado);
		}
		return new EEGModel();
	}
	}
	
