package org.java.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserinfoMapper {
    List<Map> userBylog(@Param("userlog") String userlog);

    List<Map> userMenu(@Param("roleid") String roleid);
}
