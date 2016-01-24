package com.teamtreehouse.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamtreehouse.interactivestory.R;
import com.teamtreehouse.interactivestory.model.Page;
import com.teamtreehouse.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoiceA;
    private Button mChoiceB;
    private String mName;

    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if (mName == null) {
            mName = "Friend";
        }

        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoiceA = (Button) findViewById(R.id.choiceButtonA);
        mChoiceB = (Button) findViewById(R.id.choiceButtonB);

        loadPage(0);
    }

    private void loadPage(int index) {
        mCurrentPage = mStory.getPage(index);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String text = String.format(mCurrentPage.getText(), mName);
        mTextView.setText(text);

        if (mCurrentPage.isLast()) {
            mChoiceA.setVisibility(View.INVISIBLE);
            mChoiceB.setText("PLAY AGAIN");

            mChoiceB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            mChoiceA.setText(mCurrentPage.getChoiceA().getText());
            mChoiceB.setText(mCurrentPage.getChoiceB().getText());

            mChoiceA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoiceA().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoiceB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoiceB().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
