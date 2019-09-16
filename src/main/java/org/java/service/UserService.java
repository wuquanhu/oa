package org.java.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map userLogin(String principal);

    List<Map> userMenu(String roleid);
}
