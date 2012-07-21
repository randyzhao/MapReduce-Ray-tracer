
package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

public class PhotonHitInfo implements Writable {
    private Color color;

    private Vector position;

    private Vector incidentDirection;

    public Vector getPosition() {
        // TODO;
        return null;
    }

    public void clear() {
        color.clear();
        position.clear();
        incidentDirection.clear();
    }

    public void fromFormatString(String input) {
        clear();
        int findex = input.indexOf('|');
        color.fromFormatString(input.substring(1, findex));
        int sindex = input.indexOf('|', findex + 1);
        position.fromFormatString(input.substring(findex + 1, sindex));
        incidentDirection.fromFormatString(input.substring(sindex + 1, input.length() - 1));
    }

    public String asFormatString() {
        StringBuilder stringToBuild = new StringBuilder();
        stringToBuild.append('[');
        stringToBuild.append(color.asFormatString()).append('|').append(position.asFormatString())
                .append('|').append(incidentDirection.asFormatString());
        stringToBuild.append(']');
        return stringToBuild.toString();
    }

    @Override
    public void readFields(DataInput input) throws IOException {
        int length = WritableUtils.readVInt(input);
        byte[] bytes = new byte[length];
        input.readFully(bytes, 0, length);
        fromFormatString(new String(bytes));
    }

    @Override
    public void write(DataOutput output) throws IOException {
        String content = asFormatString();
        WritableUtils.writeVInt(output, content.length());
        output.writeBytes(content);
    }

    @Override
    public String toString() {
        return asFormatString();
    }

}