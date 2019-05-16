package us.floydasaur.layouts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textMovieTitle,  textMovieDescription,
             textMovieWriter, textMovieDirector;
    LinearLayout layoutCastList;
    private Context context;
    String movieTitle = "Pokémon Detective Pikachu (2019)";
    String writerName = "Nicole Perlman";
    String directorName = "Rob Letterman";
    String movieDescription =   "In a world where people collect pocket-size monsters (Pokémon) " +
                                "to do battle, a boy comes across an intelligent monster who "    +
                                "seeks to be a detective.";
    String castArray[][] = {
            {"Ryan Reynolds", "Detective Pikachu"},
            {"Justice Smith", "Tim Goodman"},
            {"Kathryn Newton", "Lucy Stevens"},
            {"Bill Nighy", "Howard Clifford"},
            {"Ken Watanabe", "Lieutenant Hide Yoshida"},
            {"Chris Geere", "Roger Clifford"},
            {"Suki Waterhouse", "Ms. Norman"},
            {"Josette Simon", "Grams"},
            {"Alejandro De Masa", "Bartender"},
            {"Rita Ora", "Dr. Ann Laurent"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        textMovieTitle       = findViewById(R.id.text_movie_title);
        textMovieDirector    = findViewById(R.id.text_movie_director);
        textMovieWriter      = findViewById(R.id.text_movie_writer);
        textMovieDescription = findViewById(R.id.text_movie_description);
        layoutCastList       = findViewById(R.id.layout_cast_list);

        textMovieTitle.setText(movieTitle);
        textMovieDirector.setText(directorName);
        textMovieWriter.setText(writerName);
        textMovieDescription.setText(movieDescription);

        for(int i = 0; i < castArray.length; i++){
            layoutCastList.addView(generateCast(i));
        }
    }

    private LinearLayout generateCast(int i){
        LinearLayout actorRoleRow = new LinearLayout(context);
        TextView actor = new TextView(context);
        TextView role = new TextView(context);

        actor.setText(castArray[i][0]);
        actor.setTextSize(20);
        actor.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        actor.setPadding(5,0,15,0);
        role.setText(castArray[i][1]);
        role.setTextSize(18);
        role.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        role.setLayoutParams(new TableLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1f));

        actorRoleRow.addView(actor);
        actorRoleRow.addView(role);
        return actorRoleRow;
    }
}