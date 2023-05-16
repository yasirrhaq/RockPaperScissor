package com.example.rockpaperscissor;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class EnemyFragment extends Fragment {
    private View ui;
    private ImageView ivEnemy;
    private int hand;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.enemy_fragment, null, false);
        this.ivEnemy = this.ui.findViewById(R.id.ivEnemy);

        return this.ui;
    }

    @Override
    public void onResume() {
        super.onResume();
        Handler h = new Handler(Looper.getMainLooper());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int index = (int) (Math.random() * 3);
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            switch (index) {
                                case 0:
                                    ivEnemy.setImageResource(R.drawable.rock);
                                    break;
                                case 1:
                                    ivEnemy.setImageResource(R.drawable.paper);
                                    break;
                                default:
                                    ivEnemy.setImageResource(R.drawable.scissor);
                                    break;
                            }
                        }
                    });
                    try {
                        hand = index;
                        sleep(50);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });
        t.start();
    }

    public int getHand() {
        return this.hand;
    }
}
