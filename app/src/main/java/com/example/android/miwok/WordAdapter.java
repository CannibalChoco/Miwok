package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.text_container;

/**
 * Created by Kristine on 02.05.2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int backgroundColor;
    /**
     * Create a new object
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in
     * @param words is the list of words{@link Word}s to be displayed
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundResource) {
        /**
         * https://developer.android.com/reference/android/widget/ArrayAdapter.html
         * ArrayAdapter(Context context, int resource, List<T> objects);
         *
         * int resourcwe == 0, because we will create the views ourselves
         */
        super(context, 0, words);
        backgroundColor = backgroundResource;
    }

    /**
     * getView method is called when the ListView is trying to display a list of items at
     * a given position
     *
     * @param position
     * @param convertView a potential view that could be converted
     * @param parent is the parent view group for all the list items (which is the ListView)
     * @return the listItemView (to the listView)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml laypout with the ID text_miwok
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.text_miwok);
        /** Get the miwok translation from the currentWord object and set this
         * text on the miwok TextView
         * */
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml laypout with the ID text_default
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.text_default);
        /** Get the default translation from the currentWord object and set this
         * text on the default TextView
         * */
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml laypout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()){
            // Get the image from the currentWord object and set this image on the ImageView
            iconView.setImageResource(currentWord.getImageResourceId());
            // Because the views get reused, make sure this view is visible
            iconView.setVisibility(View.VISIBLE);
        }
        else{
            // hide the ImageView completely
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
