package phones;

import java.awt.Color;

public class ColorTag extends Tag {
    private Color color;

    public ColorTag(Color color) {
        this.color = color;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getColor().equals(color);
    }
}
