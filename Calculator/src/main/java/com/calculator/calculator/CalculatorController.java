package com.calculator.calculator;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class CalculatorController
{
    private String num1 = "", num2 = "", op = "";
    private Boolean pickedOperation = false;
    private Boolean decimal = false;
    private Boolean isResult = false;
    DecimalFormat myDF = new DecimalFormat("#.#");
    @FXML
    private TextField view;
    @FXML
    private void printNumber(ActionEvent event)
    {
        if(isResult && !pickedOperation)
        {
            num1 = "";
            isResult = false;
        }
        String number = ((Button) event.getSource()).getText();
        if(!pickedOperation)
        {
            num1 += number;
            view.setText(num1);
            System.out.println(number);
            System.out.println(num1);
        }
        else
        {
            num2 += number;
            view.setText(num2);
            System.out.println(number);
            System.out.println(num2);
        }
    }
    @FXML
    private void Decimal(ActionEvent event)
    {
        String coma = ((Button) event.getSource()).getText();
        if(isResult)
        {
            num1 = "0.";
            isResult = false;
            decimal = true;
            view.setText(num1);
        }

        if(!pickedOperation && !decimal)
        {
            num1 += coma;
            view.setText(num1);
            System.out.println(coma);
            System.out.println(num1);
            decimal = true;
        }
        else if(pickedOperation && !decimal)
        {
            num2 += coma;
            view.setText(num2);
            System.out.println(coma);
            System.out.println(num2);
            decimal = true;
        }
    }
    @FXML
    private void plusMinus()
    {
        float n;
        if(!pickedOperation)
        {
            n = Float.parseFloat(num1);
            n *= -1;
            num1 = myDF.format(n);
            view.setText(num1);
            System.out.println(num1);
        }
        else
        {
            n = Float.parseFloat(num2);
            n *= -1;
            num2 = myDF.format(n);
            view.setText(num2);
            System.out.println(num2);
        }
    }
    @FXML
    private void pickOperation(ActionEvent event)
    {
        op = ((Button) event.getSource()).getText();
        System.out.println(op);
        pickedOperation = true;
        decimal = false;
    }
    @FXML
    private void execute()
    {
        float n1, n2;
        n1 = Float.parseFloat(num1);
        if(num2.equals(""))
        {
            n2 = n1;
        }
        else
        {
            n2 = Float.parseFloat(num2);
        }

        switch (op)
        {
            case "+":
                num1 = myDF.format(n1 + n2);
                num1 = num1.replaceAll(",",".");
                view.setText((num1));
                System.out.println((num1));
                break;
            case "-":
                num1 = myDF.format(n1 - n2);
                num1 = num1.replaceAll(",",".");
                view.setText((num1));
                System.out.println((num1));
                break;
            case "x":
                num1 = myDF.format(n1 * n2);
                num1 = num1.replaceAll(",",".");
                view.setText((num1));
                System.out.println((num1));
                break;
            case "/":
                if(n2 == 0)
                {
                    System.out.println("Error");
                    view.setText("Error");
                }
                else
                {
                    num1 = myDF.format(n1 / n2);
                    num1 = num1.replaceAll(",",".");
                    view.setText((num1));
                    System.out.println((num1));
                }
            break;
        }
        num2 = "";
        op = "";
        pickedOperation = false;
        decimal = false;
        isResult = true;
    }
    @FXML
    private void clear()
    {
        view.setText("0");
        num1 = "";
        num2 = "";
        op = "";
        pickedOperation = false;
        decimal = false;
        isResult = false;
    }
}