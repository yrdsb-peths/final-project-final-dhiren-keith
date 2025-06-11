import greenfoot.*;

/**
 * Label - Displays customizable text on screen with outline and fill colors.
 * Can update text dynamically, supporting both String and integer values.
 * Allows setting font, font size, and text colors.
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class Label extends Actor
{
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private String font;
    private static final Color transparent = new Color(0,0,0,0);

    public Label(String value, String font, int fontSize)
    {
        this.font = font;
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }

    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }

    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }

    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }

    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}
