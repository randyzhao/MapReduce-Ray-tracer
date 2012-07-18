/**
 * 
 */
package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * @author v-honzha
 *
 */
public class PhotonInformation implements Writable{

	private Color color;
	private Vector sourcePosition;
	private Vector direction;
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
