package com.example.sofit_android_task.ServicesFragment;

public class ModelClassService {


    public String getImageone() {
        return imageone;
    }

    public String getImagetwo() {
        return imagetwo;
    }

    public String getImagethree() {
        return imagethree;
    }

    public String getImagefour() {
        return imagefour;
    }



    String imageone,imagetwo,imagethree,imagefour;

    public ModelClassService(String imageone, String imagetwo, String imagethree, String imagefour) {
        this.imageone = imageone;
        this.imagetwo = imagetwo;
        this.imagethree = imagethree;
        this.imagefour = imagefour;

    }
}
