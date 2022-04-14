package com.example.spo.presenter;

import com.example.spo.view.InputView;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class InputPresenter {
    private String FirstField;
    private String SecondField;
    private String ThirdField;

    private String dateRegex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private String emailRegex = "^(|(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{1,6})$";
    public String getFirstField() {
        return FirstField;
    }

    public void setFirstField(String firstField) {
        FirstField = firstField;
    }

    public String getSecondField() {
        return SecondField;
    }

    public void setSecondField(String secondField) {
        SecondField = secondField;
    }

    public String getThirdField() {
        return ThirdField;
    }

    public void setThirdField(String thirdField) {
        ThirdField = thirdField;
    }

    public void OKButton(TextField FieldOne, TextField FieldTwo, TextField FieldThree,InputView inputView){
        boolean ex = false;
        if(inputView.getLabelThree().getText().equals("Creation") && !Pattern.matches(dateRegex, inputView.getFieldThree().getText())) {
                inputView.getErrorLabel().setText("Дата введена некорректно");
                ex = true;
        }
        if(inputView.getLabelThree().getText().equals("Email") && !Pattern.matches(emailRegex, inputView.getFieldThree().getText())) {
            inputView.getErrorLabel().setText("Email введен некорректно");
            ex = true;
        }

        if(!ex && !FieldOne.getText().equals("") && !FieldTwo.getText().equals("") && !FieldThree.getText().equals("")){
            setFirstField(FieldOne.getText());
            setSecondField(FieldTwo.getText());
            setThirdField(FieldThree.getText());
        }
        inputView.getLabelThree().getScene().getWindow().hide();
    }
    public static void Launch(InputView inputView){
        inputView.setInputPresenter(new InputPresenter());
        inputView.getOKButton().setOnAction(actionEvent -> inputView.getInputPresenter().OKButton(inputView.getFieldOne(),
                inputView.getFieldTwo(), inputView.getFieldThree(), inputView));
    }
}
