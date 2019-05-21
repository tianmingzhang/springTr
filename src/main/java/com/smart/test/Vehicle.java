package com.smart.test;

import javax.validation.constraints.Max;

public interface Vehicle {
    void drive(@Max(75) int speedInMph);
}
