package com.example.clase2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextContrasenia;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnLogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextNombre = findViewById(R.id.username);
        editTextContrasenia = findViewById(R.id.textPassword);
        buttonLogin = findViewById(R.id.btnL);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String contrasenia = editTextContrasenia.getText().toString();

                boolean usuarioEncontrado = false;
                for (Usuario usuario : RegisterActivity.usuarios) {
                    if (usuario.getUsername().equals(nombre) && usuario.getPassword().equals(contrasenia)) {
                        usuarioEncontrado = true;
                        break;
                    }
                }

                if (usuarioEncontrado) {
                    Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Navegar a la actividad de bienvenida
                    Intent intent = new Intent(Login.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Nombre o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}