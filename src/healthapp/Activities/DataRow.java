/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Activities;

import java.time.LocalDate;

public class DataRow {
    private final LocalDate date;  // The date to be displayed
    private final Integer value;    // The integer value to be displayed

    // Constructor to initialize the date and value
    public DataRow(LocalDate date, Integer value) {
        this.date = date;
        this.value = value;
    }

    // Getter method for the date
    public LocalDate getDate() {
        return date;
    }

    // Getter method for the value
    public Integer getValue() {
        return value;
    }
}
