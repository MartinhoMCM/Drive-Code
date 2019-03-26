package app.in.bluetech.indices.sampledata.sinais_de_perigo;

import android.content.Context;
import android.support.v4.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.in.bluetech.myapplication.R;

/**
 * Created by martinhocorreiamussamba on 16/03/19.
 */

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private   LayoutInflater inflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    public int [] slides_images =
    {
            R.drawable.traffic_cone,
            R.drawable.wellcome_2,
            R.drawable.wellocome_3
    };

    public String [] slides_heading =
            {

                  "Tudo fica mais fácil",
                  "Código atualizado",
                    "Prepara-se para o exame"


            };

    public String[] slides_desc=
            {
                    "Com a app DriveCode instalado podes estudar códigos de estrada em qualquer lugar",
                    "DriveCode fornece códigos atualizados",
                    "DriveCode permite fazer pré-exama para veres o teu nível de preparação"
            };

    @Override
    public int getCount() {
        return slides_desc.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view ==(RelativeLayout)object );
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideimageview =view.findViewById(R.id.slide_image);
        TextView slide_headline=view.findViewById(R.id.head_sliderText);
        TextView slide_desc =view.findViewById(R.id.desc_sliderText);


        Glide.with(view.getContext()).load(slides_images[position]).into(slideimageview);
      //  slideimageview.setImageResource(slides_images[position]);
        slide_headline.setText(slides_heading[position]);
        slide_desc.setText(slides_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
