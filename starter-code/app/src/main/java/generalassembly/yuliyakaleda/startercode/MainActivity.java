package generalassembly.yuliyakaleda.startercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  TextView txtView;
   EditText edtText;
    Button btnAdd;
    ViewGroup linearView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.
        txtView = (TextView) findViewById(R.id.txtView);
        edtText = (EditText) findViewById(R.id.edtText);
        btnAdd = (Button) findViewById(R.id.btnAddWish);
        linearView = (ViewGroup) findViewById(R.id.lstView);

               btnAdd.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
        // TODO: 1. get the text from the input field
                //       2. animate it in the center of the screen
                        //       3. add it to the list wish
                                //       4. clear the input field

                                                String wishStr = edtText.getText().toString();

                if (wishStr.trim().equals("")){
            edtText.setError("No empty wishes, please.");
            return;
          }

               txtView.setText(wishStr);

                Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);

                txtView.startAnimation(animation);
        txtView.setVisibility(View.INVISIBLE);

                TextView newWishItem = new TextView(this);
        newWishItem.setTextSize(25.0f);
        newWishItem.setText(wishStr);

                animation = AnimationUtils.loadAnimation(this, R.anim.wishanimation);

                linearView.addView(newWishItem,0);
        newWishItem.startAnimation(animation);

                edtText.setText("");

  }
}

