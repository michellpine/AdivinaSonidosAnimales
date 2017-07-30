package pcamov01cv.adivinasonidosanimales.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import pcamov01cv.adivinasonidosanimales.R;
import pcamov01cv.adivinasonidosanimales.adapter.AnimalAdapter;
import pcamov01cv.adivinasonidosanimales.model.Animal;

public class VerAnimalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_animales);
        showToolbar("Animales", true);

        RecyclerView productoRecycler = (RecyclerView) findViewById(R.id.soundsRecycler);
        productoRecycler.setHasFixedSize(true);

        GridLayoutManager recycleLayoutManager;
        recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        productoRecycler.setLayoutManager(recycleLayoutManager);
        productoRecycler.setItemAnimator(new DefaultItemAnimator());

        AnimalAdapter animalAdapter = new AnimalAdapter(sonidos_casa(), R.layout.cardview_animals, this);
        productoRecycler.setAdapter(animalAdapter);

    }

    public ArrayList<Animal> sonidos_casa() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.buho, "Búho", R.raw.buho));
        animals.add(new Animal(R.drawable.ardilla, "Ardilla", R.raw.ardilla));
        animals.add(new Animal(R.drawable.oso, "Oso", R.raw.oso));
        animals.add(new Animal(R.drawable.rana, "Rana", R.raw.rana));
        animals.add(new Animal(R.drawable.aguila, "Aguila", R.raw.aguila));
        animals.add(new Animal(R.drawable.mono, "Mono", R.raw.mono));
        animals.add(new Animal(R.drawable.perro, "Perro", R.raw.perro));
        animals.add(new Animal(R.drawable.gato, "Gato", R.raw.gato));
        animals.add(new Animal(R.drawable.loro, "Loro", R.raw.loro));
        animals.add(new Animal(R.drawable.perico, "Perico", R.raw.perico));
        animals.add(new Animal(R.drawable.leon, "Leon", R.raw.leon));
        animals.add(new Animal(R.drawable.tigre, "Tigre", R.raw.tigre));
        animals.add(new Animal(R.drawable.elefante, "Elefante", R.raw.elefante));
        animals.add(new Animal(R.drawable.lobo, "Lobo", R.raw.lobo));
        animals.add(new Animal(R.drawable.gorilla, "Gorila", R.raw.gorilla));
        animals.add(new Animal(R.drawable.serpiente, "Serpiente", R.raw.serpiente));
        return animals;
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
