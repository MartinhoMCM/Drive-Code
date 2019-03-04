package app.in.bluetech.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ItemViewHolder> {

   private final List<ListItem> list_items;
   private Context context;
   private  ImageView image_slider;

   public ListItemAdapter (Context context, List<ListItem> list_items)
   {
        this.context =context;
        this.list_items=list_items;
   }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
     return  new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position)
    {
        ListItem listItem = list_items.get(position);
        holder.head.setText(listItem.getHead());
        holder.desc.setText(listItem.getDesc());
        Glide.with(context).load(listItem.getImageResource()).into(image_slider);
    }

    @Override
    public int getItemCount() {

      return list_items.size();

    }

    public class ItemViewHolder  extends RecyclerView.ViewHolder{

        public  final TextView head;
        public  final TextView  desc;

        public ItemViewHolder(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.wellcome_text);
            desc=itemView.findViewById(R.id.desc_text);
            image_slider =itemView.findViewById(R.id.image_slider);
        }
    }
}
