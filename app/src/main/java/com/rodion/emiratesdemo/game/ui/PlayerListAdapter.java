package com.rodion.emiratesdemo.game.ui;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rodion.emiratesdemo.R;
import com.rodion.emiratesdemo.game.model.Player;

import java.util.List;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {

    private List<Player> data;

    PlayerListAdapter() {}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final ViewGroup scoreContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.name);
            scoreContainer = itemView.findViewById(R.id.score_container);
        }

        public void bind(Player player) {
            // Set player name
            titleView.setText(player.getTitle());

            // Set player scores
            scoreContainer.removeAllViews();
            for(Integer score : player.getScorer().getImmutableScoreList()) {
                View view = LayoutInflater.from(titleView.getContext())
                        .inflate(R.layout.score_view, scoreContainer, false);
                TextView scoreView = view.findViewById(R.id.score_value);
                scoreView.setText(score.toString());
                scoreContainer.addView(view);
            }
        }
    }


    public void setData(List<Player> data) {
        this.data = data;
    }

}
