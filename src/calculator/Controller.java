package calculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    @FXML private Button submitButton;
    @FXML private LineChart<Number,Number> lineChart;
    @FXML private Spinner<Integer> startAmountSpinner;
    @FXML private Spinner<Integer> yearlyRateSpinner;
    @FXML private Spinner<Integer> yearsSpinner;





    public void submitButtonClicked() {

        int startAmount;
        double yearlyRate;
        int years;

        startAmount = startAmountSpinner.getValue();
        yearlyRate = yearlyRateSpinner.getValue();
        years = yearsSpinner.getValue();


        generateChart(startAmount, yearlyRate, years);
    }




    public void generateChart(int startAmount, double yearlyRate, int years) {


        //https://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php

        double finalAmount = 0;
        double rate = (yearlyRate / 100) + 1;

        for(int i = 0; i < years; i++) {

            if (i == 0) {
                finalAmount = startAmount * rate;
            } else {
                finalAmount = finalAmount * rate;
            }
        }

        System.out.println(finalAmount);

       // return finalAmount;
/*


        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        series.getData().add(new XYChart.Data<>(1,1));

        lineChart.getData().add(series);
        */

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
