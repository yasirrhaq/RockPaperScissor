package com.example.rockpaperscissor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BattleFragment extends Fragment {
    private View ui;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.battle_fragment, null, false);
        return this.ui;
    }

    public void battle(int playerHand, int enemyHand) {
        ImageView ivPlayer = this.ui.findViewById(R.id.ivBattlePlayer);
        ImageView ivEnemy = this.ui.findViewById(R.id.ivBattleEnemy);

        ivPlayer.setImageResource(handIcon(playerHand));
        ivEnemy.setImageResource(handIcon(enemyHand));
    }

    public int handIcon(int hand) {
        switch (hand) {
            case 0:
                return R.drawable.rock;
            case 1:
                return R.drawable.paper;
            default:
                return R.drawable.scissor;
        }
    }
}
