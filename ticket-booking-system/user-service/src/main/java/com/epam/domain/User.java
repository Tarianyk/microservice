package com.epam.domain;

import lombok.Getter;
import lombok.Setter;

public class User {
    /**
     * User Id. UNIQUE.
     */
    @Setter
    @Getter
    long id;
    @Setter
    @Getter
    String name;

    /**
     * User email. UNIQUE.
     */
    @Setter
    @Getter
    String email;
}
