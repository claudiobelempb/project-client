package br.com.surb.projectclient.dto;

import br.com.surb.projectclient.entities.Client;
import br.com.surb.projectclient.shared.constants.ConstantValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO

 implements Serializable {

    @Serial
    private static final long serialVersionUID = 8251283576416987568L;

    private Long id;
    @NotBlank(message = ConstantValidator.REQUIRED_FIELD)
    private String name;
    private String cpf;
    @PastOrPresent(message = ConstantValidator.REQUIRED_DATA_PRESENT)
    private LocalDate birthDate;
    private Double income;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, LocalDate birthDate, Double income, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.income = income;
        this.children = children;
    }

    public ClientDTO(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        birthDate = entity.getBirthDate();
        income = entity.getIncome();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) object;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
