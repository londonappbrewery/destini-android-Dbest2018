package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyText;
    private Button topButton;
    private Button downButton;

    int myStoryIndex = 1;

    StoryLine[] storyLines = {new StoryLine(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryLine(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryLine(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new StoryLine(R.string.T4_End),
            new StoryLine(R.string.T5_End),
            new StoryLine(R.string.T6_End)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        downButton = findViewById(R.id.buttonBottom);

        if (savedInstanceState != null){
            myStoryIndex = savedInstanceState.getInt("IndexKey");
            changeStory(myStoryIndex);
        }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the top button is clicked for story one, jump to story three
                // when the top button is clicked for story two, jump to story three
                if (myStoryIndex == 1 || myStoryIndex == 2){
                    myStoryIndex = 3;
                    changeStory(myStoryIndex);
                }
                // when the top button is clicked for story three , jump to story six
                else if (myStoryIndex == 3){
                    myStoryIndex = 6;
                    changeStory(myStoryIndex);
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the bottom button is clicked for story one, jump to story two
                if (myStoryIndex == 1){
                    myStoryIndex = 2;
                    changeStory(myStoryIndex);
                }
                // when the bottom button is clicked for story two, jump to story four
                else if (myStoryIndex == 2){
                    myStoryIndex = 4;
                    changeStory(myStoryIndex);
                }
                // when the bottom button is clicked for story three, jump to story five
                else if (myStoryIndex == 3){
                    myStoryIndex = 5;
                    changeStory(myStoryIndex);
                }
            }
        });



    }

    private void changeStory(int storyIndex){
        storyText.setText(storyLines[storyIndex-1].getStoryTextID());

        if (storyLines[storyIndex-1].getTopOption() != 0 && storyLines[storyIndex-1].getTopOption() != 0){
            topButton.setText(storyLines[storyIndex-1].getTopOption());
            downButton.setText(storyLines[storyIndex-1].getBottomOption());
        }
        else{
            topButton.setVisibility(View.INVISIBLE);
            downButton.setVisibility(View.INVISIBLE);
        }

    }

    // TODO: cater for if the device is rotated ie save the state of the app

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", myStoryIndex);
    }
}
