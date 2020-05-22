package com.cog.view;

import com.cog.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    // View Options handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginScreen() {
        System.out.println("login screen called");
        BaseController controller = new LoginScreenController(emailManager, this, "/view/LoginScreen.fxml");
        initalizeStage(controller);
    }

    public void showMainScreen() {
        System.out.println("Show main screen called");
        BaseController controller = new MainScreenController(emailManager, this, "/view/MainScreen.fxml");
        initalizeStage(controller);
    }

    public void showOptionsScreen() {
        System.out.println("login screen called");
        BaseController controller = new OptionsScreenController(emailManager, this, "/view/OptionsScreen.fxml");
        initalizeStage(controller);
    }

    private void initalizeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent =fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Email Client");
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToclose) {
        stageToclose.close();
    }
}
