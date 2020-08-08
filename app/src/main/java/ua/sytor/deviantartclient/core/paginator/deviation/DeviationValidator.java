package ua.sytor.deviantartclient.core.paginator.deviation;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.paginator.PaginatorContract;

public class DeviationValidator implements PaginatorContract.Validator<Deviation> {

    @Inject
    public DeviationValidator() {
    }

    @Override
    public boolean isValid(Deviation value) {
        Logger.log("validating deviation %s", value);
        return !(value.getContent() == null || value.getContent().getSrc() == null);
    }

}
