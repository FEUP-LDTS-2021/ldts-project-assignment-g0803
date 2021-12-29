package g0803.bindingofshiba.gui;

import java.io.IOException;

public interface GUI {
    void close() throws IOException;
    void clear();
    void refresh() throws IOException;
}
