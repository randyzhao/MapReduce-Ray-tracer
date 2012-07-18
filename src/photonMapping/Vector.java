
package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

public class Vector implements Writable {
    private double x;

    private double y;

    private double z;

    public Vector() {
        this.x = this.y = this.z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private static Vector NULL, INFINIT;

    public static Vector getNullVector() {
        return NULL;
    }

    public void clear() {
        x = y = z = 0;
    }

    public void fromFormatString(String input) {
        clear();
        int findex = input.indexOf(',');
        x = Double.parseDouble(input.substring(1, findex));
        int sindex = input.indexOf(',', findex + 1);
        y = Double.parseDouble(input.substring(findex + 1, sindex));
        z = Double.parseDouble(input.substring(sindex + 1, input.length() - 1));
    }

    public String asFormatString() {
        StringBuilder stringToBuild = new StringBuilder();
        stringToBuild.append('(');
        stringToBuild.append(x).append(',').append(y).append(',').append(z);
        stringToBuild.append(')');
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
