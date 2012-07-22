/**
 * 
 */

package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

/**
 * @author v-honzha
 */
public class Photon implements IDirected, Writable {

	private Color color;

	private Vector sourcePosition;

	private Vector direction;

	@Override
	public Vector getPosition() {
		return this.sourcePosition;
	}

	@Override
	public Vector getDirection() {
		return this.direction;
	}

	public void clear() {
		this.color.clear();
		this.sourcePosition.clear();
		this.direction.clear();
	}

	public Color getColor() {
		return this.color;
	}

	public Vector getSourcePosition() {
		return this.sourcePosition;
	}

	public void fromFormatString(String input) {
		this.clear();
		int findex = input.indexOf('|');
		this.color.fromFormatString(input.substring(1, findex));
		int sindex = input.indexOf('|', findex + 1);
		this.sourcePosition.fromFormatString(input.substring(findex + 1, sindex));
		this.direction.fromFormatString(input.substring(sindex + 1, input.length() - 1));
	}

	public String asFormatString() {
		StringBuilder stringToBuild = new StringBuilder();
		stringToBuild.append('[');
		stringToBuild.append(this.color.asFormatString()).append('|')
		.append(this.sourcePosition.asFormatString()).append('|')
		.append(this.direction.asFormatString());
		stringToBuild.append(']');
		return stringToBuild.toString();
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		int length = WritableUtils.readVInt(input);
		byte[] bytes = new byte[length];
		input.readFully(bytes, 0, length);
		this.fromFormatString(new String(bytes));
	}

	@Override
	public void write(DataOutput output) throws IOException {
		String content = this.asFormatString();
		WritableUtils.writeVInt(output, content.length());
		output.writeBytes(content);
	}

	@Override
	public String toString() {
		return this.asFormatString();
	}

}
