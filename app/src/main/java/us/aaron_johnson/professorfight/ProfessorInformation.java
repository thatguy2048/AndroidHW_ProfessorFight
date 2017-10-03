package us.aaron_johnson.professorfight;

import android.media.Image;

/**
 * Created by combu on 9/28/2017.
 */

public class ProfessorInformation {
    String name;
    String description;
    int imageResourceId = -1;

    public ProfessorInformation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProfessorInformation(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
}
