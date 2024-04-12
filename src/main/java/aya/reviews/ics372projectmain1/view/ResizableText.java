package aya.reviews.ics372projectmain1.view;

import javafx.scene.text.Text;

public class ResizableText extends Text {

    public ResizableText() {
        super();
    }

    public ResizableText(String text) {
        super(text);
        resizeToFit();
    }

    private void resizeTextToFit(Text text, double maxWidth, double maxHeight, double initialFontSize) {
        // Calculate the scaling factor for width and height
        double scaleX = maxWidth / text.getBoundsInLocal().getWidth();
        double scaleY = maxHeight / text.getBoundsInLocal().getHeight();

        // Use the smaller scaling factor to ensure that the text fits both horizontally and vertically
        double scale = Math.min(scaleX, scaleY);

        // Update the font size
        double newSize = initialFontSize * scale;
        text.setFont(Font.font(newSize));
    }
}