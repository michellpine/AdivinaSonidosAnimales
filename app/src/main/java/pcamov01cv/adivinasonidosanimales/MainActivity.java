package pcamov01cv.adivinasonidosanimales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pcamov01cv.adivinasonidosanimales.view.JugarActivity;
import pcamov01cv.adivinasonidosanimales.view.VerAnimalesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goJugarActivity(View view){
        Intent intent = new Intent(this, JugarActivity.class);
        startActivity(intent);

    }

    public void goVerAnimalesActivity(View view){
        Intent intent = new Intent(this, VerAnimalesActivity.class);
        startActivity(intent);

    }
}
