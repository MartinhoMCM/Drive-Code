package app.in.bluetech.myapplication.quiz_code;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.in.bluetech.myapplication.*;

/**
 * Created by martinhocorreiamussamba on 30/03/19.
 */



public class ListLevelQuiz extends RecyclerView.Adapter<ListLevelQuiz.ViewHolder> {

    public Context context;
    public ArrayList<String> questionaro_list;

    public ListLevelQuiz(Context context, ArrayList<String> questionaro_list) {
        this.context = context;
        this.questionaro_list = questionaro_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_quiz, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.questionario.setText(questionaro_list.get(position));
         holder.mCurrentPosition =position;
    }

    @Override
    public int getItemCount() {
        return questionaro_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView questionario;
        int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);

            questionario =itemView.findViewById(R.id.questionario);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(mCurrentPosition==0)
            {
                context.startActivity(new Intent(context.getApplicationContext(), QuizCodeActivity.class));
            }
            else
            {
               Toast.makeText(context,  "Não está disponível", Toast.LENGTH_LONG).show();
            }
        }
    }
}
