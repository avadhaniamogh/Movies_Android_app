package amogh.org.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import amogh.org.retrofit.R;
import amogh.org.retrofit.model.Movie;

import static amogh.org.retrofit.util.Util.IMAGE_URL_BASE_PATH;

/**
 * Created by Amogh on 2/14/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private List<Movie> movies;

    private Context mContext;

    public static class MoviesHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        ImageView movieImage;
        TextView title;
        TextView date;
        TextView description;
        TextView rating;

        public MoviesHolder(View itemView) {
            super(itemView);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            description = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        mContext = context;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MoviesHolder(v);
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.with(mContext)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);

        holder.title.setText(movies.get(position).getTitle());
        holder.date.setText(movies.get(position).getReleaseDate());
        holder.description.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
