package comp3717.bcit.ca.projectapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainFragment extends Fragment {
    private RecipeDbHelper dbhelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbhelper = new RecipeDbHelper(getActivity());
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment_main, container, false);

        // Display a sample recipe on the main page
        RecyclerView recipeRecycler = (RecyclerView)layout.findViewById(R.id.recipe_recycler);
        Recipe recipe = dbhelper.getRecipe(0);
        final String[]recipeName = new String[0];
        recipeName[0]=recipe.getTitle();
        final String [] recipeImage = new String[0];
        recipeImage[0] = recipe.getImagePath();

        // Set the names and images as captioned images
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(recipeName, recipeImage);
        recipeRecycler.setAdapter(adapter);

        // List items as a linear way
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recipeRecycler.setLayoutManager(layoutManager);

        // Call detail by clicking each item
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
                public void onClick(int position) {
                    Intent intent = new Intent(getActivity(), RecipeFragmentDetail.class);
                    // Put position info for detail
                    intent.putExtra(RecipeFragmentDetail.EXTRA_RecipeNo, recipeName);
                    getActivity().startActivity(intent);
                }
        });

        //create button onclickListener
        final Button add = (Button)layout.findViewById(R.id.add_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CreateActivity.class);
                startActivity(intent);
            }
        });

        return layout;
    }
}
