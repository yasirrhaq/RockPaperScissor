package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IHost {

    private View enemyContainer, battleContainer, playerContainer;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.enemyContainer = findViewById(R.id.frameEnemy);
        this.battleContainer = findViewById(R.id.frameBattle);
        this.playerContainer = findViewById(R.id.framePlayer);

        this.fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.frameEnemy, new EnemyFragment(), "Enemy Fragment")
                .add(R.id.frameBattle, new BattleFragment(), "Battle Fragment")
                .add(R.id.framePlayer, new PlayerFragment(), "Player Fragment").commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        PlayerFragment pf = (PlayerFragment) this.fm.findFragmentByTag("Player Fragment");
        pf.setHost(this);
    }

    @Override
    public void battle(int hand) {
        EnemyFragment ef = (EnemyFragment) getSupportFragmentManager().findFragmentByTag("Enemy Fragment");
        BattleFragment bf = (BattleFragment) getSupportFragmentManager().findFragmentByTag("Battle Fragment");

        int playerHand = hand;
        int enemyHand = ef.getHand();
        bf.battle(playerHand, enemyHand);
    }
}