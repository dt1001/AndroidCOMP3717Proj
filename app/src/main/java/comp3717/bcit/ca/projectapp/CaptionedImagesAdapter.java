package comp3717.bcit.ca.projectapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private byte[][] image;
    private String[] caption;
    private Listener listener;

    public interface Listener {
        void onClick(int position);
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView=v;
        }
    }

    public CaptionedImagesAdapter(String []caption, byte[][]image){
        this.image=image;
        this.caption=caption;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    // Set view holder
    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;

        // Set view holder with displaying name and image
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        //Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        //imageView.setImageDrawable(drawable);
        Bitmap bitmap = BitmapFactory.decodeByteArray(image[0],0,image[0].length);
        imageView.setImageBitmap(bitmap);

        // Set caption text
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(caption[0]);

        // Display detail after click
        cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(position);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return caption.length;
    }
}
