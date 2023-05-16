package com.example.rockpaperscissor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlayerFragment extends Fragment implements View.OnClickListener {
    private View ui;
    private View rock, paper, scissor;
    private IHost host;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.player_fragment, null, false);

        this.rock = this.ui.findViewById(R.id.ivRock);
        this.paper = this.ui.findViewById(R.id.ivPaper);
        this.scissor = this.ui.findViewById(R.id.ivScissor);

        this.rock.setOnClickListener(this);
        this.paper.setOnClickListener(this);
        this.scissor.setOnClickListener(this);
        return this.ui;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivRock:
                this.host.battle(0);
                break;
            case R.id.ivPaper:
                this.host.battle(1);
                break;
            case R.id.ivScissor:
                this.host.battle(2);
                break;
        }
    }

    public void setHost(IHost host){
        this.host = host;
    }
}
