package br.com.surb.projectclient.shared.validation;

import br.com.surb.projectclient.shared.exeptions.CustomError;
import br.com.surb.projectclient.shared.exeptions.FieldMessage;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError implements Serializable {

    @Serial
    private static final long serialVersionUID = -6407490236434397358L;

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError(String filedName, String message) {
        errors.add(new FieldMessage(filedName, message));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
}
