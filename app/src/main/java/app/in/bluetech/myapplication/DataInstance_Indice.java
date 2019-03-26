package app.in.bluetech.myapplication;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.myapplication.contents_signal.SPerigo;

/**
 * Created by martinhocorreiamussamba on 24/02/19.
 */

public class DataInstance_Indice {

    public static DataInstance_Indice ourInstance =null;

    private List<IndiceInfo> mNotes = new ArrayList<>();
    private  List<SPerigo> list_perigo = new ArrayList<>();

    public static DataInstance_Indice getInstance()
    {
        if(ourInstance==null)
        {
            ourInstance = new DataInstance_Indice();
            ourInstance.InitializeIndiceContent();
         //   ourInstance.InitializeDangerContent();

        }
        return ourInstance;
    }
    public void InitializeIndiceContent()
    {

       // final DataInstance_Indice dm =getInstance();

        mNotes.add(new IndiceInfo("Código de Estrada", "Conceitos Gerais"));
        mNotes.add( new IndiceInfo("Elementos do Sistema Rodoviário", "Normas"));
        mNotes.add(new IndiceInfo("Vias", "Sua classificação e elementos"));
        mNotes.add(new IndiceInfo("Veículos automóveis", "Sua classificação e elementos"));
        mNotes.add(new IndiceInfo("Função da condução. Tempo de Reação", "Distâncias de segurança, de travagem e de paragem"));
        mNotes.add(new IndiceInfo("Sinalização Temporária", "Marcas Rodoviárias. Sinais Verticais. Sinalização luminosa"));
        mNotes.add(new IndiceInfo("Sinais de perigo", "Conceitos "));
        mNotes.add(new IndiceInfo("Sinais de regulamentação", "Conceitos "));
        mNotes.add(new IndiceInfo("Sinais de cedência de passagem", "Conceitos "));
        mNotes.add(new IndiceInfo("Sinais de proibição", "Conceitos "));
        mNotes.add(new IndiceInfo("Sinais de obrigação", "Conceitos "));
        mNotes.add(new IndiceInfo("Sinais de prescrição específica", "Sinais de Seleção de Vias. Sinais de afectação de vias. Sinais de zona "));

    }

    public List<IndiceInfo> getIndice()
    {
        return  mNotes;
    }

    public List<SPerigo> getList_perigo()
    {
        return list_perigo;
    }

}
