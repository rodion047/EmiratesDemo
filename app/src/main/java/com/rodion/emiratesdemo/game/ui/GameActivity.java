package com.rodion.emiratesdemo.game.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rodion.emiratesdemo.R;
import com.rodion.emiratesdemo.game.GameActivityPresenter;
import com.rodion.emiratesdemo.game.model.Player;

import java.util.List;

public class GameActivity extends AppCompatActivity implements GameActivityPresenter.ViewContract {

    private GameActivityPresenter presenter;
    private PlayerListAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        recyclerView = findViewById(R.id.players_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerListAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPlayerData(List<Player> players) {
        adapter.setData(players);
        adapter.notifyDataSetChanged();
    }

    private void setPresenter(CustomNonConfigurationInstance nonConfigurationInstance) {
        if (presenter == null) {
            // Try restore presenter if there was configuration change
            presenter = nonConfigurationInstance != null ? nonConfigurationInstance.getPresenter() : null;
        }

        if (presenter == null) {
            presenter = new GameActivityPresenter();
        }

        presenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        CustomNonConfigurationInstance nonConfigurationInstance =
                (CustomNonConfigurationInstance) getLastCustomNonConfigurationInstance();

        setPresenter(nonConfigurationInstance);
    }

    @Override
    protected void onStop() {
        presenter.detachView();
        super.onStop();
    }

    /**
     * Retain objects that should survive configuration changes.
     *
     * @return presenter.
     */
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return new CustomNonConfigurationInstance(presenter);
    }

    /**
     * Holds objects that should be stored between configuration changes (like rotations).
     */
    private class CustomNonConfigurationInstance {

        private final GameActivityPresenter presenter;

        CustomNonConfigurationInstance(GameActivityPresenter presenter) {
            this.presenter = presenter;
        }

        GameActivityPresenter getPresenter() {
            return presenter;
        }
    }
}
