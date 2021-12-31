package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public interface GUI {
    void close() throws IOException;
    void clear();
    void refresh() throws IOException;
    void drawText(int x, int y, String text, TextColor foregroundColor, TextColor backgroundColor);
}
