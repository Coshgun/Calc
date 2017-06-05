/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applecalc;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Font;

/**
 *
 * @author aze
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton Button0;
    @FXML
    private Label LabelScreen;
    @FXML
    private JFXButton ButtonAC;
    @FXML
    private JFXButton ButtonInverse;
    @FXML
    private JFXButton ButtonPercent;
    @FXML
    private JFXButton Button9;
    @FXML
    private JFXButton Button8;
    @FXML
    private JFXButton Button7;
    @FXML
    private JFXButton Button2;
    @FXML
    private JFXButton Button1;
    @FXML
    private JFXButton Button6;
    @FXML
    private JFXButton Button5;
    @FXML
    private JFXButton Button4;
    @FXML
    private JFXButton Button3;
    @FXML
    private JFXButton ButtonPoint;
    @FXML
    private JFXButton ButtonDivide;
    @FXML
    private JFXButton ButtonMulti;
    @FXML
    private JFXButton ButtonMinus;
    @FXML
    private JFXButton ButtonPlus;
    @FXML
    private JFXButton ButtonClickEqual;
    
    private String operation="";
    private String first="";
    private int toggle = 0;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LabelText();
    }

    private void InsertDigit (int a){
        if (toggle==0 && !(operation.equals(""))) {
           LabelScreen.setText(a+"");
             toggle=1;
        }else{
        if (LabelScreen.getText().equals("0")) {
            LabelScreen.setText(a+"");
        }else if(LabelScreen.getText().equals("-0")){
            LabelScreen.setText("-"+a);
        }
        else{
            LabelScreen.setText(LabelScreen.getText()+a);
        }
    }}
    
    private void Operation(String s){
        operation=s;
        first=LabelScreen.getText();
        
    }
    
    private void Equal(String s){
        float firstt=Float.parseFloat(this.first);
        float second=Float.parseFloat(LabelScreen.getText());
        float result=0;
        switch(s){
            case "plus": result=firstt+second;
            break;
            case "minus": result=firstt-second;
            break;
            case "multi": result=firstt*second;
            break;
            case "divide": result=firstt/second;
            break;
        }
        LabelScreen.setText(result+"");
        
        
    }

    @FXML
    private void ButtonClick0(ActionEvent event) {
        InsertDigit(0);
    }

    @FXML
    private void ButtonClickAC(ActionEvent event) {
        LabelScreen.setText("0");
        operation="";
        first="";
        toggle=0;
       
        if (ButtonAC.getText().equals("C")) {
            ButtonAC.setText("AC");
        }
        
    }

    @FXML
    private void ButtonClickInverse(ActionEvent event) {
        if (LabelScreen.getText().startsWith("-")) {
            LabelScreen.setText(LabelScreen.getText().substring(1));
        }else if (!(LabelScreen.getText().startsWith("-"))) {
            LabelScreen.setText("-"+LabelScreen.getText());
        }
    }

    @FXML
    private void ButtonClickPercent(ActionEvent event) {
        LabelScreen.setText((Float.parseFloat(LabelScreen.getText())/100)+"");
    }

    @FXML
    private void ButtonClick9(ActionEvent event) {
        InsertDigit(9);
    }

    @FXML
    private void ButtonClick8(ActionEvent event) {
        InsertDigit(8);
    }

    @FXML
    private void ButtonClick7(ActionEvent event) {
        InsertDigit(7);
    }

    @FXML
    private void ButtonClick2(ActionEvent event) {
        InsertDigit(2);
    }

    @FXML
    private void ButtonClick1(ActionEvent event) {
        InsertDigit(1);
    }

    @FXML
    private void ButtonClick6(ActionEvent event) {
        InsertDigit(6);
    }

    @FXML
    private void ButtonClick5(ActionEvent event) {
        InsertDigit(5);
    }

    @FXML
    private void ButtonClick4(ActionEvent event) {
        InsertDigit(4);
    }

    @FXML
    private void ButtonClick3(ActionEvent event) {
        InsertDigit(3);
    }

    @FXML
    private void ButtonClickPoint(ActionEvent event) {
        if (!(LabelScreen.getText().contains("."))) {
            LabelScreen.setText(LabelScreen.getText()+".");
        }
    }

    @FXML
    private void ButtonClickDivide(ActionEvent event) {
        Operation("divide");
    }

    @FXML
    private void ButtonClickMulti(ActionEvent event) {
        Operation("multi");
    }

    @FXML
    private void ButtonClickMinus(ActionEvent event) {
        Operation("minus");
    }

    @FXML
    private void ButtonClickPlus(ActionEvent event) {
        Operation("plus");
        
    }

    @FXML
    private void ButtonClickEqual(ActionEvent event) {
        int a=0;
        
        switch(operation){
            case "plus": Equal("plus");
            break;
            case "minus": Equal("minus");
            break;
            case "multi": Equal("multi");
            break;
            case "divide": Equal("divide");
        }
        
        //bundan sonra for dongusu yaziriq, yoxlayiriq eger alinan 
        //netice meselen: 15.00 formatindadirsa onu deyisib 15 kimi ekrana yazmaq ucun.
        //eger ededin terkibinde noqteden sonra en az bir defe 0-dan ferqli eded olsa yuxaridaki int a-nin qiymeti
        //1-e beraberleshdirilir. sonra da if-le yoxlayiriq eger a==0sa demeli noqteden sonra ancaq 0dir.
        for (int i = 0; i < LabelScreen.getText().length()-1; i++) {
            if (LabelScreen.getText().charAt(i)=='.') {
                for (int j = i+1; j < LabelScreen.getText().length(); j++) {
                    if (!(LabelScreen.getText().charAt(j)=='0')) {
                      a=1;  
                      
                    }
                }
                
            }
        }
        
        if (a==0) {
            LabelScreen.setText(((int) Float.parseFloat(LabelScreen.getText()))+"");
        }
        
        toggle=0;
    }

    @FXML
    private void LabelTextChanged(InputMethodEvent event) {}
    
    private void LabelText(){
        LabelScreen.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                 if ((LabelScreen.getText().equals("0")||LabelScreen.getText().equals("-0")) && first.equals("")) {
                    ButtonAC.setText("AC");
                }else{
                    ButtonAC.setText("C");
                }
                 
                 
                int count=0;
        for (int i = 0; i < LabelScreen.getText().length(); i++) {
            if (LabelScreen.getText().substring(i, i+1).equals(".")) {
                count++;
            }
        }
                if (LabelScreen.getText().charAt(0)=='-') {
                    count++;
                }
                if (LabelScreen.getText().length()-count<=9) {
                    switch(LabelScreen.getText().length()){
           case 6: LabelScreen.setFont(new Font(75));
           break;
           case 7: LabelScreen.setFont(new Font(65));
           break;
           case 8: LabelScreen.setFont(new Font(55));
           break;
           case 9:
           case 10:
           case 11:    LabelScreen.setFont(new Font(49));
           break;
           default: LabelScreen.setFont(new Font(84));
           break;
       }
                }else{
                    LabelScreen.setText(LabelScreen.getText().substring(0, LabelScreen.getText().length()-1));
                }
              
               
 
            }
        });
    }
    
}
