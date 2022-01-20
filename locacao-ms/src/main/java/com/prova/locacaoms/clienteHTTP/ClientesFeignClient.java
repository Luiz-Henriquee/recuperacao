package com.prova.locacaoms.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import com.prova.locacaoms.compartilhado.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "cliente-ms", fallback = ClientesFeignClientFallback.class)
public interface ClientesFeignClient {
    @GetMapping(path = "/api/clientes/{cliente}/lista")
    List<Cliente> obterClientes(@PathVariable String cliente);   
}

@Component
class ClientesFeignClientFallback implements ClientesFeignClient {

    @Override
    public List<Cliente> obterClientes(String cliente) {
        return new ArrayList<>();
    }

}
