package com.twaattin.authentication;

import java.security.Principal;

public class User implements Principal {

private final String name;

/**
* Only {@link UserPasswordAuthenticationStrategy} may create new instances.
*
* @param name
*/
User(String name) {

this.name = name;
}

@Override
public String getName() {

return name;
}
}
