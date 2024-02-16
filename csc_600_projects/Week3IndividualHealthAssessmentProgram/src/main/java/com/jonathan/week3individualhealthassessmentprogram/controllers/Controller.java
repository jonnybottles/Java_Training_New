package com.jonathan.week3individualhealthassessmentprogram.controllers;

import com.jonathan.week3individualhealthassessmentprogram.services.HealthAssessmentServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    private HealthAssessmentServices theHealthAssessmentServices;


    public void initialize() {
        theHealthAssessmentServices = new HealthAssessmentServices();
    }


}