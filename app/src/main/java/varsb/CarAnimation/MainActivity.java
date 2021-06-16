package varsb.CarAnimation;
 
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.app.Activity;

public class MainActivity extends Activity {

	LinearLayout mainLayout;
    View car;
    boolean isR=false;
	int start = 0, end = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		mainLayout = findViewById(R.id.mainLayout);	
        car = findViewById(R.id.car);
    }
    public void onSlide(View view) {
		if (isR){
			start = mainLayout.getWidth();
			end = 0;
		} else {
			start = 0;
			end = mainLayout.getWidth()-car.getWidth(); 
		}

		TranslateAnimation animate = new TranslateAnimation(
			start, // fromXDelta
			end  , // toXDelta
			0    , // fromYDelta
			0      // toYDelta
		);
		car.startAnimation(animate);
		animate.setDuration(500);
		animate.setFillAfter(true);
		( (Button) view ).setText(
			isR ?
			"Forword"
			:
			"Reverse"
		);
		isR =! isR;
    }
}
