package com.samatfunstudios.smartcalculator;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.GestureDetector.OnGestureListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Smart_claculator extends AppCompatActivity implements View.OnClickListener, OnGestureListener {
    AudioPlayer audioPlayer;
    EditText display;
    float op1;
    float op2;
    String optr = "";
    private GestureDetector gd;
    int currentposition = 0;
    ShowAdUtil showAdUtil;

    LinearLayout parentLL;

    static List<SCThemeInfo> themeseList;

    Button one, two, three, four, five, six, seven, eight, nine, add, mul, sub, div, zero, AC, equal, dot, percentage, brecket, bracket, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_smart_claculator);
        display = (EditText) findViewById(R.id.display);
        themeseList = new ArrayList<SCThemeInfo>();

        showAdUtil = new ShowAdUtil(this);
        initThemeseList();


        parentLL = (LinearLayout) findViewById(R.id.parentLL);
        audioPlayer = new AudioPlayer(this);
        percentage = (Button) findViewById(R.id.percentage);
        back = (Button) findViewById(R.id.back);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        equal = (Button) findViewById(R.id.equal);
        AC = (Button) findViewById(R.id.AC);
        sub = (Button) findViewById(R.id.sub);
        dot = (Button) findViewById(R.id.dot);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        brecket = (Button) findViewById(R.id.brecket);
        bracket = (Button) findViewById(R.id.bracket);
        ////// setOnClickListener(this) points out click event defined as a switch case in the onClick() method respectively/////

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        AC.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        percentage.setOnClickListener(this);

        dot.setOnClickListener(this);
        back.setOnClickListener(this);

        gd = new GestureDetector(this, this);


    }
    //operation() method define all the basic operation for calculator.//

    public void operation() {
        if (optr.equals("+")) {
//            op2 = Integer.parseInt(display.getText().toString());
//            display.setText("");
            op1 = op1 + op2;
            display.setText("Result : " + Float.toString(op1));
        } else if (optr.equals("-")) {
//            op2 = Integer.parseInt(display.getText().toString());
//            display.setText("");
            op1 = op1 - op2;
            display.setText("Result : " + Float.toString(op1));
        } else if (optr.equals("*")) {
//            op2 = Integer.parseInt(display.getText().toString());
//            display.setText("");
            op1 = op1 * op2;
            display.setText("Result : " + Float.toString(op1));
        } else if (optr.equals("/")) {
//            op2 = Integer.parseInt(display.getText().toString());
//            display.setText("");
            op1 = op1 / op2;
            display.setText("Result : " + Float.toString(op1));
        } else if (optr.equals("%")) {
            op1 = op1 * (op2 / 100);
            display.setText("Result : " + Float.toString(op1));
        }

        optr = "";
        op1 = 0;
        op2 = 0;
    }

    ////onClick() method is implemented of OnClickListener interface, which handle all the clicking buttons of calculator application.//////


    public void changeTheme() {
        parentLL.setBackgroundDrawable(null);
        System.gc();
        parentLL.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));
        audioPlayer.playAudio("clicksound.mp3");

        changebuttonbackground();

        // one, two, three, four, five, six, seven, eight, nine,  add, mul, sub, div, zero, AC, equal,dot;


    }

    @Override
    public void onClick(View v) {
        String text = display.getText().toString().replace("Result :", "");
        display.setText(text);
        Editable str = display.getText();

        audioPlayer.playAudio("clicksound.mp3");

        switch (v.getId()) {
            case R.id.one:
                //one.setBackgroundColor(getResources().getColor(R.color.date_color));
//                parentLL.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(one.getText());
                display.setText(str);
                break;
            case R.id.two:
                //two.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }

                str = str.append(two.getText());
                display.setText(str);
                //changebackground();
                break;
            case R.id.three:
                //three.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(three.getText());
                display.setText(str);
                break;
            case R.id.four:
                //four.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(four.getText());
                display.setText(str);
                break;
            case R.id.five:
                //five.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(five.getText());
                display.setText(str);
                break;
            case R.id.six:
                //six.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(six.getText());
                display.setText(str);
                break;
            case R.id.seven:
                // seven.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(seven.getText());
                display.setText(str);
                break;
            case R.id.eight:
                //eight.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(eight.getText());
                display.setText(str);
                break;
            case R.id.nine:
                //nine.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                str = str.append(nine.getText());
                display.setText(str);
                break;
            case R.id.zero:
                //zero.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }

                if (Float.parseFloat(str.toString()) == 0.0f) {
                    return;
                }
                str = str.append(zero.getText());
                display.setText(str);
                break;
            case R.id.dot:
                //dot.setBackgroundColor(getResources().getColor(R.color.date_color));
//                if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                }
                if (str.toString().contains(".")) {
                    return;
                }
                str = str.append(dot.getText());
                display.setText(str);
                break;
            case R.id.AC:
                // AC.setBackgroundColor(getResources().getColor(R.color.date_color));
                op1 = 0;
                op2 = 0;
                display.setText("");
                optr = "";

                break;

            case R.id.add:
                //add.setBackgroundColor(getResources().getColor(R.color.date_color));

                if (display.getText().toString().equals("")) {
                    return;
                }
                if (optr.equals("")) {
                    optr = "+";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
            case R.id.back:
                String currentStr = display.getText().toString();

                if (currentStr.equals("")) {
                    return;
                }

                currentStr = currentStr.substring(0, currentStr.length() - 1);

                display.setText(currentStr);

                //add.setBackgroundColor(getResources().getColor(R.color.date_color));
                break;
            case R.id.percentage:
                //percentage.setBackgroundColor(getResources().getColor(R.color.date_color));
                if (display.getText().toString().equals("")) {
                    return;
                }

                if (optr.equals("")) {
                    optr = "%";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }


//                optr = "+";
//                if (op1 == 0) {
//                    op1 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                } else if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                } else {
//                    op2 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                    op1 = op1 + op2;
//                    display.setText("" + Integer.toString(op1));
//                }
                break;
            case R.id.sub:
                //sub.setBackgroundColor(getResources().getColor(R.color.date_color));

                if (display.getText().toString().equals("")) {
                    return;
                }
                if (optr.equals("")) {
                    optr = "-";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
//
//                optr = "-";
//                if (op1 == 0) {
//                    op1 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                } else if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                } else {
//                    op2 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                    op1 = op1 - op2;
//                    display.setText("" + Integer.toString(op1));
//                }
                break;
            case R.id.mul:
                //mul.setBackgroundColor(getResources().getColor(R.color.date_color));
                if (display.getText().toString().equals("")) {
                    return;
                }
                if (optr.equals("")) {
                    optr = "*";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
//                optr = "*";
//                if (op1 == 0) {
//                    op1 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                } else if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                } else {
//                    op2 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                    op1 = op1 * op2;
//                    display.setText("" + Integer.toString(op1));
//                }
                break;


            case R.id.div:
                //div.setBackgroundColor(getResources().getColor(R.color.date_color));

                if (display.getText().toString().equals("")) {
                    return;
                }
                if (optr.equals("")) {
                    optr = "/";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
                break;
            case R.id.bracket:
                //div.setBackgroundColor(getResources().getColor(R.color.date_color));


                if (optr.equals("")) {
                    optr = ")";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
                break;
            case R.id.brecket:
                //div.setBackgroundColor(getResources().getColor(R.color.date_color));


                if (optr.equals("")) {
                    optr = "(";
                    op1 = Float.parseFloat(display.getText().toString());
                    display.setText("");
                }
//                optr = "/";
//                if (op1 == 0) {
//                    op1 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                } else if (op2 != 0) {
//                    op2 = 0;
//                    display.setText("");
//                } else {
//                    op2 = Integer.parseInt(display.getText().toString());
//                    display.setText("");
//                    op1 = op1 / op2;
//                    display.setText("" + Integer.toString(op1));
//                }

/* op1 = op1 / op2;*/
            case R.id.equal:
                //equal.setBackgroundColor(getResources().getColor(R.color.date_color));

                if (display.getText().toString().equals(""))
                    return;

                op2 = Float.parseFloat(display.getText().toString());


                if (!optr.equals(null) || (!optr.equals(""))) {
                    operation();
//                    if (op2 != 0) {
//                        if (optr.equals("+")) {
//                            display.setText("");
//                            display.setText("Result : " + Float.toString(op1));
//                        } else if (optr.equals("-")) {
//                            display.setText("");
//                            display.setText("Result : " + Float.toString(op1));
//                        } else if (optr.equals("*")) {
//                            display.setText("");
//                            display.setText("Result : " + Float.toString(op1));
//                        } else if (optr.equals("/")) {
//                            display.setText("");
//                            display.setText("Result : " + Float.toString(op1));
//                        }
//                    } else {
//                        operation();
//                    }
                }
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smart_claculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void changebackground()
//
//    {
//        if(currentposition == 0)
//        {
//            display.setBackgroundDrawable(getResources().getDrawable(R.color.red));
//        }
//        else if (currentposition >0)
//        {
//            display.setBackgroundDrawable(getResources().getDrawable(R.color.black));
//        }
//
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gd.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (showAdUtil == null) {
            showAdUtil = new ShowAdUtil(this);
        }
        showAdUtil.creatInterstitialAdd();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public void onBackPressed() {
        showAdUtil.showInterstitial();
        super.onBackPressed();

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float sensitivity = 1;
//        //Swipe Up Check
//        if(e1.getY() - e2.getY() > sensitivity){
//            //Setting Image Resource to Up_Arrow on Swipe Up
//            swipe_image.setImageResource(R.drawable.fifth);
//            return true;
//        }
//        //Swipe Down Check
//        else if(e2.getY() - e1.getY() > sensitivity){
//            //Setting Image Resource to Down_Arrow on Swipe Down
//            swipe_image.setImageResource(R.drawable.first);
//            return true;
//        }
        //Swipe Left Check
        if (e1.getX() - e2.getX() > sensitivity) {
            //Setting Image Resource to Left_Arrow on Swipe Left

            if (currentposition == 0) {
                currentposition = themeseList.size() - 1;
            } else {
                currentposition--;
            }
//            swipe_image.setImageResource(initThemeseList.get(currentposition));
            changeTheme();
            return true;
        }
        //Swipe Right Check
        else if (e2.getX() - e1.getX() > sensitivity) {
            //Setting Image Resource to Right_Arrow on Swipe Right

            if (currentposition == (themeseList.size() - 1)) {
                currentposition = 0;
            } else {
                currentposition++;
            }

            changeTheme();
            // changebuttonbackground().setBackgroundDrawable(getResources().getDrawable((themeseList.get(currentposition).getBtnBackgroundImg())));
//             AC.setImageDrawable(getResources().getDrawable(kalmadatainfoList.get(currentKalmaPos).getKalmaTtlStr()));

            return true;
        } else {
            //If some error occurrs, setting again to Default_Image (Actually it will never happen in this case)
//            swipe_image.setImageResource(R.mipmap.ic_launcher);
            return true;
        }

    }


    public void initThemeseList() {
        themeseList.clear();


        SCThemeInfo list1 = new SCThemeInfo();

        list1.setBtnBackgroundImg(R.drawable.butn_bag);
        list1.setBtnTextColor(R.color.black);
        list1.setThemeBackgroundImg(R.drawable.theme1);
        themeseList.add(list1);

        SCThemeInfo list2 = new SCThemeInfo();
        list2.setThemeBackgroundImg(R.drawable.theme20);
        list2.setBtnTextColor(R.color.white);
        list2.setBtnBackgroundImg(R.drawable.button);

        themeseList.add(list2);

        SCThemeInfo list3 = new SCThemeInfo();
        list3.setThemeBackgroundImg(R.drawable.theme24);
        list3.setBtnTextColor(R.color.white);
        list3.setBtnBackgroundImg(R.drawable.changeimage);

        themeseList.add(list3);

        SCThemeInfo list4 = new SCThemeInfo();
        list4.setThemeBackgroundImg(R.drawable.theme22);
        list4.setBtnTextColor(R.color.white);
        list4.setBtnBackgroundImg(R.drawable.btnimg5);
        themeseList.add(list4);

        SCThemeInfo list5 = new SCThemeInfo();
        list5.setThemeBackgroundImg(R.drawable.skin4_background);
        list5.setBtnTextColor(R.color.white);
        list5.setBtnBackgroundImg(R.drawable.btn2img);
        themeseList.add(list5);

//        SCThemeInfo list6 = new SCThemeInfo();
//        list5.setThemeBackgroundImg(R.drawable.theme21);
//        list5.setBtnTextColor(R.color.black);
//        list5.setBtnBackgroundImg(R.drawable.butn_bag);
//        themeseList.add(list6);


    }

    public void changebuttonbackground() {


        one.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        one.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    one.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));


        two.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        two.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    two.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));


        three.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        three.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    three.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        four.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        four.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    four.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        five.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        five.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    five.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        six.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        six.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    six.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        seven.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        seven.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    seven.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        eight.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        eight.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    eight.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        nine.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        nine.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    nine.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        zero.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        zero.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    zero.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        AC.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        AC.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    AC.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        add.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        add.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    add.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        sub.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        sub.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    sub.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        mul.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        mul.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    mul.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        dot.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        dot.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    dot.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));

        div.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        div.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));
//    div.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getThemeBackgroundImg()));


        bracket.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        bracket.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));

        brecket.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        brecket.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));


        percentage.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        percentage.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));

        equal.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        equal.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));

        back.setBackgroundDrawable(getResources().getDrawable(themeseList.get(currentposition).getBtnBackgroundImg()));
        back.setTextColor(getResources().getColor(themeseList.get(currentposition).getBtnTextColor()));

    }


    public  Drawable getDrawableFromAssets(String url){
        Drawable drawable = null;
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(url);
            drawable = Drawable.createFromStream(inputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return drawable;
    }


}


//////////////////
//kalmadatainfoList.clear();
//
//        Kalmadatainfo kalma1 = new Kalmadatainfo();
//        kalma1.setNoOfKalma(1);
//        kalma1.setKalma_Arabic_text(R.drawable.kalma1);
//        kalma1.setKalma_image_id(1);
//        kalma1.setKalma_English_text(getResources().getString(R.string.English_Kalma1));
//        kalma1.setUrdu_text(getResources().getString(R.string.urdu_kalma1));
////        kalma1.setKalmaTtlStr("First Kalma");
//        kalma1.setKalmaTtlStr(R.mipmap.first);
//        kalma1.setKalmaName(getResources().getString(R.string.kalma1Ttl));
//        kalmadatainfoList.add(kalma1);
///////////////////////////////