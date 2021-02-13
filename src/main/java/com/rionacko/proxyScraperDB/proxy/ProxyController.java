package com.rionacko.proxyScraperDB.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/proxy")
public class ProxyController {
    private final ProxyService proxyService;

    @Autowired
    public ProxyController(ProxyService proxyService) { this.proxyService = proxyService; }

    @GetMapping
    public List<Proxy> getProxies(){ return proxyService.getProxies(); }

    @PostMapping(path = "post")
    public void registerNewProxy(@RequestBody Proxy proxy){
        proxyService.addNewProxy(proxy);
    }

    @DeleteMapping(path = "{proxyId}")
    public void deleteProxy(
            @PathVariable("proxyId") Integer proxyId){
    proxyService.deleteProxy(proxyId);
    }

    @PutMapping(path = "{proxyId}")
    public void updateProxy(
            @PathVariable("proxyId") Integer proxyId,
            @RequestParam(required = false) String ip,
            @RequestParam(required = false) Integer port,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String ms,
            @RequestParam(required = false) String proxyType,
            @RequestParam(required = false) String safety){
        proxyService.updateProxy(proxyId, ip, port, location, ms, proxyType, safety);
    }


}




