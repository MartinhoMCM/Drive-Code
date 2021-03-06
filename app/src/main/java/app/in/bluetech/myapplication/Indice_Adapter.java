package app.in.bluetech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.in.bluetech.myapplication.contents_signal.SinaisPerigoIntroducaoActivity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.SR_Activity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_cedenciaPassagem.SCedenciaPassagemActivity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_obrigacao.SobrigacaoActivity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinal_proibido.SproibicaoActivity;
import app.in.bluetech.myapplication.general_concepts.gereralTrafficSignalActivity;
import app.in.bluetech.myapplication.sinal_temporario.SinaTemporarioActivity;

public class Indice_Adapter extends RecyclerView.Adapter<Indice_Adapter.IndiceViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<IndiceInfo> infoList ;


    public Indice_Adapter(Context context, List<IndiceInfo> infoList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.infoList = infoList;
    }

    @Override
    public IndiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.list_indice_item, parent, false);
        return new IndiceViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(IndiceViewHolder holder, int position) {
          IndiceInfo indiceInfo = infoList.get(position);
          int number=position+1;
          holder.head.setText( number +". " +indiceInfo.getmTitle());
          holder.desc.setText(indiceInfo.getmSubtitle());
          holder.mCurrentPosition =position;
    }
    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class IndiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView head;
        private TextView desc;
        public int mCurrentPosition;

        public IndiceViewHolder(View itemView) {
            super(itemView);
            head =itemView.findViewById(R.id.head);
            desc=itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;


            if (mCurrentPosition==0)
            {
                context.startActivity(new Intent(context, SinaisPerigoIntroducaoActivity.class));
            }
            if(mCurrentPosition==5)
            {
                context.startActivity(new Intent(context, SinaTemporarioActivity.class));
            }
            if(mCurrentPosition==6)
            {
                intent = new Intent(context, SinaisPerigoIntroducaoActivity.class);
                intent.putExtra("title", infoList.get(mCurrentPosition).getmTitle());
                context.startActivity(intent);
            }
            else
            if(mCurrentPosition==7)
            {
                context.startActivity(new Intent(context, SR_Activity.class));
            }

            else
            if(mCurrentPosition==8)
            {
                context.startActivity(new Intent(context, SCedenciaPassagemActivity.class));
            }


            else if(mCurrentPosition==9)
                {
                    context.startActivity(new Intent(context, SproibicaoActivity.class));
                }
            else
                if(mCurrentPosition==10)
                {
                    context.startActivity(new Intent(context, SobrigacaoActivity.class));
                }

        }
    }


}
