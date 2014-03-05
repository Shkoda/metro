package gui.config;

import com.sun.glass.ui.CommonDialogs;
import javafx.stage.FileChooser;

/**
 * Created by Nightingale on 16.02.14.
 */
public class Config {
    public static final int SCENE_WIDTH = 800;
    public static final int SCENE_HEIGHT = 500;
    public static final double ANCHOR_OFFSET_WORK_AREA = 10;
    public static final double DISTANCE_BETWEEN_LINKS = 0;
    public static final int SYSTEM_MENU_BUTTON_SIZE = 30;

    public static final int PREVIOUS_NEXT_BUTTON_SIZE = 20;

    public static final int STATUS_HEADER_HEIGHT = 30;
    public static final int TOOL_HEIGHT = 50;

    public static final double LINK_WIDTH = ((SCENE_WIDTH - ANCHOR_OFFSET_WORK_AREA * 2) - DISTANCE_BETWEEN_LINKS * 2) / 3;

    public static final int CANVAS_WIDTH = 600;
    public static final int CANVAS_HEIGHT = 400;


    public static final int PROCESSOR_ELEMENT_WIDTH = 40;
    public static final int PROCESSOR_ELEMENT_HEIGHT = 40;

    public static final String PROJECT_FILE_EXTENSION = "pzcs";
    public static final String EXTENSION_DESCRIPTION = "project file (*." + PROJECT_FILE_EXTENSION + ")";
    public static final FileChooser.ExtensionFilter PROJECT_FILE_EXTENSION_FILTER = new FileChooser.ExtensionFilter(EXTENSION_DESCRIPTION, "*." + PROJECT_FILE_EXTENSION);

}
