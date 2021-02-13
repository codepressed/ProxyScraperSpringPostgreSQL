package com.rionacko.proxyScraperDB.proxy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProxyRepository extends JpaRepository<Proxy,Integer> {

    //SELECT * FROM proxy WHERE ip = ?
    @Query("SELECT s FROM Proxy s WHERE s.ip = ?1")
    Optional<Proxy> findProxyByIp(String ip);
}
