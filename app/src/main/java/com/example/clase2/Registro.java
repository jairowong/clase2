package com.example.clase2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextContrasenia;
    private Button buttonRegistrar;

    public static ArrayList<Usuario> usuarios = new ArrayList<>(); // Almacena los usuarios registrados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnLogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextNombre = findViewById(R.id.name);
        editTextContrasenia = findViewById(R.id.password);
        buttonRegistrar = findViewById(R.id.registrar);
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String contrasenia = editTextContrasenia.getText().toString();

                if (!nombre.isEmpty() && !contrasenia.isEmpty()) {
                    Usuario usuario = new Usuario(nombre, contrasenia);
                    usuarios.add(usuario);
                    Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                    // Navegar a la actividad de inicio de sesión
                    Intent intent = new Intent(Registro.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Registro.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}