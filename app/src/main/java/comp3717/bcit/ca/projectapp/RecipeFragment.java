package comp3717.bcit.ca.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import java.util.ArrayList;

public class RecipeFragment extends Fragment {
    private RecipeDbHelper dbhelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        dbhelper = new RecipeDbHelper(getActivity());
        // Set a recycle view for better display
        RecyclerView recipeRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_recipe, container, false);

        // Get all names and images from the recipe list
        ArrayList<Recipe> recipeList = (ArrayList)dbhelper.getAllRecipes();
        ArrayList<String> recipeCaptions = new ArrayList<>();
        ArrayList<String> recipeImages = new ArrayList<>();
        for (int i = 0; i < recipeList.size(); i++) {
            recipeCaptions.add(recipeList.get(i).getTitle());
            recipeImages.add(recipeList.get(i).getImagePath());
        }

        // Set the names and images as captioned images
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(recipeCaptions.toArray(new String[0]), recipeImages.toArray(new String[0]));
        recipeRecycler.setAdapter(adapter);

        // List items as a linear way
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recipeRecycler.setLayoutManager(layoutManager);

        // Call detail by clicking each item
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), RecipeFragmentDetail.class);

                // Put position info for detail
                intent.putExtra(RecipeFragmentDetail.EXTRA_RecipeTitle, position);
                getActivity().startActivity(intent);
            }
        });

        return recipeRecycler;
    }
}
