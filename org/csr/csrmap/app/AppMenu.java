package org.csr.csrmap.app;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppMenu extends JMenuBar {
    MainFrame frame;
    FileMenu m_file = new FileMenu();
    
    public AppMenu(MainFrame _frame) {
        super();
        frame = _frame;
        this.add(m_file);
    }
    
    class FileMenu extends JMenu {
        JMenuItem i_import = new JMenuItem("Import");
        JMenuItem i_export = new JMenuItem("Export");
        JMenuItem i_settings = new JMenuItem("Settings");
        JMenuItem i_exit = new JMenuItem("Exit");
        
        FileMenu() {
            super("File");
            this.add(i_import);
            this.add(i_export);
            this.add(i_settings);
            this.add(i_exit);
        }
    }
}
