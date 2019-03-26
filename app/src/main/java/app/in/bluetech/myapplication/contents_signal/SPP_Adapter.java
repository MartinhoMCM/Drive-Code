package app.in.bluetech.myapplication.contents_signal;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import app.in.bluetech.myapplication.R;

/**
 * Created by martinhocorreiamussamba on 25/02/19.
 */

public class SPP_Adapter extends RecyclerView.Adapter<SPP_Adapter.SSPViewHolder>   {

    Context context;
    LayoutInflater inflater ;
    Dialog  Mydialog;

    private ArrayList<SPerigo> perigoList;

    public SPP_Adapter(Context context, ArrayList<SPerigo> perigoList)
    {
        this.context=context;
        this.perigoList=perigoList;
    }

    @Override
    public SSPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        SSPViewHolder viewHolder = new SSPViewHolder(LayoutInflater.from(context).
                inflate(R.layout.item_perigo_signal, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SSPViewHolder holder, int position) {
          SPerigo current_signal =perigoList.get(position);

        holder.textView.setText(current_signal.getContent());
        Glide.with(context).load(current_signal.getImageRes()).override(100,200).
                into(holder.signal_image);
    }

    @Override
    public int getItemCount() {
        return perigoList.size();
    }

    public class SSPViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;
        private ImageView signal_image;

        public SSPViewHolder(View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.id_content);
            signal_image =itemView.findViewById(R.id.id_image);
        }


    }
}
