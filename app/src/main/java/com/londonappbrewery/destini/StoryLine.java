package com.londonappbrewery.destini;

public class StoryLine {
    private int storyTextID;
    private int topOption;
    private int bottomOption;

    public StoryLine(int storyTextID, int topOption, int bottomOption) {
        this.storyTextID = storyTextID;
        this.topOption = topOption;
        this.bottomOption = bottomOption;
    }
    public StoryLine(int storyTextID){
        this(storyTextID,0,0);
    }

    public int getStoryTextID() {
        return storyTextID;
    }

    public void setStoryTextID(int storyTextID) {
        this.storyTextID = storyTextID;
    }

    public int getTopOption() {
        return topOption;
    }

    public void setTopOption(int topOption) {
        this.topOption = topOption;
    }

    public int getBottomOption() {
        return bottomOption;
    }

    public void setBottomOption(int bottomOption) {
        this.bottomOption = bottomOption;
    }
}
