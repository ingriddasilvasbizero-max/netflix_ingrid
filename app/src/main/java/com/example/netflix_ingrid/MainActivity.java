package com.example.netflix_ingrid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        
        // Inicia com o Splash Screen
        setContentView(R.layout.activity_main);
        
        // Navega para a Home após 2.5 segundos
        new Handler(Looper.getMainLooper()).postDelayed(this::showHome, 2500);
    }

    private void setupBottomNavigation(int activeTabId) {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(activeTabId);
            bottomNav.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home && activeTabId != R.id.nav_home) {
                    showHome();
                    return true;
                } else if (itemId == R.id.nav_rooms && activeTabId != R.id.nav_rooms) {
                    showLobby();
                    return true;
                } else if (itemId == R.id.nav_profile && activeTabId != R.id.nav_profile) {
                    showProfile();
                    return true;
                }
                return false;
            });
        }
    }

    private void showHome() {
        setContentView(R.layout.inicio);
        setupBottomNavigation(R.id.nav_home);
        
        View btnSala = findViewById(R.id.btn_sala_virtual);
        if (btnSala != null) {
            btnSala.setOnClickListener(v -> showLobby());
        }

        View tvSeries = findViewById(R.id.tv_series);
        if (tvSeries != null) {
            tvSeries.setOnClickListener(v -> showSeriesCatalog());
        }

        View tvFilmes = findViewById(R.id.tv_filmes);
        if (tvFilmes != null) {
            tvFilmes.setOnClickListener(v -> showMoviesCatalog());
        }

        View tvMinhaLista = findViewById(R.id.tv_minha_lista);
        if (tvMinhaLista != null) {
            tvMinhaLista.setOnClickListener(v -> showMyList());
        }
    }

    private void showLobby() {
        setContentView(R.layout.salavirtualinicio);
        setupBottomNavigation(R.id.nav_rooms);
        
        View btnEnter = findViewById(R.id.btn_enter_room);
        if (btnEnter != null) {
            btnEnter.setOnClickListener(v -> showPlayer());
        }
    }

    private void showProfile() {
        setContentView(R.layout.perfil);
        setupBottomNavigation(R.id.nav_profile);
        
        View btnBack = findViewById(R.id.btn_back_profile);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> showHome());
        }
    }

    private void showMoviesCatalog() {
        setContentView(R.layout.filmes);
        View btnBack = findViewById(R.id.btn_back_movies);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> showHome());
        }
    }

    private void showSeriesCatalog() {
        setContentView(R.layout.series);
        View btnBack = findViewById(R.id.btn_back_series);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> showHome());
        }
    }

    private void showPlayer() {
        setContentView(R.layout.sala_virtual);
        View btnBack = findViewById(R.id.btn_back_player);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> showLobby());
        }
    }

    private void showMyList() {
        setContentView(R.layout.minha_lista);
        View btnBack = findViewById(R.id.btn_back_my_list);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> showHome());
        }
    }

    @Override
    public void onBackPressed() {
        if (findViewById(R.id.video_container) != null) {
            showLobby();
        } else if (findViewById(R.id.tv_title) != null || // Lobby
                   findViewById(R.id.tv_profile_title) != null || // Profile
                   findViewById(R.id.tv_movies_title) != null || // Movies
                   findViewById(R.id.tv_my_list_title) != null || // My List
                   findViewById(R.id.tv_series_title) != null) { // Series
            showHome();
        } else if (findViewById(R.id.logo) != null) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}