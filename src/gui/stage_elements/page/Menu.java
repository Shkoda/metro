package gui.stage_elements.page;

import data.DataHolder;
import gui.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.apache.commons.lang3.SerializationUtils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Nightingale on 05.03.14.
 */
public class Menu {
    private static java.io.File defaultLocation = new java.io.File("").getAbsoluteFile();

    public static MenuItem getOpenMenuItem(final DataHolder dataHolder) {
        MenuItem openMenu = new javafx.scene.control.MenuItem("Open...");
        openMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open File");
                fileChooser.setInitialDirectory(defaultLocation);
                fileChooser.getExtensionFilters().addAll(Config.PROJECT_FILE_EXTENSION_FILTER);
                File file = fileChooser.showOpenDialog(null);
                if (file == null)
                    return;

                try {
                    defaultLocation = file;
                    DataHolder dataHolderReaded =  SerializationUtils.deserialize(Files.readAllBytes(file.toPath()));
                    dataHolder.reset(dataHolderReaded);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        return openMenu;
    }

    public static MenuItem getSaveMenuItem(final DataHolder dataHolder) {
        MenuItem saveMenu = new MenuItem("Save...");
        saveMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File");
                fileChooser.setInitialDirectory(defaultLocation);
                fileChooser.getExtensionFilters().addAll(Config.PROJECT_FILE_EXTENSION_FILTER);
                File file = fileChooser.showSaveDialog(null);
                if (file == null)
                    return;
                try {
                    defaultLocation = file;
                    Path path = Paths.get(file.toPath().toString() + "." + Config.PROJECT_FILE_EXTENSION);
                    Files.write(path, SerializationUtils.serialize(dataHolder));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return saveMenu;
    }

    public static MenuItem getNewMenuItem(final DataHolder dataHolder) {
        MenuItem newMenu = new MenuItem("New...");
        newMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                dataHolder.reset();
            }
        });
        return newMenu;
    }

}
