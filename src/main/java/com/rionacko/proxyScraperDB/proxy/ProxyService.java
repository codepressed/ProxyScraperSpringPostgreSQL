package com.rionacko.proxyScraperDB.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProxyService {

    private final ProxyRepository proxyRepository;

    @Autowired
    public ProxyService(ProxyRepository proxyRepository){ this.proxyRepository = proxyRepository; }

    public List<Proxy> getProxies() { return proxyRepository.findAll();
    }

    public void addNewProxy(Proxy proxy) {
        Optional<Proxy> proxyOptional = proxyRepository
                .findProxyByIp(proxy.getIp());
        if (proxyOptional.isPresent()){
            throw new IllegalStateException("IP already saved");
        }
        proxyRepository.save(proxy);
    }

    public void deleteProxy(Integer proxyId) {
        boolean exists = proxyRepository.existsById(proxyId);
        if(!exists) {
            throw new IllegalStateException("Proxy with id " + proxyId + " does no exist in our DB.");
        }
        proxyRepository.deleteById(proxyId);
    }

    public void deleteAllProxy(){
        proxyRepository.deleteAll();
    }

    @Transactional
    public void updateProxy(Integer proxyId, String ip, Integer port, String location, String ms, String proxyType, String safety) {
        Proxy proxy = proxyRepository.findById(proxyId).orElseThrow(() -> new IllegalStateException(
                "Proxy with the id " + proxyId + "does not exist in our DB")
        );
        if(ip != null && ip.length() > 0 && !Objects.equals(proxy.getIp(), ip)){
            proxy.setIp(ip);
        }
        if(port != null && !Objects.equals(proxy.getPort(), port)){
            proxy.setPort(port);
        }
        if(location != null && location.length() > 0 && !Objects.equals(proxy.getLocation(), location)){
            proxy.setLocation(location);
        }
        if(ms != null && ms.length() > 0 && !Objects.equals(proxy.getMs(), ms)){
            proxy.setMs(ms);
        }
        if(proxyType != null && proxyType.length() > 0 && !Objects.equals(proxy.getProxyType(), proxyType)){
            proxy.setProxyType(proxyType);
        }
        if(safety != null && safety.length() > 0 && !Objects.equals(proxy.getSafety(), safety)){
            proxy.setSafety(safety);
        }



    }
}
