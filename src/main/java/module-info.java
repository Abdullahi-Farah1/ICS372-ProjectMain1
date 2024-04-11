module aya.reviews.ics372projectmain1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens aya.reviews.ics372projectmain1 to javafx.fxml;
    exports aya.reviews.ics372projectmain1;
    exports aya.reviews.ics372projectmain1.database;
    opens aya.reviews.ics372projectmain1.database to javafx.fxml;
    exports aya.reviews.ics372projectmain1.datamodels;
    opens aya.reviews.ics372projectmain1.datamodels to javafx.fxml;
    exports aya.reviews.ics372projectmain1.view;
    opens aya.reviews.ics372projectmain1.view to javafx.fxml;
    exports aya.reviews.ics372projectmain1.control;
    opens aya.reviews.ics372projectmain1.control to javafx.fxml;
}