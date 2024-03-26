package br.com.surb.projectclient.shared.exeptions.service;

public class ServiceDataIntegrityViolationException extends RuntimeException {
    public ServiceDataIntegrityViolationException(String msg){
        super(msg);
    }
}
