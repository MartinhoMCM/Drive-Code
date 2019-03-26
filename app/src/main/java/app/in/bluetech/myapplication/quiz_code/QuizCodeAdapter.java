package app.in.bluetech.myapplication.quiz_code;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.in.bluetech.myapplication.*;

/**
 * Created by martinhocorreiamussamba on 25/03/19.
 */

public class QuizCodeAdapter extends PagerAdapter{

    private  Context mContext;
    private LayoutInflater inflater;
    List<QuizCode> codeList;


    public QuizCodeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return codeList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    /*** Context mContext;
    List<QuizCode> codeList;


    public QuizCodeAdapter(Context mContext, List<QuizCode> codeList) {
        this.mContext = mContext;
        this.codeList =codeList;
    }

    @Override
    public QuizCodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_quiz, parent, false);
        QuizCodeViewHolder viewHolder = new QuizCodeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuizCodeViewHolder holder, int position) {

        holder.BfirstHolder.setText(codeList.get(position).getBfirst());
        holder.BsecondHolder.setText(codeList.get(position).getBsecond());
        holder.BthirdtHolder.setText(codeList.get(position).getBthird());
        Glide.with(mContext).load(codeList.get(position).getQuiz_image()).override(100,100).into(holder.Quiz_img);

    }

    @Override
    public int getItemCount() {
        return codeList.size();
    }


    public class QuizCodeViewHolder extends RecyclerView.ViewHolder
    {

        Button BfirstHolder;
        Button BsecondHolder;
        Button BthirdtHolder;
        ImageView Quiz_img;

        public QuizCodeViewHolder(View itemView) {
            super(itemView);

            BfirstHolder =itemView.findViewById(R.id.button_quiz1);
            BsecondHolder =itemView.findViewById(R.id.button_quiz2);
            BthirdtHolder =itemView.findViewById(R.id.button_quiz3);
            Quiz_img = itemView.findViewById(R.id.quiz_img);
        }
    }
    **/
}
