package g0803.bindingofshiba.gui.fonts;

import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Fonts {

    public static SwingTerminalFontConfiguration loadFontConfiguration(String resourceLocation, int size)
            throws IOException, FontFormatException {
        URL resource = Fonts.class.getResource(resourceLocation);
        if (resource == null) throw new IOException("Could not find resource at " + resourceLocation);

        InputStream fileStream = resource.openStream();
        Font font = Font.createFont(Font.TRUETYPE_FONT, fileStream);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font derivedFont = font.deriveFont(Font.PLAIN, size);
        return SwingTerminalFontConfiguration.newInstance(derivedFont);
    }
}
