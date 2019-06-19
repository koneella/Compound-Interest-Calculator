package calculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    @FXML private Button submitButton;
    @FXML private LineChart<Number,Number> lineChart;
    @FXML private Spinner<Integer> startAmountSpinner;
    @FXML private Spinner<Integer> yearlyRateSpinner;
    @FXML private Spinner<Integer> yearsSpinner;
    @FXML private Label finalAmountLabel;




    public void submitButtonClicked() {

        int startAmount = 1;
        double yearlyRate = 1;
        int years = 1;

        startAmount = startAmountSpinner.getValue();
        yearlyRate = yearlyRateSpinner.getValue();
        years = yearsSpinner.getValue();

        generateChart(startAmount, yearlyRate, years);
    }




    public void generateChart(int startAmount, double yearlyRate, int years) {

            XYChart.Series<Number, Number> series = new XYChart.Series<>();

            double finalAmount = 0;
            double rate = (yearlyRate / 100) + 1;

            for (int i = 1; i <= years; i++) {

                if (i == 1) {
                    finalAmount = startAmount * rate;
                    series.getData().add(new XYChart.Data<>(i, finalAmount));
                } else {
                    finalAmount = finalAmount * rate;
                    series.getData().add(new XYChart.Data<>(i, finalAmount));
                }
            }

            lineChart.getData().add(series);

            DecimalFormat decimalFormat = new DecimalFormat("0.00");

            finalAmountLabel.setText("The final amount after " + years + " years is " + decimalFormat.format(finalAmount) + "€");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
