package com.itakademija.paint.gui.menu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.Function;

public enum SaveMenuItemFactory implements Function<ActionListener, JMenuItem> {
    SAX {
        @Override
        public JMenuItem apply(ActionListener actionListener) {
            JMenuItem saveMenuItem = new JMenuItem("SAX");
            saveMenuItem.setMnemonic('S');
            saveMenuItem.addActionListener(actionListener);
            return saveMenuItem;
        }
    },
    STAX {
        @Override
        public JMenuItem apply(ActionListener actionListener) {
            JMenuItem saveMenuItem = new JMenuItem("STAX");
            saveMenuItem.setMnemonic('T');
            saveMenuItem.addActionListener(actionListener);
            return saveMenuItem;
        }
    },
    DOM {
        @Override
        public JMenuItem apply(ActionListener actionListener) {
            JMenuItem saveMenuItem = new JMenuItem("DOM");
            saveMenuItem.setMnemonic('D');
            saveMenuItem.addActionListener(actionListener);
            return saveMenuItem;
        }
    };
}
