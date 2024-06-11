import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        //1. DatePicker: Control de selección de fecha
        DatePicker datePicker = new DatePicker();
        
        //2. ColorPicker: Control de selección de color
        ColorPicker colorPicker = new ColorPicker();

        //4. Label: Etiquetas para guiar al usuario
        Label dateLabel = new Label("Selecciona una fecha:");
        Label colorLabel = new Label("Selecciona un color:");
        
        //3. Button: Botón para confirmar la selección
        Button confirmButton = new Button("Confirmar");

        //Componente de texto para mostrar la selección
        Text selectionText = new Text();

        // 5. VBox Layout: Layout vertical para organizar los controles
        VBox vbox = new VBox(10); 
        vbox.getChildren().addAll(dateLabel, datePicker, colorLabel, colorPicker, confirmButton, selectionText);

        // 6. Acción al presionar el botón: Mostrar la selección en la consola y en la interfaz
        confirmButton.setOnAction(e -> {
            if (datePicker.getValue() != null && colorPicker.getValue() != null) {
                String selectedDate = "Fecha seleccionada: " + datePicker.getValue();
                Color color = colorPicker.getValue();
                String colorName = getColorName(color);

                String selectedColor = "Color seleccionado: " + colorName;

                System.out.println(selectedDate);
                System.out.println(selectedColor);

                //Mostrar la selección en el componente de texto
                selectionText.setText(selectedDate + "\n" + selectedColor);

                //Opcional: Cambiar el color de fondo de la escena
                primaryStage.getScene().setFill(colorPicker.getValue());
            } else {
                System.out.println("Por favor, selecciona una fecha y un color.");
                selectionText.setText("Por favor, selecciona una fecha y un color.");
            }
        });

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("DatePicker y ColorPicker en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private String getColorName(Color color) {
        int red = (int) (color.getRed() * 255);
        int green = (int) (color.getGreen() * 255);
        int blue = (int) (color.getBlue() * 255);   
        return String.format("RGB(%d, %d, %d)", red, green, blue);
    }
}
