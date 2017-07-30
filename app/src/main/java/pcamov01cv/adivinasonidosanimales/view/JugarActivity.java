package pcamov01cv.adivinasonidosanimales.view;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import pcamov01cv.adivinasonidosanimales.MainActivity;
import pcamov01cv.adivinasonidosanimales.R;

public class JugarActivity extends AppCompatActivity {

    Random r = new Random();
    MediaPlayer mediaPlayer;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private TextView txtCorrecto;
    private TextView txtIncorrecto;
    int res, a0, a1, a2, a3;
    int correcto;
    int incorrecto;
    PopupWindow popUpWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        showToolbar(" ", true);

        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);

        txtCorrecto = (TextView) findViewById(R.id.correctos);
        txtIncorrecto = (TextView) findViewById(R.id.incorrectos);

        this.setGame();
    }

    public void setGame() {
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);

        button1.setBackgroundResource(R.drawable.fondo);
        button2.setBackgroundResource(R.drawable.fondo);
        button3.setBackgroundResource(R.drawable.fondo);
        button4.setBackgroundResource(R.drawable.fondo);

        if(correcto==8 || incorrecto == 8){
            Toast.makeText(this, "Juego Finalizado",
                    Toast.LENGTH_LONG).show();
            final Intent intent = new Intent(this, MainActivity.class);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                }
            }, 2000);

        }else {

            a0 = r.nextInt(20);
            a1 = r.nextInt(20);
            while (a1 == a0) {
                a1 = r.nextInt(20);
            }
            a2 = r.nextInt(20);
            while ((a2 == a0) || (a2 == a1)) {
                a2 = r.nextInt(20);
            }
            a3 = r.nextInt(20);
            while ((a3 == a0) || (a3 == a1) || (a3 == a2)) {
                a3 = r.nextInt(20);
            }

            this.setImage(button1, a0);
            this.setImage(button2, a1);
            this.setImage(button3, a2);
            this.setImage(button4, a3);

            int i = r.nextInt(4);
            switch (i) {
                case 0:
                    this.res = a0;
                    break;
                case 1:
                    this.res = a1;
                    break;
                case 2:
                    this.res = a2;
                    break;
                case 3:
                    this.res = a3;
                    break;
            }
            if (mediaPlayer != null)
                mediaPlayer.stop();
            mediaPlayer = setSound(res);
            mediaPlayer.start();
        }
    }

    public void onButton1Click(View view) {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        if (res == a0) {
            button1.setBackgroundColor(Color.GREEN);
            correcto = correcto + 1;
            txtCorrecto.setText(Integer.toString(correcto));
        } else {
            button1.setBackgroundColor(Color.RED);
            incorrecto = incorrecto + 1;
            txtIncorrecto.setText(Integer.toString(incorrecto));
        }
        mediaPlayer.start();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                setGame();
            }
        }, 1000);
    }

    public void onButton2Click(View view) {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        if (res == a1) {
            button2.setBackgroundColor(Color.GREEN);
            correcto = correcto + 1;
            txtCorrecto.setText(Integer.toString(correcto));
        } else {
            button2.setBackgroundColor(Color.RED);
            incorrecto = incorrecto + 1;
            txtIncorrecto.setText(Integer.toString(incorrecto));
        }
        mediaPlayer.start();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                setGame();
            }
        }, 1000);
    }

    public void onButton3Click(View view) {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        if (res == a2) {
            button3.setBackgroundColor(Color.GREEN);
            correcto = correcto + 1;
            txtCorrecto.setText(Integer.toString(correcto));
        } else {
            button3.setBackgroundColor(Color.RED);
            incorrecto = incorrecto + 1;
            txtIncorrecto.setText(Integer.toString(incorrecto));
        }
        mediaPlayer.start();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                setGame();
            }
        }, 1000);
    }

    public void onButton4Click(View view) {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        if (res == a3) {
            button4.setBackgroundColor(Color.GREEN);
            correcto = correcto + 1;
            txtCorrecto.setText(Integer.toString(correcto));
        } else {
            button4.setBackgroundColor(Color.RED);
            incorrecto = incorrecto + 1;
            txtIncorrecto.setText(Integer.toString(incorrecto));
        }
        mediaPlayer.start();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                setGame();
            }
        }, 1000);
    }

    public MediaPlayer setSound(int num) {
        switch (num) {
            case 0:
                return MediaPlayer.create(getBaseContext(), R.raw.ardilla);
            case 1:
                return MediaPlayer.create(getBaseContext(), R.raw.asno);
            case 2:
                return MediaPlayer.create(getBaseContext(), R.raw.caballo);
            case 3:
                return MediaPlayer.create(getBaseContext(), R.raw.cerdo);
            case 4:
                return MediaPlayer.create(getBaseContext(), R.raw.elefante);
            case 5:
                return MediaPlayer.create(getBaseContext(), R.raw.gallo);
            case 6:
                return MediaPlayer.create(getBaseContext(), R.raw.gato);
            case 7:
                return MediaPlayer.create(getBaseContext(), R.raw.leon);
            case 8:
                return MediaPlayer.create(getBaseContext(), R.raw.mono);
            case 9:
                return MediaPlayer.create(getBaseContext(), R.raw.oso);
            case 10:
                return MediaPlayer.create(getBaseContext(), R.raw.perico);
            case 11:
                return MediaPlayer.create(getBaseContext(), R.raw.aguila);
            case 12:
                return MediaPlayer.create(getBaseContext(), R.raw.perro);
            case 13:
                return MediaPlayer.create(getBaseContext(), R.raw.rana);
            case 14:
                return MediaPlayer.create(getBaseContext(), R.raw.serpiente);
            case 15:
                return MediaPlayer.create(getBaseContext(), R.raw.vaca);
            case 16:
                return MediaPlayer.create(getBaseContext(), R.raw.buho);
            case 17:
                return MediaPlayer.create(getBaseContext(), R.raw.gallina);
            case 18:
                return MediaPlayer.create(getBaseContext(), R.raw.lobo);
            case 19:
                return MediaPlayer.create(getBaseContext(), R.raw.loro);
        }
        return MediaPlayer.create(getBaseContext(), R.raw.lobo);
    }

    public void setImage(ImageButton button, int num) {
        switch (num) {
            case 0:
                button.setImageResource(R.drawable.ardilla);
                break;
            case 1:
                button.setImageResource(R.drawable.asno);
                break;
            case 2:
                button.setImageResource(R.drawable.caballo);
                break;
            case 3:
                button.setImageResource(R.drawable.cerdo);
                break;
            case 4:
                button.setImageResource(R.drawable.elefante);
                break;
            case 5:
                button.setImageResource(R.drawable.gallo);
                break;
            case 6:
                button.setImageResource(R.drawable.gato);
                break;
            case 7:
                button.setImageResource(R.drawable.leon);
                break;
            case 8:
                button.setImageResource(R.drawable.mono);
                break;
            case 9:
                button.setImageResource(R.drawable.oso);
                break;
            case 10:
                button.setImageResource(R.drawable.perico);
                break;
            case 11:
                button.setImageResource(R.drawable.aguila);
                break;
            case 12:
                button.setImageResource(R.drawable.perro);
                break;
            case 13:
                button.setImageResource(R.drawable.rana);
                break;
            case 14:
                button.setImageResource(R.drawable.serpiente);
                break;
            case 15:
                button.setImageResource(R.drawable.vaca);
                break;
            case 16:
                button.setImageResource(R.drawable.buho);
                break;
            case 17:
                button.setImageResource(R.drawable.gallina);
                break;
            case 18:
                button.setImageResource(R.drawable.lobo);
                break;
            case 19:
                button.setImageResource(R.drawable.loro);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mediaPlayer != null)
                mediaPlayer.stop();
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
