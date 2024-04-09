module aya.reviews.ics372projectmain1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens aya.reviews.ics372projectmain1 to javafx.fxml;
    exports aya.reviews.ics372projectmain1;
    exports aya.reviews.ics372projectmain1.database;
    opens aya.reviews.ics372projectmain1.database to javafx.fxml;
    exports aya.reviews.ics372projectmain1.datamodels;
    opens aya.reviews.ics372projectmain1.datamodels to javafx.fxml;
    exports aya.reviews.ics372projectmain1.uimodels;
    opens aya.reviews.ics372projectmain1.uimodels to javafx.fxml;
}