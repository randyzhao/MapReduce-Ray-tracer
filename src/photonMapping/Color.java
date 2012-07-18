
package photonMapping;

public class Color {

    // TODO
    public void clear() {

    }

    // TODO
    public void fromFormatString(String input) {
        clear();
    }

    // TODO
    public String asFormatString() {
        StringBuilder stringToBuild = new StringBuilder();
        stringToBuild.append('(');
        // stringToBuild.append(x).append(',').append(y).append(',').append(z);
        stringToBuild.append(')');
        return stringToBuild.toString();
    }

}
