package com.smart.test;

import javax.validation.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableValidator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

public class Car  {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    @AssertTrue(
            message = "The car has to pass the vehicle inspection first",
            groups = CarChecks.class
    )
    private boolean passedVehicleInspection;

    @Valid
    private Driver driver;


    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    public boolean isPassedVehicleInspection() {
        return passedVehicleInspection;
    }

    public void setPassedVehicleInspection(boolean passedVehicleInspection) {
        this.passedVehicleInspection = passedVehicleInspection;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
//    public void drive(int speedInMph) {
//        System.out.println("passed!");
//    }
//    public void drive1(@Max(value = 75,message = "Price{}  must not be higher than ${value},Inputed value is ${validatedValue}") int speedInMph) {
//        System.out.println("passed!");
//    }

}
