package nl.fhict.sketchboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean mFabIsInCrossState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.main_appbar_layout);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TestRecyclerAdapter adapter = new TestRecyclerAdapter("RECENT DESIGN");
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TestRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String text) {
                startActivity(new Intent(MainActivity.this, CompositionActivity.class));
            }
        });

        final RecyclerView overlay = (RecyclerView)findViewById(R.id.main_overlay_recycler);
        overlay.setLayoutManager(new LinearLayoutManager(this));
        overlay.setAdapter(new TestRecyclerAdapter("NEW DESIGN"));

        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mFabIsInCrossState) {
                    appBarLayout.setExpanded(false);
                    mFabIsInCrossState = true;
                    overlay.setVisibility(View.VISIBLE);
                    fab.animate().rotation(-45f);
                } else {
                    mFabIsInCrossState = false;
                    overlay.setVisibility(View.GONE);
                    fab.animate().rotation(0f);
                }
            }
        });
    }
}
