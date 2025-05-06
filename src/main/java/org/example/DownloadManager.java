package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.models.FileInfo;

import java.io.File;

public class DownloadManager {

    @FXML
    private TableView<FileInfo> tableView;

    @FXML
    private TextField urlTextField;

    private int index = 0;

    @FXML
    void downloadButtonClicked(javafx.event.ActionEvent event) {
        String url = urlTextField.getText().trim();
        if (url.isEmpty()) {
            System.out.println("URL is empty!");
            return;
        }

        String filename = url.substring(url.lastIndexOf("/") + 1);
        String status = "STARTING";
        String action = "OPEN";
        String path = AppConfig.DOWNLOAD_PATH + File.separator + filename;
        FileInfo file = new FileInfo(String.valueOf(index + 1), filename, url, status, action, path);

        DownloadThread thread = new DownloadThread(file, this);
        tableView.getItems().add(file);
        thread.start();

        index++;
        urlTextField.setText("");
    }

    public void updateUI(FileInfo metaFile) {
        System.out.println(metaFile);
        int fileIndex = Integer.parseInt(metaFile.getIndex()) - 1;
        if (fileIndex >= 0 && fileIndex < tableView.getItems().size()) {
            FileInfo fileInfo = tableView.getItems().get(fileIndex);
            fileInfo.setStatus(metaFile.getStatus());
            tableView.refresh();
        }
        System.out.println("------------------------");
    }

    @FXML
    public void initialize() {
        System.out.println("View initialized");

        TableColumn<FileInfo, String> sn = (TableColumn<FileInfo, String>) tableView.getColumns().get(0);
        sn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());

        TableColumn<FileInfo, String> filename = (TableColumn<FileInfo, String>) tableView.getColumns().get(1);
        filename.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<FileInfo, String> url = (TableColumn<FileInfo, String>) tableView.getColumns().get(2);
        url.setCellValueFactory(cellData -> cellData.getValue().urlProperty());

        TableColumn<FileInfo, String> status = (TableColumn<FileInfo, String>) tableView.getColumns().get(3);
        status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        TableColumn<FileInfo, String> action = (TableColumn<FileInfo, String>) tableView.getColumns().get(4);
        action.setCellValueFactory(cellData -> cellData.getValue().actionProperty());

        TableColumn<FileInfo, String> path = (TableColumn<FileInfo, String>) tableView.getColumns().get(5);
        path.setCellValueFactory(cellData -> cellData.getValue().pathProperty());
    }
}
